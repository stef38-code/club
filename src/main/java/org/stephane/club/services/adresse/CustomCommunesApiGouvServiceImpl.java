package org.stephane.club.services.adresse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.entities.CommuneApiGouvEntityBuilder;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@Service
public class CustomCommunesApiGouvServiceImpl extends CustomCommunesApiGouvService {
    public CustomCommunesApiGouvServiceImpl(JpaRepository<CommuneApiGouvEntity, String> repository) {
        super(repository);
    }

    @Override
    public Collection<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta) {
        return Collections.EMPTY_LIST;
    }

    @Override
    protected CommuneApiGouvEntity newEntity(String e) {
        return CommuneApiGouvEntityBuilder.create().code(e).build();
    }

    @Override
    protected TypeServiceMapperDto getMapperType() {
        return TypeServiceMapperDto.GOUVAPICOMMUNE;
    }
}
