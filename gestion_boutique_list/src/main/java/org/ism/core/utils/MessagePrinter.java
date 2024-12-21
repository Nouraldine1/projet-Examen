package org.ism.core.utils;

public class MessagePrinter {
    private MessagePrinter() {}

    // Méthode pour afficher les messages simples
    public static void printMessage(String message) {
        System.out.println(message);
    }

    // Méthode pour afficher un seul paramètre
    public static void printParameter(Object param) {
        System.out.println(param);
    }

    // Méthode pour afficher les messages avec un formatage spécifique
    public static void printFormattedMessage(String message, String type) {
        switch (type.toLowerCase()) {
            case "info":
                System.out.println("[INFO] " + message);
                break;
            case "warning":
                System.out.println("[WARNING] " + message);
                break;
            case "error":
                System.out.println("[ERROR] " + message);
                break;
            default:
                System.out.println(message);
        }
    }

    // Méthode pour afficher un message avec des paramètres
    public static void printMessageWithParams(String message, Object... params) {
        System.out.println(String.format(message, params));
    }
}
