package com.example.controller.user;
import com.example.common.R;
import com.example.entity.Keeper;
import com.example.exception.CustomException;
import com.example.mapper.KeeperMapper;
import com.example.service.KeeperService;
import com.example.vo.KeeperVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Component("userKeeperController")
@RestController
@RequestMapping("/user/keeper")
public class keeperController {
    @Autowired
    private KeeperMapper keeperMapper;

    /**
     * 查询店家的信息
     * @return
     */
    @GetMapping("/getKeeper")
    public KeeperVo getKeeperForUser() {
        return keeperMapper.getKeeperForUser();
    }
}

