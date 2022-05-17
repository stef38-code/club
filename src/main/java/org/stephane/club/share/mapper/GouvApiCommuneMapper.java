package org.stephane.club.share.mapper;

import org.mapstruct.Mapper;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.dto.GouvApiCommuneDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.entities.GouvApiCommune;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class GouvApiCommuneMapper implements ServiceMapperDto<GouvApiCommune, GouvApiCommuneDto> {

}
