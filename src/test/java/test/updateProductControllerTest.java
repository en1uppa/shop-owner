package test;

//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import com.example.controller.keeper.productController;
//import com.example.entity.Product;
//import com.example.mapper.ProductMapper;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class updateProductControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private ProductMapper productMapper;
//
//    @InjectMocks
//    private productController productController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @Test
//    public void update_ValidProduct_ShouldReturnOk() throws Exception {
//        // 模拟有效产品数据
//        Product product = new Product();
//        product.setProduct_id(1);
//        product.setProduct_name("Test Product");
//        product.setProduct_price(new BigDecimal("10.00"));
//        product.setProduct_num(100);
//        product.setDescription("Test Description");
//        product.setImage_url("http://test.com");
//        product.setProduct_type("Test Type");
//
//        // 模拟 productMapper 返回更新成功的情况
//        when(productMapper.updateProduct(product)).thenReturn(1);
//
//        mockMvc.perform(put("/keeper/product/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product_id\":1,\"product_name\":\"Test Product\",\"product_price\":10.00,\"product_num\":100,\"description\":\"Test Description\",\"image_url\":\"http://test.com\",\"product_type\":\"Test Type\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("{\"code\":200,\"message\":\"更新成功\",\"data\":null}"));
//    }
//
//    @Test
//    public void update_InvalidProduct_ShouldReturnBadRequest() throws Exception {
//        // 传递一个缺少必需字段的产品数据
//        mockMvc.perform(put("/keeper/product/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product_id\":1}")) // 缺少其他字段
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    public void update_UpdateFails_ShouldReturnInternalServerError() throws Exception {
//        // 模拟产品数据
//        Product product = new Product();
//        product.setProduct_id(1);
//        product.setProduct_name("Test Product");
//        product.setProduct_price(new BigDecimal("10.00"));
//        product.setProduct_num(100);
//        product.setDescription("Test Description");
//        product.setImage_url("http://test.com");
//        product.setProduct_type("Test Type");
//
//        // 模拟 productMapper 返回更新失败的情况
//        when(productMapper.updateProduct(product)).thenReturn(0);
//
//        mockMvc.perform(put("/keeper/product/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product_id\":1,\"product_name\":\"Test Product\",\"product_price\":10.00,\"product_num\":100,\"description\":\"Test Description\",\"image_url\":\"http://test.com\",\"product_type\":\"Test Type\"}"))
//                .andExpect(status().isInternalServerError())
//                .andExpect(content().string("{\"code\":500,\"message\":\"更新失败\",\"data\":null}"));
//    }
//}
