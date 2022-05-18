package org.stephane.club.services;

import org.stephane.club.dto.CommuneApiGouvDto;

import java.util.Collection;

public interface CommunesApiGouvService {
    Collection<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta);
}
