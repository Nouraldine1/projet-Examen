package org.ism.menus.clients;

import org.ism.core.actions.IAction;
import org.ism.core.actions.impl.*;
import org.ism.core.config.Config;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Client;
import org.ism.menus.LoginMenu;
import org.ism.services.*;
import org.ism.views.ClientView;

import java.util.HashMap;
import java.util.Map;


public class MenuClient {

    private MenuClient() {}

    private static final Map<Integer, IAction> actions = new HashMap<>();

    static {
        actions.put(1, new ClientMenuDemandeActionImpl(Config.getDemandeService(), Config.getArticleService(), null));
        actions.put(2, new ClientMenuDetteActionImpl(Config.getDetteService(), null));
    }

    public static void start(IClientService clientService) {
        Client client = LoginMenu.connexionUtilisateur(clientService, "Client");

        if(client != null) {
            actions.put(1, new ClientMenuDemandeActionImpl(Config.getDemandeService(), Config.getArticleService(), client));
            actions.put(2, new ClientMenuDetteActionImpl(Config.getDetteService(), client));

            int choice;
            do {
                MessagePrinter.printMessage("\n===== Menu Client =====");
                actions.forEach((key, action) -> System.out.println(key + ". " + action.getDescription()));
                MessagePrinter.printMessage("0. Déconnexion");

                choice = ClientView.menuClients();

                if (actions.containsKey(choice)) {
                    actions.get(choice).execute();
                } else if (choice != 0) {
                    MessagePrinter.printMessage("Choix invalide !");
                }
            } while (choice != 0);
        } else {
            MessagePrinter.printMessage("Identifiants invalides.");
        }
    }

}
