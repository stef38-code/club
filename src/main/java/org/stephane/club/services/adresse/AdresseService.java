package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.share.defaut.service.BaseService;

public abstract class AdresseService extends BaseService<AdresseDto, AdherentEntity, String> {

    public AdresseService(JpaRepository<AdherentEntity, String> repository) {
        super(repository);
    }
}
