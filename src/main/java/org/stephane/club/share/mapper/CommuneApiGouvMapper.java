package org.stephane.club.share.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;
import org.stephane.club.share.validators.CodePostal;

import java.util.Collections;
import java.util.List;

@Mapper
public abstract class CommuneApiGouvMapper implements ServiceMapperDto<CommuneApiGouvEntity, CommuneApiGouvDto> {
    @Mapping(target = "codePostal", source = "codesPostaux", qualifiedByName = "ToCodePostalEntity")
    public abstract  CommuneApiGouvEntity toEntity(CommuneApiGouvDto in);


    @Mapping(source = "codePostal",  target= "codesPostaux", qualifiedByName = "ToCodePostalDto")
    public abstract CommuneApiGouvDto toDto(CommuneApiGouvEntity out) ;

    @Named("ToCodePostalEntity")
    public String toCodePostalEntity(List<String> values) {
       if(values.isEmpty()){
           return StringUtils.EMPTY;
       }
        return values.get(0);
    }
    @Named("ToCodePostalDto")
    public List<String> toCodePostalDto(String value) {
        if (StringUtils.isBlank(value)) {
           return Collections.EMPTY_LIST;
        }
        return List.of(value);
    }
}
