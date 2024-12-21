package org.ism.entities.enums;

public enum RoleUser {
    ADMIN("Admin"),
    BOUTIQUIER("Boutiquier"),
    CLIENT("Client");

    private final String value;

    private RoleUser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
