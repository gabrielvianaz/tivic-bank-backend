/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaJuridica;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientePessoaJuridicaMapper {
    
    ClientePessoaJuridicaDTO toDto(ClientePessoaJuridica entity);
    
    ClientePessoaJuridica toEntity(ClientePessoaJuridicaDTO dto);
    
}
