package org.ism.entities.enums;

public enum EtatArticle {
    RUPTURE("Rupture"),
    DISPONIBLE("Disponible");

    private final String value;

    private EtatArticle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
