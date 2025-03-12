package effective.mobile.task_management_system.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
@AllArgsConstructor
public class JwtTokenProvider {

        @Value("${spring.jwt.secret}")
        private String jwtSecret;

        @Value("${spring.jwt.expirationTimeMs}")
        private long jwtExpirationDate;

        // generate JWT token
        public String generateToken(Authentication authentication){

            String username = authentication.getName();

            Date currentDate = new Date();

            Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);

            return Jwts.builder()
                    .subject(username)
                    .issuedAt(new Date())
                    .expiration(expireDate)
                    .signWith(key())
                    .compact();
        }

        private Key key(){
            return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        }

        // get username from JWT token
        public String getUsername(String token){

            return Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        }

        // validate JWT token
        public boolean validateToken(String token){
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;

        }
    }

