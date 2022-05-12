package org.stephane.club.share.mapper;

import org.mapstruct.Mapper;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class AdresseMapper implements ServiceMapperDto<AdresseEntity, AdresseDto> {
}
