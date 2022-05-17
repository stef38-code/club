package org.stephane.club.services;

import org.springframework.stereotype.Service;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.repository.DepartementEntityRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

@Service
public class DepartementServiceImpl extends DefaultServiceImpl<DepartementEntity, DepartementEntity, DepartementEntityRepository> implements DepartementService<DepartementEntity, DepartementEntity> {
    public DepartementServiceImpl(DepartementEntityRepository repository) {
        super(repository, TypeServiceMapperDto.DEPARTEMENT);
    }
}
