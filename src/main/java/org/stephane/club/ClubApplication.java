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
import org.stephane.club.repository.DepartementEntityRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.stephane.club.repository"})
@EnableJpaAuditing
@EnableAspectJAutoProxy
public class ClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(AdherentRepository adherentRepository, AdresseEntityRepository adresseEntityRepository, DepartementEntityRepository departementEntityRepository) {
        return args -> {
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
           /* AdresseEntity adresse1 = AdresseEntityBuilder.create().codePostal("07430").build();
            adresseEntityRepository.save(adresse1);*/
            addDepartement(departementEntityRepository);
        };
    }

    private void addDepartement(DepartementEntityRepository departementEntityRepository) {
        List<DepartementEntity> of;
        of = List.of(new DepartementEntity("01","Ain", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("02","Aisne","Hauts-de-France"),
                new DepartementEntity("03","Allier", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("04","Alpes-de-Haute-Provence","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("05","Hautes-Alpes","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("06","Alpes-Maritimes","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("07","Ardèche", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("08","Ardennes","Grand Est"),
                new DepartementEntity("09","Ariège","Occitanie"),
                new DepartementEntity("10","Aube","Grand Est"),
                new DepartementEntity("11","Aude","Occitanie"),
                new DepartementEntity("12","Aveyron","Occitanie"),
                new DepartementEntity("13","Bouches-du-Rhône","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("14","Calvados","Normandie"),
                new DepartementEntity("15","Cantal", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("16","Charente","Nouvelle-Aquitaine"),
                new DepartementEntity("17","Charente-Maritime","Nouvelle-Aquitaine"),
                new DepartementEntity("18","Cher","Centre-Val de Loire"),
                new DepartementEntity("19","Corrèze","Nouvelle-Aquitaine"),
                new DepartementEntity("2A","Corse-du-Sud","Corse"),
                new DepartementEntity("2B","Haute-Corse","Corse"),
                new DepartementEntity("21","Côte-d'Or","Bourgogne-Franche-Comté"),
                new DepartementEntity("22","Côtes d'Armor","Bretagne"),
                new DepartementEntity("23","Creuse","Nouvelle-Aquitaine"),
                new DepartementEntity("24","Dordogne","Nouvelle-Aquitaine"),
                new DepartementEntity("25","Doubs","Bourgogne-Franche-Comté"),
                new DepartementEntity("26","Drôme", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("27","Eure","Normandie"),
                new DepartementEntity("28","Eure-et-Loir","Centre-Val de Loire"),
                new DepartementEntity("29","Finistère","Bretagne"),
                new DepartementEntity("30","Gard","Occitanie"),
                new DepartementEntity("31","Haute-Garonne","Occitanie"),
                new DepartementEntity("32","Gers","Occitanie"),
                new DepartementEntity("33","Gironde","Nouvelle-Aquitaine"),
                new DepartementEntity("34","Hérault","Occitanie"),
                new DepartementEntity("35","Ille-et-Vilaine","Bretagne"),
                new DepartementEntity("36","Indre","Centre-Val de Loire"),
                new DepartementEntity("37","Indre-et-Loire","Centre-Val de Loire"),
                new DepartementEntity("38","Isère", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("39","Jura","Bourgogne-Franche-Comté"),
                new DepartementEntity("40","Landes","Nouvelle-Aquitaine"),
                new DepartementEntity("41","Loir-et-Cher","Centre-Val de Loire"),
                new DepartementEntity("42","Loire", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("43","Haute-Loire", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("44","Loire-Atlantique","Pays de la Loire"),
                new DepartementEntity("45","Loiret","Centre-Val de Loire"),
                new DepartementEntity("46","Lot","Occitanie"),
                new DepartementEntity("47","Lot-et-Garonne","Nouvelle-Aquitaine"),
                new DepartementEntity("48","Lozère","Occitanie"),
                new DepartementEntity("49","Maine-et-Loire","Pays de la Loire"),
                new DepartementEntity("50","Manche","Normandie"),
                new DepartementEntity("51","Marne","Grand Est"),
                new DepartementEntity("52","Haute-Marne","Grand Est"),
                new DepartementEntity("53","Mayenne","Pays de la Loire"),
                new DepartementEntity("54","Meurthe-et-Moselle","Grand Est"),
                new DepartementEntity("55","Meuse","Grand Est"),
                new DepartementEntity("56","Morbihan","Bretagne"),
                new DepartementEntity("57","Moselle","Grand Est"),
                new DepartementEntity("58","Nièvre","Bourgogne-Franche-Comté"),
                new DepartementEntity("59","Nord","Hauts-de-France"),
                new DepartementEntity("60","Oise","Hauts-de-France"),
                new DepartementEntity("61","Orne","Normandie"),
                new DepartementEntity("62","Pas-de-Calais","Hauts-de-France"),
                new DepartementEntity("63","Puy-de-Dôme", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("64","Pyrénées-Atlantiques","Nouvelle-Aquitaine"),
                new DepartementEntity("65","Hautes-Pyrénées","Occitanie"),
                new DepartementEntity("66","Pyrénées-Orientales","Occitanie"),
                new DepartementEntity("67","Bas-Rhin","Grand Est"),
                new DepartementEntity("68","Haut-Rhin","Grand Est"),
                new DepartementEntity("69","Rhône", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("70","Haute-Saône","Bourgogne-Franche-Comté"),
                new DepartementEntity("71","Saône-et-Loire","Bourgogne-Franche-Comté"),
                new DepartementEntity("72","Sarthe","Pays de la Loire"),
                new DepartementEntity("73","Savoie", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("74","Haute-Savoie", "Auvergne-Rhône-Alpes"),
                new DepartementEntity("75","Paris","Île-de-France"),
                new DepartementEntity("76","Seine-Maritime","Normandie"),
                new DepartementEntity("77","Seine-et-Marne","Île-de-France"),
                new DepartementEntity("78","Yvelines","Île-de-France"),
                new DepartementEntity("79","Deux-Sèvres","Nouvelle-Aquitaine"),
                new DepartementEntity("80","Somme","Hauts-de-France"),
                new DepartementEntity("81","Tarn","Occitanie"),
                new DepartementEntity("82","Tarn-et-Garonne","Occitanie"),
                new DepartementEntity("83","Var","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("84","Vaucluse","Provence-Alpes-Côte d'Azur"),
                new DepartementEntity("85","Vendée","Pays de la Loire"),
                new DepartementEntity("86","Vienne","Nouvelle-Aquitaine"),
                new DepartementEntity("87","Haute-Vienne","Nouvelle-Aquitaine"),
                new DepartementEntity("88","Vosges","Grand Est"),
                new DepartementEntity("89","Yonne","Bourgogne-Franche-Comté"),
                new DepartementEntity("90","Territoire de Belfort","Bourgogne-Franche-Comté"),
                new DepartementEntity("91","Essonne","Île-de-France"),
                new DepartementEntity("92","Hauts-de-Seine","Île-de-France"),
                new DepartementEntity("93","Seine-St-Denis","Île-de-France"),
                new DepartementEntity("94","Val-de-Marne","Île-de-France"),
                new DepartementEntity("95","Val-D'Oise","Île-de-France"),
                new DepartementEntity("971","Guadeloupe","Guadeloupe"),
                new DepartementEntity("972","Martinique","Martinique"),
                new DepartementEntity("973","Guyane","Guyane"),
                new DepartementEntity("974","La Réunion","La Réunion"),
                new DepartementEntity("976","Mayotte","Mayotte"));
        departementEntityRepository.saveAll(of);
    }
}
