/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.security.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.security.dto.LoginDTO;
import software.gabriel.tivic.bank.backend.modules.security.service.TokenService;

/**
 *
 * @author gabriel
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getSenha());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var cliente = (Cliente) authentication.getPrincipal();

        return ResponseEntity.ok(tokenService.gerarToken(cliente));
    }

}
