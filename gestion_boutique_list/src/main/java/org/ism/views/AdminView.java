package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class AdminView {
    private static final Scanner scanner = new Scanner(System.in);

    private AdminView() {}

    public static int menu() {
        MessagePrinter.printMessage("Faites votre choix : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Admin create() {
        MessagePrinter.printMessage("\n========= Enregistrer un administrateur =========");

        MessagePrinter.printMessage("Noms : ");
        String noms = scanner.nextLine();

        MessagePrinter.printMessage("Prénoms : ");
        String prenoms = scanner.nextLine();

        MessagePrinter.printMessage("Téléphone : ");
        String telephone = scanner.nextLine();

        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> adminParams = new HashMap<>();
        adminParams.put("noms", noms);
        adminParams.put("prenoms", prenoms);
        adminParams.put("telephone", telephone);
        adminParams.put("user", null);

        return (Admin) factory.createEntity("Admin", adminParams);
    }

    public static void show(List<Admin> admins) {
        MessagePrinter.printMessage("========= Liste des admins =========");
        if(admins.isEmpty()) {
            MessagePrinter.printMessage("Aucun admin trouvé.");
        } else {
            for (Admin admin : admins) {
                MessagePrinter.printParameter(admin);
            }
        }
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'identifiant de l'admin : ");
        return Integer.parseInt(scanner.nextLine());
    }
}
