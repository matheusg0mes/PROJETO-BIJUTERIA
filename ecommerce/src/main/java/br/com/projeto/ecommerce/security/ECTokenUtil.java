package br.com.projeto.ecommerce.security;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import br.com.projeto.ecommerce.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class ECTokenUtil {

    public static final long UM_SEGUNDO  = 1000;
    public static final long UM_MINUTO   = UM_SEGUNDO * 60;
    public static final long UMA_HORA    = UM_MINUTO * 60;
    public static final long UM_DIA      = UMA_HORA * 24;
    public static final long UMA_SEMANA  = UM_DIA * 7;

    public static final String EMISSOR      = "TrueDev";
    public static final String TOKEN_HEADER = "Bearer ";

    private static SecretKey getKey() {
        String secret = System.getenv("JWT_SECRET");
        if (secret == null || secret.isBlank()) {
            throw new RuntimeException("Variável de ambiente JWT_SECRET não configurada!");
        }
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public static ECToken generateToken(Usuario usuario) {
        String jwt = Jwts.builder()
                .issuer(EMISSOR)
                .subject(usuario.getLogin())
                .expiration(new Date(System.currentTimeMillis() + UMA_HORA))
                .signWith(getKey())
                .compact();

        ECToken token = new ECToken();
        token.setToken(TOKEN_HEADER + jwt);
        return token;
    }

    public static Authentication decodeToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith(TOKEN_HEADER)) {
            return null;
        }

        String token = header.replace(TOKEN_HEADER, "");
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String login    = claims.getSubject();
            String emissor  = claims.getIssuer();
            Date   validade = claims.getExpiration();

            boolean loginValido   = login != null && !login.isBlank();
            boolean emissorValido = EMISSOR.equals(emissor);
            boolean tokenValido   = validade != null && validade.after(new Date());

            if (loginValido && emissorValido && tokenValido) {
                return new UsernamePasswordAuthenticationToken(
                    login, null, Collections.emptyList()
                );
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}