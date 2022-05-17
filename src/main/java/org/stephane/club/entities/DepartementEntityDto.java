package org.stephane.club.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartementEntityDto implements Serializable {
    private final String numero;
    private final String departement;
    private final String region;
}
