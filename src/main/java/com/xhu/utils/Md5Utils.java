package com.xhu.utils;
import java.security.MessageDigest;
import java.util.Base64;

public class Md5Utils {

    public static String md5Password(String password){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");

            byte[] digest = messageDigest.digest(password.getBytes());

            Base64.Encoder encoder = Base64.getEncoder();

            byte[] encode = encoder.encode(digest);
            return new String(encode);
        }catch (Exception e){
            System.out.println("------------》加密失败");
            return password;
        }
    }
}
