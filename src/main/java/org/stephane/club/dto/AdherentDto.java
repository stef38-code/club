package org.stephane.club.dto;

import lombok.*;
import org.stephane.club.entities.GenreEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Value(staticConstructor = "of")
@Builder
public class AdherentDto implements Serializable {
    private static final long serialVersionUID = -6675452349131580305L;
    private final String id;
    @NotBlank(message = "Le nom est obligatoire")
    @NotNull
    private final String nom;
    @NotBlank
    @NotNull
    private final String prenom;
    private final LocalDate dnaissance;
    private final GenreEntity genre;
    private final String nlicence;
    private Set<AdresseDto> adresses;
}
