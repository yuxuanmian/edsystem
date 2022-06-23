package com.xhu.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public abstract class Md5Utils {

    private Md5Utils(){}

    public static String md5Password(String password) throws NoSuchAlgorithmException {


            MessageDigest messageDigest = MessageDigest.getInstance("md5");

            byte[] digest = messageDigest.digest(password.getBytes());

            Base64.Encoder encoder = Base64.getEncoder();

            byte[] encode = encoder.encode(digest);
            return new String(encode);

    }
}
