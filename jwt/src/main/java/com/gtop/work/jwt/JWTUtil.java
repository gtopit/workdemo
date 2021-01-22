package com.gtop.work.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author hongzw@citycloud.com.cn
 */
@Slf4j
public class JWTUtil {

    /**
     * 协同联动平台token过期时间
     */
    private static final long TOKEN_EXPIRES_TIME = 30L;

    /**
     * 私钥
     */
    private static final String PRIVATE_KEY = "675cea42ddaa";

    /**
     * 通过私钥生成的算法摘要
     */
    private static final Algorithm algorithm = Algorithm.HMAC256(PRIVATE_KEY);

    /**
     * 公钥
     */
    private static final String PUBLIC_KEY = "9abbdac26a14";

    private static TokenHolder tokenHolder = new TokenHolder();

    private static class TokenHolder {
        String token = null;
        boolean expires;

        boolean isExpires() {
            DecodedJWT verify = verify(token);
            if (null == verify) {
                return true;
            }
            Date date = verify.getExpiresAt();
            expires = date.before(new Date());
            return expires;
        }

    }

    public static String getToken() {

        if (null == tokenHolder.token || tokenHolder.isExpires()) {
            LocalDateTime expiresTime = LocalDateTime.now().plusMinutes(TOKEN_EXPIRES_TIME);
            Date expiresDate = Date.from(expiresTime.atZone(ZoneId.systemDefault()).toInstant());
            tokenHolder.token = JWT.create().withExpiresAt(expiresDate).sign(algorithm);
            System.out.println("in..");
        }

        return tokenHolder.token;
    }

    private static DecodedJWT verify(String token) {

        if (null == token) {
            return null;
        }

        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

}
