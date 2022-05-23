package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.entities.AdresseEntityBuilder;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.entities.DepartementEntityBuilder;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;

@Service
public class AdresseServiceImpl extends AdresseService {

    public AdresseServiceImpl(JpaRepository< AdresseEntity, String> repository) {
        super(repository);
    }

    @Override
    protected AdresseEntity newEntity(String e) {
        return AdresseEntityBuilder.create().id(e).build();
    }

    @Override
    protected AdresseEntity toEntity(AdresseDto in) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toEntity(in);
    }

    @Override
    protected AdresseDto toDto(AdresseEntity out) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toDto(out);
    }

    @Override
    protected List<AdresseEntity> toEntities(List<AdresseDto> in) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toEntities(in);
    }

    @Override
    protected List<AdresseDto> toDtos(List<AdresseEntity> out) {
        return getMapper(TypeServiceMapperDto.DEPARTEMENT).toDtos(out);
    }
}
