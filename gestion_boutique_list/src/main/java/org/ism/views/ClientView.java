package org.ism.views;

import org.ism.core.factory.ConcreteEntityFactory;
import org.ism.core.factory.EntityFactory;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Client;

import java.util.*;

public abstract class ClientView {
    private static final Scanner scanner = new Scanner(System.in);

    private ClientView(){}

    public static int menu() {
        MessagePrinter.printMessage("Menu Client:");
        MessagePrinter.printMessage("1. Enregistrer un client");
        MessagePrinter.printMessage("2. Lister les clients");
        MessagePrinter.printMessage("3. Rechercher un client par téléphone");
        MessagePrinter.printMessage("0. Quitter");
        MessagePrinter.printMessage("Faites votre choix : ");

        return Integer.parseInt(scanner.nextLine());
    }

    public static int menuClients() {
        MessagePrinter.printMessage("Faites votre choix : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Client create() {
        MessagePrinter.printMessage("========= Enregistrer un client =========");

        MessagePrinter.printMessage("Noms : ");
        String noms = scanner.nextLine();

        MessagePrinter.printMessage("Prénoms : ");
        String prenoms = scanner.nextLine();

        MessagePrinter.printMessage("Téléphone : ");
        String telephone = scanner.nextLine();

        MessagePrinter.printMessage("Adresse : ");
        String adresse = scanner.nextLine();

        EntityFactory factory = new ConcreteEntityFactory();

        Map<String, Object> clientParams = new HashMap<>();
        clientParams.put("noms", noms);
        clientParams.put("prenoms", prenoms);
        clientParams.put("telephone", telephone);
        clientParams.put("adresse", adresse);
        clientParams.put("demandes", new ArrayList<>());
        clientParams.put("dettes", new ArrayList<>());
        clientParams.put("user", null);

        return (Client) factory.createEntity("Client", clientParams);
    }

    public static void show(List<Client> clients) {
        MessagePrinter.printMessage("========= Liste des clients =========");
        if(clients.isEmpty()) {
            MessagePrinter.printMessage("Aucun client trouvé.");
        } else {
            for (Client client : clients) {
                MessagePrinter.printParameter(client);
            }
        }
    }

    public static void showClientByPhone(Client client) {
        if(client != null) {
            MessagePrinter.printParameter(client);
        } else {
            MessagePrinter.printMessage("Aucun client trouvé avec ce téléphone.");
        }
    }

    public static Client searchByTelephone(List<Client> clients) {
        MessagePrinter.printMessage("Saisissez le numéro de téléphone du client :");
        String telephone = scanner.nextLine();

        for (Client client : clients) {
            if (client.getTelephone().equals(telephone)) {
                return client;
            }
        }

        return null;
    }

    public static int inputIdentifiant() {
        MessagePrinter.printMessage("Veuillez saisir l'identifiant du client : ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputTelephone() {
        MessagePrinter.printMessage("Veuillez saisir le numéro de téléphone du client : ");
        return scanner.nextLine();
    }

}
