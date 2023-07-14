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
            return generateToken(userVO.getUserName(), RSAUtil.getPrivateKey(RSAUtil.getPrivateKey(priKeyPath).getEncoded()), 1800);
        }catch(Exception e){
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
     * 私钥生成Token
     * @param oriInfo
     * @param privateKey
     * @param expire      过期时间,单位秒
     * @return
     * @throws Exception
     */
    public static String generateToken(String oriInfo, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim("info", oriInfo)
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256 ,privateKey)
                .compact();
    }

    /**
     * 从token中获取原始信息
     * @param token
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String getInfoFromToken(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return body.get("info")+"";
    }
}
