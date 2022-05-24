package org.stephane.club.services.adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.repository.GouvApiCommuneRepository;
import org.stephane.club.share.defaut.service.BaseService;

import java.util.Collection;
import java.util.List;

public abstract class CommunesApiGouvService extends BaseService<CommuneApiGouvDto, CommuneApiGouvEntity, String> {
    private GouvApiCommuneRepository apiCommuneRepository;
    public CommunesApiGouvService(GouvApiCommuneRepository repository) {
        super(repository, "title");
        this.apiCommuneRepository = repository;
    }

    public List<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta){

        List<CommuneApiGouvEntity> byCodePostal = apiCommuneRepository.findByCodePostal(codePosta);
        return getMapper(getMapperType()).toDtos(byCodePostal);
    }
}
