package org.stephane.club.services;

import org.stephane.club.dto.CommuneDto;

import java.util.Collection;

public interface GouvCommunesService {
    Collection<CommuneDto> rechercheCommunesParcodePostal(String codePosta);
}
