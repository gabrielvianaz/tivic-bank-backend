/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package software.gabriel.tivic.bank.backend.modules.operacao.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import software.gabriel.tivic.bank.backend.modules.operacao.dto.SaqueDTO;
import software.gabriel.tivic.bank.backend.modules.operacao.entity.Saque;

/**
 *
 * @author gabriel
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaqueMapper {
    
    SaqueDTO toDto(Saque entity);
    
    Saque toEntity(SaqueDTO saqueDTO);
    
}
