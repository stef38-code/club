package org.stephane.club.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GouvApiCommuneDto implements Serializable {
    private final String code;
    private final String nom;
    private final String codeDepartement;
    private final String codeRegion;
    private final int population;
}
