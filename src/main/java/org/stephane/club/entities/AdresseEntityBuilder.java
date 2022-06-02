package org.stephane.club.entities;

public final class AdresseEntityBuilder {
    private AdresseEntity adresseEntity;

    private AdresseEntityBuilder() {
        adresseEntity = new AdresseEntity();
    }

    public static AdresseEntityBuilder create() {
        return new AdresseEntityBuilder();
    }

    public AdresseEntityBuilder id(String id) {
        adresseEntity.setId(id);
        return this;
    }


    public AdresseEntity build() {
        return adresseEntity;
    }
}
