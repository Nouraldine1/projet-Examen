package org.ism.entities.enums;

public enum EtatDemande {
    EN_COURS("En cours"),
    ACCEPTER("Accepter"),
    REJETER("Rejeter");

    private final String value;

    private EtatDemande(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
