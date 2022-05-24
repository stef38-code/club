package org.stephane.club.entities;

public final class CommuneApiGouvEntityBuilder {
    private CommuneApiGouvEntity communeApiGouvEntity;

    private CommuneApiGouvEntityBuilder() {
        communeApiGouvEntity = new CommuneApiGouvEntity();
    }

    public static CommuneApiGouvEntityBuilder create() {
        return new CommuneApiGouvEntityBuilder();
    }

    public CommuneApiGouvEntityBuilder code(String code) {
        communeApiGouvEntity.setCode(code);
        return this;
    }

    public CommuneApiGouvEntityBuilder nom(String nom) {
        communeApiGouvEntity.setNom(nom);
        return this;
    }

    public CommuneApiGouvEntityBuilder codeDepartement(String codeDepartement) {
        communeApiGouvEntity.setCodeDepartement(codeDepartement);
        return this;
    }

    public CommuneApiGouvEntityBuilder codeRegion(String codeRegion) {
        communeApiGouvEntity.setCodeRegion(codeRegion);
        return this;
    }

    public CommuneApiGouvEntityBuilder codePostal(String codePostal) {
        communeApiGouvEntity.setCodePostal(codePostal);
        return this;
    }

    public CommuneApiGouvEntityBuilder population(int population) {
        communeApiGouvEntity.setPopulation(population);
        return this;
    }

    public CommuneApiGouvEntity build() {
        return communeApiGouvEntity;
    }
}
