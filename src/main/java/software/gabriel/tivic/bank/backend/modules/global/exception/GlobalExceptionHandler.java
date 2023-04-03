/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.global.exception;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import software.gabriel.tivic.bank.backend.modules.cliente.exception.CnpjJaCadastradoException;
import software.gabriel.tivic.bank.backend.modules.cliente.exception.CpfJaCadastradoException;
import software.gabriel.tivic.bank.backend.modules.cliente.exception.EmailJaCadastradoException;
import software.gabriel.tivic.bank.backend.modules.contacorrente.exception.ContaNaoEncontradaException;
import software.gabriel.tivic.bank.backend.modules.operacao.exception.SaldoInsuficienteException;
import software.gabriel.tivic.bank.backend.modules.operacao.exception.TransferenciaPropriaContaException;

/**
 *
 * @author gabriel
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
//    Global
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String mensagem = e.getFieldError().getDefaultMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
    
//    Cliente
    
    @ExceptionHandler(CnpjJaCadastradoException.class)
    public ResponseEntity<BaseError> cnpjJaCadastradoException(CnpjJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(CpfJaCadastradoException.class)
    public ResponseEntity<BaseError> cpfJaCadastradoException(CpfJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(EmailJaCadastradoException.class)
    public ResponseEntity<BaseError> emailJaCadastradoException(EmailJaCadastradoException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.CONFLICT;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }      
    
//    Operacao
    
    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<BaseError> saldoInsuficienteException(SaldoInsuficienteException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.PAYMENT_REQUIRED;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }    
    
    @ExceptionHandler(TransferenciaPropriaContaException.class)
    public ResponseEntity<BaseError> transferenciaPropriaContaException(TransferenciaPropriaContaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }    
    
    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<BaseError> contaDestinoNaoEncontradaException(ContaNaoEncontradaException e, HttpServletRequest request) {
        String mensagem = e.getMessage();
        HttpStatus status = HttpStatus.NOT_FOUND;
        BaseError err = new BaseError(Instant.now(), status.value(), mensagem, request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }    
    
    
}
