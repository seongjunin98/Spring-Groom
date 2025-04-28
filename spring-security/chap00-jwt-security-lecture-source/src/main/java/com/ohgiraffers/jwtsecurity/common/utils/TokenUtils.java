package com.ohgiraffers.jwtsecurity.common.utils;


import com.ohgiraffers.jwtsecurity.user.entity.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * 토큰을 관리하기 위한 utils 모음 클래스
 * */
@Component
public class TokenUtils {

    private static String jwtSecretKey;

    private static Long tokenValidateTime;

    @Value("${jwt.key}")
    public void setJwtSecretKey(String jwtSecretKey) {
        TokenUtils.jwtSecretKey = jwtSecretKey;
    }

    @Value("${jwt.time}")
    public void setTokenValidateTime(Long tokenValidateTime) {
        TokenUtils.tokenValidateTime = tokenValidateTime;
    }

    /**
     * description. header의 token을 분리하는 메소드
     *
     * @param header (Authrization의 header값)
     * @return String (Authrization의 token 부분)
     */
    public static String splitHeader(String header) {
        if(!header.equals("")) {
            return header.split(" ")[1];
        } else {
            return null;
        }
    }

    /**
     * description. 토큰이 유효한지 확인하는 메소드
     *
     * @param token
     * @return boolean : 유효 판단 여부
     */
    public static boolean isValidToken(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            return false;

        } catch (JwtException e) {
            e.printStackTrace();
            return false;

        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * description. 토큰을 복호화 하는 메소드
     *
     * @param token
     * @return Claims
     */
    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecretKey))
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * description. 토큰을 생성하는 메소드
     *
     * @param user
     * @return token (String)
     */
    public static String generateJwtToken(User user) {
        Date expireTime = new Date(System.currentTimeMillis() + tokenValidateTime);

        JwtBuilder builder = Jwts.builder()
                .setHeader(createHeader())
                .setClaims(createClaims(user))
                .setSubject("ohgiraffers token " + user.getUserNo())
                .signWith(SignatureAlgorithm.HS256, createSignature())
                .setExpiration(expireTime);

        return builder.compact();
    }


    /**
     * description. 토큰의 header를 설정하는 메소드
     *
     * @return Map<String, Object> (header의 설정 정보)
     */
    private static Map<String, Object> createHeader() {
        Map<String, Object> header = new HashMap<>();

        header.put("type", "jwt");  // 타입이 json web token
        header.put("alg", "HS256"); // 알고리즘으로 암호화 방식 설정
        header.put("date", System.currentTimeMillis()); // 만들어진 시간 정보

        return header;
    }


    /**
     * description. 사용자 정보를 기반으로 claim을 생성하는 메소드
     *
     * @param user (사용자 정보)
     * @return Map<String, Object> (claims 정보)
     */
    private static Map<String, Object> createClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("userName", user.getUserName());
        claims.put("Role", user.getRole());

        return claims;
    }


    /**
     * description. JWT 서명을 발급하는 메소드
     *
     * @return Key : SecretKeySpec
     */
    private static Key createSignature() {

        byte[] secretBytes = DatatypeConverter.parseBase64Binary(jwtSecretKey);

        return new SecretKeySpec(secretBytes, SignatureAlgorithm.HS256.getJcaName());

    }

}
