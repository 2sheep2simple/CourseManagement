package com.course.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Util {
    public static String getMD5(String input) {
        String result = input;
        if(input != null) {
            MessageDigest md = null; //or "SHA-1"
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while(result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }
}