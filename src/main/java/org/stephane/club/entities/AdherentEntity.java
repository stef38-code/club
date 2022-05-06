package org.stephane.club.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.stephane.club.share.jpa.Auditable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "adherent")
@EntityListeners(AuditingEntityListener.class)
public class AdherentEntity extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 4247719986147775328L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @NotBlank(message = "Le nom est obligatoire")
    @NotNull
    private String nom;
    @NotBlank
    @NotNull
    private String prenom;

    private LocalDate dnaissance;
    @Enumerated
    @Column(name = "genre")
    private GenreEntity genre;
    private String nlicence;
}
