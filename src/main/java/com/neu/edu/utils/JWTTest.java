package com.neu.edu.utils;


import com.neu.edu.vo.UserVO;

import java.security.PrivateKey;
import java.security.PublicKey;
public class JWTTest {
    private static final String pubKeyPath = "src/main/resources/rsa/rsa.pub";
    private static final String priKeyPath = "src/main/resources/rsa/rsa.pri";
    private PublicKey publicKey;
    private PrivateKey privateKey;

    public static void main(String[] args) {
        JWTTest jwtTest = new JWTTest();
        jwtTest.testRsa();
//        jwtTest.testJWT();
    }

    public void testRsa() {
        try {
            RSAUtil.generateKey(pubKeyPath, priKeyPath, "abc");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void testJWT() {
//        try {
//            this.publicKey = RSAUtil.getPublicKey(pubKeyPath);
//            this.privateKey = RSAUtil.getPrivateKey(priKeyPath);
//            UserVO userVO = new UserVO();
//            final String token = JWTUtil.generateToken(userVO, this.privateKey, 1800);
//            System.out.println(token);
//            final String oriInfo = JWTUtil.getInfoFromToken(token, this.publicKey);
//            System.out.println(oriInfo);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
