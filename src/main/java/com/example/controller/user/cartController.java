package com.example.controller.user;//package com.example.controller;

import com.example.common.R;
import com.example.entity.Cart;
import com.example.entity.ProductCart;
import com.example.exception.CustomException;
import com.example.mapper.CartMapper;
import com.example.mapper.ProductCartMapper;
import com.example.mapper.ProductMapper;
import com.example.mapper.UserMapper;
import com.example.vo.CartVo;
import com.example.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Component("userCartController")
@RestController
@RequestMapping("/user/cart")
public class cartController {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductCartMapper productCartMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取个人购物车
     * @return
     */
    @GetMapping("/getByUserId/{userId}")
    public CartVo getUserCart(@PathVariable Integer userId) {

        CartVo cartVo = new CartVo();
        System.out.println("后端getUserCart方法运行");

        //通过userId获取购物车id
        Integer cartID =  cartMapper.getCartID(userId);
//        System.out.println("cartID:"+cartID);

        cartVo.setCart_id(cartID);

        //新建一个ProductVo对象列表
        List<ProductVo> productVoList= new ArrayList<>();


        //原始有重复数字的productID列表
        List<Integer> productIdList = productCartMapper.getList(cartID);
        Set productIdSet=new HashSet();
        productIdSet.addAll(productIdList);
        //转化后无重复的productID列表
        List<Integer> productIdList1=new ArrayList<>();
        for (Object value :productIdSet) {
            productIdList1.add((Integer) value);
        }

//        System.out.println(productIdList1.size());
//        System.out.println(productIdSet.size());


        //下面通过productIdList来为每个productVo赋值
        for (int i = 0; i < productIdList1.size(); i++){
            ProductVo productVo = productCartMapper.getProductVo(productIdList1.get(i));//为每个Vo对象新建一个封装
            productVo.setProduct_id(productIdList1.get(i));
            productVo.setBuy_num(productCartMapper.getNumByProductId(productIdList1.get(i)));//设置原模板已购买数量
//            System.out.println("创建的每个对象:"+productVo);
            productVoList.add(productVo);
        }

//        System.out.println("外部productVoList:"+productVoList);


        //通过productIdList的索引,循环获取productVo对象列表
        for (int i = 0; i < productIdList1.size(); i++) {
            //购物车的商品信息展示(包括书名,图片)和他的价格(product表)
            productVoList.get(i).setProduct_price(productMapper.getPriceByProductId(productIdList1.get(i)));
            productVoList.get(i).setProduct_name(productMapper.getProductNameByProductId(productIdList1.get(i)));
            productVoList.get(i).setImage_url(productMapper.getImgByProductId(productIdList1.get(i)));
        }
        //将产品对象列表添加到cartVo对象中
        cartVo.setProductVoList(productVoList);

        //给cartVo对象赋予总价
        BigDecimal total_price = productCartMapper.getAllPrice(cartID);
        cartVo.setTotal_price(total_price);

        System.out.println("cartVo:"+cartVo);
        //通过cartId获取购物车信息
        return cartVo;
    }

    /**
     * 增加购物车,一个用户只能是一张购物车
     * @param user_id
     * @param product_id
     * @return
     */
    @GetMapping("/addCart/{user_id}/{product_id}")
    public Cart addUserCart(@PathVariable("user_id") Integer user_id, @PathVariable("product_id") Integer product_id) {

        //添加一条productCart一个一(cart)对多(product)的数据,首次添加一个商品的时候就创建购物车了
        ProductCart  productCart = new ProductCart();
        productCart.setProduct_id(product_id);//productCart表中插入商品id

        //如果购物车不存在,则创建一个购物车
        if (cartMapper.getUserCart(user_id)==null){
            Cart cart = new Cart();//插入一个购物车表数据,主要功能是用于计算所有商品对应数量和类型下的总额
            cart.setUser_id(user_id);
            cart.setStatus("购物车已创建!");
            cartMapper.addCart(cart);//新建购物车,先不用修改总额

            //productCart表商品价格插入
            BigDecimal price = productMapper.getPriceByProductId(product_id);
            productCart.setProduct_price(price);
            productCart.setCart_id(cartMapper.getUserCart(user_id).getCart_id());
            productCartMapper.addProductCart(productCart);//新建productCart

            //在productCart表中计算总额,在插入Cart表
            BigDecimal allPrice = productCartMapper.getAllPrice(cartMapper.getUserCart(user_id).getCart_id());

            //修改总额属性值,需要先查询购物车
            Cart cart1 = cartMapper.getUserCart(user_id);
            BeanUtils.copyProperties(cart,cart1);
            cart1.setTotal_price(allPrice);
            cartMapper.updateCart(cart1);//更新购物车总额


        }else {
            //如果购物车存在,则直接添加商品,则productCart表插入新数据, cart表修改总额数据
            System.out.println("购物车已存在");
            BigDecimal price = productMapper.getPriceByProductId(product_id);
            productCart.setProduct_price(price);
            productCart.setCart_id(cartMapper.getUserCart(user_id).getCart_id());
            productCartMapper.addProductCart(productCart);//新建productCart

            //在productCart表中计算总额,在插入Cart表
            BigDecimal allPrice = productCartMapper.getAllPrice(cartMapper.getUserCart(user_id).getCart_id());

            //修改总额属性值,需要先查询购物车
            Cart cart1 = cartMapper.getUserCart(user_id);
            BeanUtils.copyProperties(cart1,cart1);
            cart1.setTotal_price(allPrice);
            cartMapper.updateCart(cart1);//更新购物车总额

        }
            return cartMapper.getUserCart(user_id);
    }


    //修改操作包括(商品+1和-1或者直接删除),根据productCart表中的product_id和cart_id进行修改数据
    /**
     * 商品+1
     * @param cart_id
     * @param product_id
     * @return
     */
    @PutMapping("/addProduct/{cart_id}/{product_id}")
    public String addProduct(@PathVariable("cart_id") Integer cart_id, @PathVariable("product_id") Integer product_id) {
        try {
            System.out.println("后端接收：cart_id:"+cart_id);
            System.out.println("后端接收：product_id:"+product_id);
            ProductCart productCart=new ProductCart();
            productCart.setCart_id(cart_id);
            productCart.setProduct_id(product_id);

            BigDecimal  price=productMapper.getPriceByProductId(product_id);
            productCart.setProduct_price(price);
            productCartMapper.addProductCart(productCart);//新建productCart
            System.out.println("后端add方法运行成功");
            return "商品+1成功!";
        } catch (Exception e) {
            return "商品+1失败!";
        }
    }


    /**
     * 商品-1
     * @param cart_id
     * @return
     */
    @DeleteMapping("/minusProduct/{cart_id}/{product_id}")
    public String minusProduct(@PathVariable("cart_id") Integer cart_id,@PathVariable("product_id") Integer product_id) {
        try {
            Boolean flag= productCartMapper.minusProductCart(cart_id);
            if (!flag) {
                throw new CustomException("商品数量不能小于1!");
            }
            System.out.println("后端minus方法运行成功");
            return "商品-1成功!";
        } catch (Exception e) {
            return "商品-1失败!";
        }
    }

    /**
     * 删除购物车中的指定商品数据
     * @param cart_id
     * @param product_id
     * @return
     */
    @DeleteMapping("/deleteProduct/{cart_id}/{product_id}")
    public R<String> deleteProduct(@PathVariable("cart_id") Integer cart_id, @PathVariable("product_id") Integer product_id) {
            System.out.println("111111111111111111");
            Boolean flag=productCartMapper.deleteProductCart(cart_id,product_id);
            System.out.println("flag = " + flag);
            return R.success("删除购物车内商品成功!");
    }

    /**
     * 清空购物车
     * @param cart_id
     * @return
     */
    @DeleteMapping("/delete/{cart_id}")
    public String deleteUserCart(@PathVariable("cart_id") Integer cart_id) {
        try {
            cartMapper.deleteCart(cart_id);
            return "购物车已清空!";
        } catch (Exception e) {
            return "购物车清空失败!";
        }
    }

    //删除product_cart里的数据
    @GetMapping("/deleteProductCart/{cart_id}")
    public String deleteProductCart(@PathVariable("cart_id") Integer cart_id) {
        try {
            productCartMapper.deleteProductCartData(cart_id);
            System.out.println(cart_id);
            System.out.println("删除product_cart里的数据");
            return "购物车已清空!";
        } catch (Exception e) {
            return "购物车清空失败!";
        }
    }

}

