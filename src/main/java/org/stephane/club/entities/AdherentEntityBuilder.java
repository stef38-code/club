package org.stephane.club.entities;

import java.time.LocalDate;

public final class AdherentEntityBuilder {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dnaissance;
    private GenreEntity genre;
    private String nlicence;

    private AdherentEntityBuilder() {
    }

    public static AdherentEntityBuilder create() {
        return new AdherentEntityBuilder();
    }

    public AdherentEntityBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AdherentEntityBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public AdherentEntityBuilder prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public AdherentEntityBuilder dnaissance(LocalDate dnaissance) {
        this.dnaissance = dnaissance;
        return this;
    }

    public AdherentEntityBuilder genre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    public AdherentEntityBuilder nlicence(String nlicence) {
        this.nlicence = nlicence;
        return this;
    }

    public AdherentEntity build() {
        AdherentEntity adherentEntity = new AdherentEntity();
        adherentEntity.setId(id);
        adherentEntity.setNom(nom);
        adherentEntity.setPrenom(prenom);
        adherentEntity.setDnaissance(dnaissance);
        adherentEntity.setGenre(genre);
        adherentEntity.setNlicence(nlicence);
        return adherentEntity;
    }
}
