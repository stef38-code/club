package org.stephane.club.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name = "departement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartementEntity {
    @Id
    private String numero;
    private String  departement;
    private String region;
}
