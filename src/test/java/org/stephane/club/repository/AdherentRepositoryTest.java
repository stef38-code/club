package org.stephane.club.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.entities.AdherentEntityBuilder;
import org.stephane.club.entities.GenreEntity;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@ActiveProfiles("test")
class AdherentRepositoryTest {
    @Autowired
    private AdherentRepository reposytory;

    @BeforeAll
    static void beforeAll() {

    }

    @BeforeEach
    void setUp() {
        AdherentEntity bob = AdherentEntityBuilder.create()
                .nom("Eponge")
                .prenom("Bob")
                .dnaissance(LocalDate.of(2020, 1, 1))
                .genre(GenreEntity.HOMME)
                .nlicence("AZERTY1")
                .build();

        AdherentEntity sandy = AdherentEntityBuilder.create()
                .nom("Ecureuil")
                .prenom("Sandy")
                .dnaissance(LocalDate.of(2018, 6, 6))
                .genre(GenreEntity.FEMME)
                .nlicence("AZERTY2")
                .build();

        AdherentEntity karen = AdherentEntityBuilder.create()
                .nom("Plankton")
                .prenom("Karen")
                .dnaissance(LocalDate.of(2018, 12, 12))
                .genre(GenreEntity.FEMME)
                .nlicence("AZERTY3")
                .build();
        AdherentEntity patrick = AdherentEntityBuilder.create()
                .nom("Etoile de mer")
                .prenom("Patrick")
                .dnaissance(LocalDate.of(2020, 3, 3))
                .genre(GenreEntity.HOMME)
                .nlicence("AZERTY4")
                .build();
        //clean table
        reposytory.deleteAll();
        reposytory.save(bob);
        reposytory.save(sandy);
        reposytory.save(karen);
        reposytory.save(patrick);
    }

    @Test
    void Quand_Je_Demande_Tous_Les_Adhérents_Attend_Une_Liste_NonVide() {
        List<AdherentEntity> all = reposytory.findAll();
        then(all).isNotEmpty().hasSize(4);
    }
}
