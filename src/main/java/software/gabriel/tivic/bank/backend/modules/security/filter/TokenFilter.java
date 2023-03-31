/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.cliente.repository.ClienteRepository;
import software.gabriel.tivic.bank.backend.modules.security.service.TokenService;

/**
 *
 * @author gabriel
 */
@Component
public class TokenFilter extends OncePerRequestFilter {
    
    @Autowired
    TokenService tokenService;
    
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        
        String token;        
        String authorizationHeader = request.getHeader("Authorization");                
        
        if (authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");            
            String subject = tokenService.getSubject(token);            
            Cliente cliente = clienteRepository.findByEmail(subject);
            
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(cliente,
                    null, cliente.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(authentication);                        
        }
        
        filterChain.doFilter(request, response);
        
    }
    
}
