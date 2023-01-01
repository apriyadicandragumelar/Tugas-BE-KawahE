package tech.candra.util;

import io.smallrye.jwt.build.Jwt;
import tech.candra.models.UserAdmin;

import java.time.Duration;
import java.util.Date;


public class JwtUtil {

    public static String generateToken(UserAdmin userAdmin) {
        String token = Jwt.issuer("xxxxx")
                .issuedAt(new Date().toInstant())
                .subject(userAdmin.getUsername())
                .groups("admin")
                .expiresIn(Duration.ofHours(1))
                .claim("username", userAdmin.getUsername())
                .claim("id",userAdmin.getId())
                .sign();
        return token;

    }
}
