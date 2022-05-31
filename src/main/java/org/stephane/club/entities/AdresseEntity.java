package org.stephane.club.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.stephane.club.share.jpa.Auditable;
import org.stephane.club.share.validators.CodePostal;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "adresse")
@EntityListeners(AuditingEntityListener.class)
public class AdresseEntity extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 4247719986147775328L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String destinataire; //1- CIVILITE-TITRE ou QUALITE-PRENOM-NOM
    private String numBat;//2- N° APP ou BAL-ETAGE-COULOIR-ESC
    private String batiment; //3- ENTREE-BATIMENT-IMMEUBLE-RESIDENCE
    private String voie; //4- NUMERO-LIBELLE DE LA VOIE
    private String lieuDit; //5- LIEU DIT ou SERVICE PARTICULIER DE DISTRIBUTION
    /**
     * 6- CODE POSTAL et LOCALITE DE DESTINATION ou CODE CEDEX et LIBELLE
     * CEDEX
     */
    @CodePostal
    private String codePostal;
    private String ville;

    @ManyToMany(targetEntity = AdherentEntity.class, mappedBy = "adresses",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonManagedReference
    @Fetch(FetchMode.SUBSELECT)
    private Set<AdherentEntity> personnes = new HashSet<>();
}
