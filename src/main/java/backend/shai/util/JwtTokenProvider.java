package backend.shai.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt.secret}")
    private String jwtSecret;

    @Value("${app.jwt.expiration-ms}")
    private int jwtExpirationMs;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getDate() + jwtExpirationMs);

        return Jwts.builder().setSubject(username).setIssuedAt(now).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).build().parseSignedClaims(token).getPayload();
    }
}
