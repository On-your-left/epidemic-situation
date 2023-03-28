package cn.wj.bishe.service;

import cn.wj.bishe.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.wj.bishe.controller.entityDto.UserDto;

public interface UserService extends IService<User> {
    //    登录
    UserDto login(User user);
}
