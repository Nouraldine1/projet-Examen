package org.ism.views;

import org.ism.core.HasUser;
import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.factory.IEntity;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Admin;
import org.ism.entities.Boutiquier;
import org.ism.entities.Client;
import org.ism.entities.User;
import org.ism.entities.enums.RoleUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class UserView {
    private static final Scanner scanner = new Scanner(System.in);

    private UserView() {}

    public static int menu() {
        MessagePrinter.printMessage("=== Menu Principal ===");
        MessagePrinter.printMessage("1. Enregistrer un utilisateur");
        MessagePrinter.printMessage("2. Lister les utilisateurs");
        MessagePrinter.printMessage("0. Quitter");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static User createAccount() {
        MessagePrinter.printMessage("\n=== Création d'un compte associé ===");
        MessagePrinter.printMessage("Login :");
        String login = scanner.nextLine();
        MessagePrinter.printMessage("Password :");
        String password = scanner.nextLine();

        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        params.put("password", password);
        params.put("role", null);
        params.put("isActive", false);

        return (User) factory.createEntity("User", params);
    }

    public static void showAccounts(List<User> users) {
        if(!users.isEmpty()) {
            for(User user : users) {
                MessagePrinter.printParameter(user);
            }
        } else {
            MessagePrinter.printMessage("Aucun utilisateur trouvé.");
        }
    }

    public static void show(List<IEntity> users) {
        if(!users.isEmpty()) {
            for(IEntity user : users) {
                MessagePrinter.printParameter(user);
            }
        } else {
            MessagePrinter.printMessage("Aucun utilisateur trouvé.");
        }
    }

    public static <T extends HasUser> T create(RoleUser roleUser) {
        User user = null;

        // En fonction du rôle de l'utilisateur, créer un type spécifique
        switch (roleUser) {
            case ADMIN:
                Admin admin = AdminView.create();
                user = createAccount(); // Créer un compte utilisateur
                admin.setUser(user);
                return (T) admin;  // Retourner l'entité spécifique de type Admin
            case BOUTIQUIER:
                Boutiquier boutiquier = BoutiquierView.create();
                user = createAccount(); // Créer un compte utilisateur
                boutiquier.setUser(user);
                return (T) boutiquier;  // Retourner l'entité spécifique de type Boutiquier
            case CLIENT:
                Client client = ClientView.create();
                user = createAccount(); // Créer un compte utilisateur
                client.setUser(user);
                return (T) client;  // Retourner l'entité spécifique de type Client
            default:
                MessagePrinter.printMessage("Choix invalide.");
                return null;
        }
    }

    public static RoleUser selectRole() {
        int choix;
        RoleUser role = null;

        do {
            choix = menuRole();
            switch (choix) {
                case 1:
                    role = RoleUser.ADMIN;
                    break;
                case 2:
                    role = RoleUser.BOUTIQUIER;
                    break;
                case 3:
                    role = RoleUser.CLIENT;
                    break;
                default:
                    MessagePrinter.printMessage("Choix invalide. Veuillez réessayer !");
            }
        } while (choix != 1 && choix != 2 && choix != 3);

        return role;
    }

    public static int menuRole() {
        MessagePrinter.printMessage("Sélectionnez le type d'utilisateur: ");
        MessagePrinter.printMessage("1. Admin");
        MessagePrinter.printMessage("2. Boutiquier");
        MessagePrinter.printMessage("3. Client");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

}
