package org.stephane.club.share.mapper;

import org.mapstruct.Mapper;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class AdherentMapper implements ServiceMapperDto<AdherentEntity, AdherentDto> {
}
