package org.ism.entities.enums;

public enum StatutDette {
    SOLDEE("Soldée"),
    NON_SOLDEE("Non soldée");

    private final String value;

    private StatutDette(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
