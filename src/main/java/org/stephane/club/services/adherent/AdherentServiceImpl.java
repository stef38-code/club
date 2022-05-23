package org.stephane.club.services.adherent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.entities.AdherentEntityBuilder;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;

@Service
public class AdherentServiceImpl extends AdherentService {
    public AdherentServiceImpl(JpaRepository<AdherentEntity, String> repository) {
        super(repository);
    }

    @Override
    protected AdherentEntity newEntity(String e) {
        return AdherentEntityBuilder.create().id(e).build();
    }

    @Override
    protected AdherentEntity toEntity(AdherentDto in) {
        return getMapper(TypeServiceMapperDto.ADHERENT).toEntity(in);
    }

    @Override
    protected AdherentDto toDto(AdherentEntity out) {
        return getMapper(TypeServiceMapperDto.ADHERENT).toDto(out);
    }

    @Override
    protected List<AdherentEntity> toEntities(List<AdherentDto> in) {
        return getMapper(TypeServiceMapperDto.ADHERENT).toEntities(in);
    }

    @Override
    protected List<AdherentDto> toDtos(List<AdherentEntity> out) {
        return getMapper(TypeServiceMapperDto.ADHERENT).toDtos(out);
    }
}
