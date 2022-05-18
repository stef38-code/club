package org.stephane.club.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "baseofficiellecommune")
public class CommuneApiGouvEntity implements Serializable {
    private static final long serialVersionUID = 4247719986147775328L;
    @Id
    private String code;
    private String nom;
    private String codeDepartement;
    private  String codeRegion;
    private String codePostal;
    private int population;
}
