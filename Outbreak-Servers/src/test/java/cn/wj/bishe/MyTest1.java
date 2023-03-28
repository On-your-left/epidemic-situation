package cn.wj.bishe;

import cn.hutool.core.io.FileUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Base64;

/**
 * @Auther: wangjing
 * @Date: 2023/3/15 13:57
 * @Desc:
 */
public class MyTest1 {

    @Test
    public void method(){
        System.out.println("测试用例");
    }

    /**
     * 解析token
     */
    @Test
    public void t1() {
        // String header = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9"; //JWT的头部
        String Payload = "eyJhdWQiOiIyMDE5NDIzMDg0NjEiLCJleHAiOjE2NzkwNjg5NTl9";    //JWT的负载，内容也是一个json，它是存放有效信息的地方
        byte[] decode = Base64.getDecoder().decode(Payload);
        System.out.println(new String(decode));
    }


    /**
     * 获取 token 中的 user id
     */
    @Test
    public void t2() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMDE5NDIzMDg0NjEiLCJleHAiOjE2NzkwNjg5NTl9.ZYZHzvsB72w6mM0ssRqhX37IpqfRaXIcoo-dJFvkUVg";
        System.out.println(JWT.decode(token).getAudience());    //输出的是一个数组
        System.out.println(JWT.decode(token).getAudience().get(0));
    }


    /**
     * 模拟用户密码加签验证 token
     */
    @Test
    public void t3() {
        String passWord = "123456";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(passWord)).build();
        System.out.println(jwtVerifier);
    }


    /**
     * 测试获取文件的扩展名
     */
    @Test
    public void t4() {
        String s = FileUtil.extName("abc.txt");
        System.out.println(s);
    }

}
