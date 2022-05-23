package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.share.defaut.service.BaseService;

public abstract class AdresseService extends BaseService<AdresseDto, AdresseEntity, String> {

    public AdresseService(JpaRepository<AdresseEntity, String> repository) {
        super(repository);
    }
}
