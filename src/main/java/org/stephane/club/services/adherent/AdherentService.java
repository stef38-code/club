package org.stephane.club.services.adherent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.share.defaut.service.BaseService;

public abstract class AdherentService extends BaseService<AdherentDto, AdherentEntity,String> {

    public AdherentService(JpaRepository<AdherentEntity, String> repository) {
        super(repository);
    }
}
