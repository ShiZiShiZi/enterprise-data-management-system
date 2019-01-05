package org.hfut.tool.global;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Token
 *
 * @author WeiXin
 * @date 2019/1/1
 **/
public class Token {

    public static final String SECRET = "*>*$)$_NOT_FOUND*>*";

    public static String getToken(Integer projectPeopleId){
        Date iatDate = new Date();
        Date expiresDate = new Date(iatDate.getTime() + 90 * 60 * 1000);

        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "Token");

        String token = JWT.create().withHeader(map).withClaim("iss", "org.htut.404NotFound").withClaim("aud", "EDMS_APP").withClaim("projectPeopleId", projectPeopleId.toString()).withIssuedAt(iatDate).withExpiresAt(expiresDate).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return jwt.getClaims();
    }

    public static Integer getProjectPeopleId(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim projectPeopleIdClaim = claims.get("projectPeopleId");
        return Integer.valueOf(projectPeopleIdClaim.asString());
    }
}
