package org.stephane.club.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "baseofficiellecodespostaux")
public class BaseOfficielleCodesPostaux implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private static final long serialVersionUID = 4247719986147775328L;
    private String code_commune_insee;
    private String nom_de_la_commune;
    private String code_postal;
    private String ligne_5;
    private String libelle_d_acheminement;
    private String coordonnees_gps;
}
