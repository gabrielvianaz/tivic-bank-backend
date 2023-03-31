/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;

/**
 *
 * @author gabriel
 */
public class SecurityUtils {
    
    public static String getJwtSecret() {
        return System.getenv("JWT_SECRET");
    }
    
    public static Cliente getClienteAutenticado() {
        return (Cliente) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
}
