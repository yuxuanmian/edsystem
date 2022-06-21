package com.xhu.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * jwt工具类
 * @author yxm
 */
public abstract class JWTUtil {
    /**
     * 签名用secret
     */
    public static final String SECRET = "114514";

    /**
     * 过期时间为1天
     */
    public static final int EXP = 1;

    private JWTUtil(){
        //不允许实例化
    }


    public static String createToken(Map<String, String> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXP);

        JWTCreator.Builder builder = JWT.create();
        builder.withHeader(new HashMap<>());
        //构建payload
        map.forEach(builder::withClaim);
        //设置过期时间以及签名
        return builder.withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static DecodedJWT decodedJWT(String token) {
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(SECRET)).build();
        return jwtVerifier.verify(token);
    }


}
