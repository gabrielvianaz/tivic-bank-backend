/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Operacao;

/**
 *
 * @author gabriel
 */
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
    
}
