package org.stephane.club;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.stephane.club.entities.*;
import org.stephane.club.repository.AdherentRepository;
import org.stephane.club.repository.AdresseEntityRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.stephane.club.repository"})
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class ClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AdherentRepository adherentRepository, AdresseEntityRepository adresseEntityRepository) {
        return (args) -> {
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
            adherentRepository.save(bob);
            adherentRepository.save(sandy);
            adherentRepository.save(karen);
            adherentRepository.save(patrick);
            AdresseEntity adresse1 = AdresseEntityBuilder.create().codePostal("07430").build();
            adresseEntityRepository.save(adresse1);
        };
    }
}
