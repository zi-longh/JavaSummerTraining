package com.neu.edu.utils;

import com.neu.edu.vo.UserVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JWTUtil {
    private static final String pubKeyPath = "src/main/resources/rsa/rsa.pub";
    private static final String priKeyPath = "src/main/resources/rsa/rsa.pri";

    public static String getToken(UserVO userVO){

        try {
            return generateToken(userVO, RSAUtil.getPrivateKey(RSAUtil.getPrivateKey(priKeyPath).getEncoded()), 1800);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean verifyToken(String token){
        try {
            getInfoFromToken(token, RSAUtil.getPublicKey(RSAUtil.getPublicKey(pubKeyPath).getEncoded()));
            System.out.println( "token is valid");
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**
     * 生成密钥
     * @param userVO
     * @param privateKey
     * @param expire
     * @return
     */
    public static String generateToken(UserVO userVO, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim("userName", userVO.getUserName())
                .claim("workerNum", userVO.getWorkerNum())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256 ,privateKey)
                .compact();
    }

    public static UserVO getUserInfoFromToken(String token){
        UserVO result = new UserVO();
        try {
            PublicKey publicKey = RSAUtil.getPublicKey(RSAUtil.getPublicKey(pubKeyPath).getEncoded());
            result = getInfoFromToken(token, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从token中获取原始信息
     * @param token
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static UserVO getInfoFromToken(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        UserVO userVO = new UserVO();
        userVO.setWorkerNum((Integer) body.get("workerNum"));
        userVO.setUserName(body.get("userName")+"");
        return userVO;
    }
}
