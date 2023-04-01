/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClienteDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaFisicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.dto.ClientePessoaJuridicaDTO;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.Cliente;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaFisica;
import software.gabriel.tivic.bank.backend.modules.cliente.entity.ClientePessoaJuridica;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

    default ClienteDTO toDTO(Cliente cliente) {
        if (cliente instanceof ClientePessoaFisica clientePessoaFisica) {
            return toDTO(clientePessoaFisica);
        } else if (cliente instanceof ClientePessoaJuridica clientePessoaJuridica) {
            return toDTO(clientePessoaJuridica);
        } else {
            return null;
        }
    }

    default Cliente toEntity(ClienteDTO clienteDTO) {
        if (clienteDTO instanceof ClientePessoaFisicaDTO clientePessoaFisicaDTO) {
            return (ClientePessoaFisica) toEntity(clientePessoaFisicaDTO);
        } else if (clienteDTO instanceof ClientePessoaJuridicaDTO clientePessoaJuridicaDTO) {
            return (ClientePessoaJuridica) toEntity(clientePessoaJuridicaDTO);
        } else {
            return null;
        }
    }

    ClientePessoaFisicaDTO toDTO(ClientePessoaFisica entity);

    ClientePessoaJuridicaDTO toDTO(ClientePessoaJuridica entity);

}
