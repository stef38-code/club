package org.stephane.club.dto;

import lombok.Builder;
import lombok.Value;
import org.stephane.club.share.validators.CodePostal;

import java.io.Serializable;
import java.util.Set;

@Value(staticConstructor = "of")
@Builder
public class AdresseDto implements Serializable {

    private static final long serialVersionUID = 1580330171450692221L;
    private final String id;
    private final String destinataire;
    private final String numBat;
    private final String batiment;
    private final String voie;
    private final String lieuDit;
    /**
     * https://blog.bureaudeposte.net/bien-rediger-une-adresse-postale/
     */
    @CodePostal
    private final String codePostal;
    private Set<AdherentDto> personnes;
    private CommuneApiGouvDto commune;
}
