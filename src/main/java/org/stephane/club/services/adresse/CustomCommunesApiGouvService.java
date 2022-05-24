package org.stephane.club.services.adresse;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.repository.GouvApiCommuneRepository;
import org.stephane.club.share.defaut.service.BaseService;

import java.util.Collection;

public abstract class CustomCommunesApiGouvService extends BaseService<CommuneApiGouvDto, CommuneApiGouvEntity, String> {
    public CustomCommunesApiGouvService(JpaRepository<CommuneApiGouvEntity, String> repository) {
        super(repository, "title");
    }

    public abstract Collection<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta);
}
