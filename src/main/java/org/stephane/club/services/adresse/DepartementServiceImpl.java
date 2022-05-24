package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.entities.DepartementEntityBuilder;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;

@Service
public class DepartementServiceImpl  extends DepartementService {

    public DepartementServiceImpl(JpaRepository<DepartementEntity, String> repository) {
        super(repository);
    }

    @Override
    protected DepartementEntity newEntity(String e) {
        return DepartementEntityBuilder.create().numero(e).build();
    }

    @Override
    protected TypeServiceMapperDto getMapperType() {
        return TypeServiceMapperDto.DEPARTEMENT;
    }
}
