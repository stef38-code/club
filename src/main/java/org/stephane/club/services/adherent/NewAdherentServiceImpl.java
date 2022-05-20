package org.stephane.club.services.adherent;

import org.springframework.stereotype.Service;
import org.stephane.club.repository.AdherentRepository;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;
@Service
public class NewAdherentServiceImpl extends NewAdherentService {
    public NewAdherentServiceImpl(AdherentRepository repository, TypeServiceMapperDto mapperType) {
        super(repository, mapperType);
    }
}
