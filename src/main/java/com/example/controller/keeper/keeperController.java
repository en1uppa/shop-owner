package com.example.controller.keeper;//package com.example.controller;
import com.example.common.R;
import com.example.entity.Keeper;
import com.example.mapper.KeeperMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Component("keeperKeeperController")
@RestController
@RequestMapping("/keeper/keeper")
public class keeperController {

    @Autowired
    private KeeperMapper keeperMapper;


    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Integer login(@RequestBody Keeper user) {
        Keeper keeper=new Keeper();
        keeper.setKeeper_name(user.getKeeper_name());
        keeper.setPassword(user.getPassword());
        //查询不到,设置为0
        if (keeperMapper.login(keeper) == null) {
            return 0;
        }else{
            return keeperMapper.login(keeper);
        }
    }


    /**
     * 获取店家信息
     * @return
     */
    @GetMapping("/get")
    public Keeper getKeeperForKeeper() {
        return keeperMapper.getKeeperForKeeper();
    }




    /**
     *  修改店家信息
     * @return
     */
    @PutMapping("/update")
    public R<String> update(@RequestBody Keeper keeper) {
        Keeper keeper1 = new Keeper();
        BeanUtils.copyProperties(keeper,keeper1);
        keeperMapper.updateKeeper(keeper1);
        return R.success("修改成功!");
    }

    /**
     *  修改店家状态
     * @return
     */
    @GetMapping("/setStatus")
    public int setStatus() {
        Keeper keeper1 = keeperMapper.getKeeperForKeeper();
        if (keeper1.getStatus() == 1) {
            keeper1.setStatus(0);
        }else{
            keeper1.setStatus(1);
        }
        int status = keeper1.getStatus();
        keeperMapper.updateKeeper(keeper1);
        System.out.println("后台状态设置："+status);
        return status;
    }


    /**
     *  获取店家状态
     * @return
     */
    @GetMapping("/getStatus")
    public int getStatus() {
        Keeper keeper1 = keeperMapper.getKeeperForKeeper();
        return keeper1.getStatus();
    }
}

