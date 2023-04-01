/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.contacorrente.mapper.ContaCorrenteMapper;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.DepositoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.OperacaoDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.SaqueDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.TransferenciaDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Deposito;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Operacao;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Saque;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Transferencia;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ContaCorrenteMapper.class)
public interface OperacaoMapper {

    default OperacaoDTO toDto(Operacao operacao) {
        if (operacao instanceof Deposito deposito) {
            return toDto(deposito);
        } else if (operacao instanceof Saque saque) {
            return toDto(saque);
        } else if (operacao instanceof Transferencia transferencia) {
            return toDto(transferencia);
        } else {
            return null;
        }
    }

    DepositoDTO toDto(Deposito entity);

    SaqueDTO toDto(Saque entity);

    TransferenciaDTO toDto(Transferencia entity);
    
    Deposito toDepositoEntity(DepositoDTO dto);

    Saque toSaqueEntity(SaqueDTO dto);

    Transferencia toTransferenciaEntity(TransferenciaDTO dto);
}
