/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.TransferenciaDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Transferencia;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransferenciaMapper {
    
    TransferenciaDTO toDto(Transferencia entity);
    
    Transferencia toEntity(TransferenciaDTO transferenciaDTO);
    
}
