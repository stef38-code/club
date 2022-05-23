package org.stephane.club.entities;

public final class DepartementEntityBuilder {
    private DepartementEntity departementEntity;

    private DepartementEntityBuilder() {
        departementEntity = new DepartementEntity();
    }

    public static DepartementEntityBuilder create() {
        return new DepartementEntityBuilder();
    }

    public DepartementEntityBuilder numero(String numero) {
        departementEntity.setNumero(numero);
        return this;
    }

    public DepartementEntityBuilder departement(String departement) {
        departementEntity.setDepartement(departement);
        return this;
    }

    public DepartementEntityBuilder region(String region) {
        departementEntity.setRegion(region);
        return this;
    }

    public DepartementEntity build() {
        return departementEntity;
    }
}
