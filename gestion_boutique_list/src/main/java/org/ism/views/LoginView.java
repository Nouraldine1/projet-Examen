package org.ism.views;

import org.ism.core.utils.MessagePrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class LoginView {
    private static final Scanner scanner = new Scanner(System.in);

    private LoginView() {}

    public static int menuConnexion() {
        MessagePrinter.printMessage("Menu Connexion:");
        MessagePrinter.printMessage("1. Espace Admin");
        MessagePrinter.printMessage("2. Espace Boutiquier");
        MessagePrinter.printMessage("3. Espace Client");
        MessagePrinter.printMessage("0. Quitter");
        MessagePrinter.printMessage("Faites votre choix: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static Map<String, String> connexion(String userType) {
        MessagePrinter.printMessage("Login " + userType + " :");
        String login = scanner.nextLine();
        MessagePrinter.printMessage("Password :");
        String password = scanner.nextLine();

        Map<String, String> connexionParams = new HashMap<>();
        connexionParams.put("login", login);
        connexionParams.put("password", password);

        return connexionParams;
    }
}
