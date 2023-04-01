/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.util;

import software.gabriel.tivic.bank.backend.modules.operacao.exception.SaldoInsuficienteException;

/**
 *
 * @author gabriel
 */
public class OperacaoUtils {

    public static void validarOperacaoSaida(Double valor, Double saldo) {
        if (valor > saldo) {
            throw new SaldoInsuficienteException();
        }
    }

}
