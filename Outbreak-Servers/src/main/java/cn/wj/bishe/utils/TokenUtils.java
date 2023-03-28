package cn.wj.bishe.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * 登录之后，会把登录信息变成一个token。之后的任何一个请求都会携带token，如果没有token，被认定为非法请求
 */
public class TokenUtils {

    public static String genToken(String userId, String sign) {
        return JWT.create().withAudience(userId) // 将 userId 保存到 token 里面,作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2小时后token过期
                .sign(Algorithm.HMAC256(sign)); // 以 userPwd 作为 token 的密钥
    }
}
