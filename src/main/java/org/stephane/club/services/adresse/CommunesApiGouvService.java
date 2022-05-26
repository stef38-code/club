package org.stephane.club.services.adresse;

import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.share.mapper.factory.CreateMapperDto;

import java.util.List;

public abstract class CommunesApiGouvService extends CreateMapperDto<CommuneApiGouvEntity, CommuneApiGouvDto> {
    public abstract List<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta);
}
