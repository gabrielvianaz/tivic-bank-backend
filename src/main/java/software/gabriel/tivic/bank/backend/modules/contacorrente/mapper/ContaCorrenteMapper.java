/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.cliente.mapper.ClienteMapper;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrenteDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrentePessoaFisicaDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrentePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrente;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrentePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrentePessoaJuridica;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = ClienteMapper.class)
public interface ContaCorrenteMapper {

    default ContaCorrenteDTO toDTO(ContaCorrente contaCorrente) {
        if (contaCorrente instanceof ContaCorrentePessoaFisica contaCorrentePessoaFisica) {
            return toDTO(contaCorrentePessoaFisica);
        } else if (contaCorrente instanceof ContaCorrentePessoaJuridica contaCorrentePessoaJuridica) {
            return toDTO(contaCorrentePessoaJuridica);
        } else {
            return null;
        }
    }

    default ContaCorrente toEntity(ContaCorrenteDTO contaCorrenteDTO) {
        if (contaCorrenteDTO instanceof ContaCorrentePessoaJuridicaDTO contaCorrentePessoaJuridicaDTO) {
            return toEntity(contaCorrentePessoaJuridicaDTO);
        } else if (contaCorrenteDTO instanceof ContaCorrentePessoaFisicaDTO contaCorrentePessoaFisicaDTO) {
            return toEntity(contaCorrentePessoaFisicaDTO);
        } else {
            return null;
        }
    }

    ContaCorrentePessoaFisicaDTO toDTO(ContaCorrentePessoaFisica entity);

    ContaCorrentePessoaJuridicaDTO toDTO(ContaCorrentePessoaJuridica entity);
    
    ContaCorrentePessoaFisica toEntity(ContaCorrentePessoaFisicaDTO dto);
    
    ContaCorrentePessoaJuridica toEntity(ContaCorrentePessoaJuridicaDTO dto);

}
