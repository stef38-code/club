package org.stephane.club.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.stephane.club.share.jpa.Auditable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
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
    @NotBlank

    private String codePostal;
}
