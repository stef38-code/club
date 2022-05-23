package org.stephane.club.share.mapper;

import org.mapstruct.Mapper;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class DepartementMapper implements ServiceMapperDto<DepartementEntity, DepartementEntityDto> {

}
