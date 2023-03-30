/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaFisicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaFisica;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientePessoaFisicaMapper {
    
    ClientePessoaFisicaDTO toDto(ClientePessoaFisica entity);
    
    ClientePessoaFisica toEntity(ClientePessoaFisicaDTO dto);
    
}
