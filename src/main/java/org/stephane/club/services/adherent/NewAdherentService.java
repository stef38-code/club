package org.stephane.club.services.adherent;

import org.stephane.club.dto.AdherentDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.repository.AdherentRepository;
import org.stephane.club.share.defaut.service.GenericServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

public abstract class NewAdherentService extends GenericServiceImpl<AdherentEntity, AdherentDto, AdherentRepository> {


    public NewAdherentService(AdherentRepository repository, TypeServiceMapperDto mapperType) {
        super(repository, mapperType);
    }
}
