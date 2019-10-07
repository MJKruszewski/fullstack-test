package com.instantor.dap.springbootbackend.domain.sw.mapper;

import com.instantor.dap.springbootbackend.domain.sw.dto.CharacterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.sunflux.swapi.model.People;

@Mapper
public interface CharacterMapper {

    CharacterMapper MAPPER = Mappers.getMapper( CharacterMapper.class );

    CharacterDto toCharacter(People people);

}
