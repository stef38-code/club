package org.stephane.club.services.adresse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.repository.AdresseEntityRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

@Service
@Slf4j
public class AdresseServiceImpl extends DefaultServiceImpl<AdresseEntity, AdresseDto, AdresseEntityRepository> implements AdresseService<AdresseEntity, AdresseDto> {
    public AdresseServiceImpl(AdresseEntityRepository repository) {
        super(repository, TypeServiceMapperDto.ADRESSE);
    }
}
