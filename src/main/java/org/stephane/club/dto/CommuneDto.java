package org.stephane.club.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class CommuneDto implements Serializable {
private final String nom;
private final String code;
private final String codeDepartement;
private final String codeRegion;
private final List<String> codesPostaux;
private final int population;
}
