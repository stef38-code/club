package org.stephane.club.services.adresse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.entities.AdherentEntityBuilder;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.repository.AdresseEntityRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;

@Service
@Slf4j
public class AdresseServiceImpl extends AdresseService {

    public AdresseServiceImpl(JpaRepository<AdherentEntity, String> repository) {
        super(repository);
    }

    @Override
    protected AdherentEntity newEntity(String e) {
        return AdherentEntityBuilder.create().id(e).build();
    }

    @Override
    protected AdherentEntity toEntity(AdresseDto in) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toEntity(in);
    }

    @Override
    protected AdresseDto toDto(AdherentEntity out) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toDto(out);
    }

    @Override
    protected List<AdherentEntity> toEntities(List<AdresseDto> in) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toEntities(in);
    }

    @Override
    protected List<AdresseDto> toDtos(List<AdherentEntity> out) {
        return getMapper(TypeServiceMapperDto.ADRESSE).toDtos(out);
    }
}
