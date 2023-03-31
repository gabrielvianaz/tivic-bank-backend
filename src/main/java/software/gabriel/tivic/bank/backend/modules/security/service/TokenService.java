/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.security.util.SecurityUtils;

/**
 *
 * @author gabriel
 */
@Service
public class TokenService {

    public String gerarToken(Cliente cliente) {
        return JWT.create()
                .withIssuer("TIVIC Bank")
                .withSubject(cliente.getEmail())
                .withClaim("id", cliente.getId())
                .withExpiresAt(LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(SecurityUtils.getJwtSecret()));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SecurityUtils.getJwtSecret()))
                .withIssuer("TIVIC Bank")
                .build()
                .verify(token)
                .getSubject();

    }

}
