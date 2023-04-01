/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.contacorrente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.contacorrente.dto.ContaCorrentePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.contacorrente.entity.ContaCorrentePessoaJuridica;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ContaCorrentePessoaJuridicaMapper {

    ContaCorrentePessoaJuridicaDTO toDTO(ContaCorrentePessoaJuridica entity);

}
