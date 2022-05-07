package org.stephane.club.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.repository.AdherentRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

@Service
@Slf4j
public class AdherentServiceImpl extends DefaultServiceImpl<AdherentEntity, AdherentDto, AdherentRepository> implements AdherentService<AdherentEntity, AdherentDto, AdherentRepository>{
    public AdherentServiceImpl(AdherentRepository repository) {
        super(repository, TypeServiceMapperDto.ADHERENT);
    }
}
