package org.stephane.club.entities;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AdherentEntityBuilderTest {

    @Test
    void create() {
        AdherentEntityBuilder actualCreateResult = AdherentEntityBuilder.create();
        actualCreateResult.dnaissance(LocalDate.ofEpochDay(1L));
        actualCreateResult.genre(GenreEntity.HOMME);
        actualCreateResult.id("42");
        actualCreateResult.nlicence("Nlicence");
        actualCreateResult.nom("Nom");
        actualCreateResult.prenom("Prenom");
        AdherentEntity adherentEntity = actualCreateResult.build();
       /* then(adherentEntity).usingRecursiveComparison()
                .isEqualTo(actualCreateResult);*/
        then(adherentEntity.getDnaissance()).isEqualTo(LocalDate.ofEpochDay(1L));
        then(adherentEntity.getPrenom()).hasToString("Prenom");
        then(adherentEntity.getNom()).hasToString("Nom");
        then(adherentEntity.getNlicence()).hasToString("Nlicence");
        then(adherentEntity.getId()).hasToString("42");
        then(adherentEntity.getGenre()).isEqualTo(GenreEntity.HOMME);
    }
    /**
     * Method under test: {@link AdherentEntityBuilder#copy(AdherentEntity)}
     */
    @Test
    void copy() {
        AdherentEntityBuilder createResult = AdherentEntityBuilder.create();

        AdherentEntity adherentEntity = new AdherentEntity();
        adherentEntity.setDnaissance(LocalDate.ofEpochDay(1L));
        adherentEntity.setGenre(GenreEntity.HOMME);
        adherentEntity.setId("42");
        adherentEntity.setNlicence("Nlicence");
        adherentEntity.setNom("Nom");
        adherentEntity.setPrenom("Prenom");
        assertSame(createResult, createResult.copy(adherentEntity));
    }

    /**
     * Method under test: {@link AdherentEntityBuilder#build()}
     */
    @Test
    void build() {
        AdherentEntity actualBuildResult = AdherentEntityBuilder.create().build();
        assertNull(actualBuildResult.getDnaissance());
        assertNull(actualBuildResult.getPrenom());
        assertNull(actualBuildResult.getNom());
        assertNull(actualBuildResult.getNlicence());
        assertNull(actualBuildResult.getId());
        assertNull(actualBuildResult.getGenre());
    }
}

