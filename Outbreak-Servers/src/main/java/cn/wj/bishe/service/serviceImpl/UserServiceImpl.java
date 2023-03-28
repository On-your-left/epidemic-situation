package cn.wj.bishe.service.serviceImpl;

import cn.hutool.core.bean.BeanUtil;
import cn.wj.bishe.common.Constants;
import cn.wj.bishe.controller.entityDto.UserDto;
import cn.wj.bishe.entity.User;
import cn.wj.bishe.exception.ServiceException;
import cn.wj.bishe.mapper.UserMapper;
import cn.wj.bishe.service.UserService;
import cn.wj.bishe.utils.TokenUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * TODO: 2023.3.7 22:07
 *         拦截器会拦截所有请求，但是放行了 "/user/login","/user/upload","/user/file/*" 这三个请求。
 *         用户登录的时候，在UserServiceImpl中会把登录信息变成一个token字符串。之后的所有请求中，请求头都会携带一个token。
 *         之后的所有请求都会走拦截器，拦截器中判断是否有token，如果没有token，就会被认为是非法请求。
 */

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
   //登录
    @Override
    public UserDto login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        queryWrapper.eq("user_pwd",user.getUserPwd());
        queryWrapper.eq("delete_flag",1);
        User one;
        try {
            one=getOne(queryWrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if(one != null){    // 通过 user_id、user_pwd、delete_flag 三个字段在数据库中查询，查询出来这个用户不为空
            BeanUtil.copyProperties(one,user,true);
            String token = TokenUtils.genToken(one.getUserId(),one.getUserPwd());   //把登录信息变成一个token
            log.info(token);        //打印token信息
            UserDto userDto = new UserDto(one.getUserId(),one.getUserName(),one.getUserUrl(), one.getIdentity(),token);
            BeanUtil.copyProperties(one,userDto,true);
            return userDto;
        }else {     //表示为空，可能是用户名或密码错误，也可能是用户不存在
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }
    }
}
