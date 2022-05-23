package org.stephane.club.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartementEntityDto implements Serializable {
    private final String numero;
    private final String departement;
    private final String region;
}
