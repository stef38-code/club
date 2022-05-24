package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.share.defaut.service.BaseService;

public abstract class DepartementService extends BaseService<DepartementEntityDto, DepartementEntity, String> {

    public DepartementService(JpaRepository<DepartementEntity, String> repository) {
        super(repository,"Departement");
    }
}
