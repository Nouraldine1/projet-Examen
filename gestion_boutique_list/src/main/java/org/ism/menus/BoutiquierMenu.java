package org.ism.menus;

import org.ism.core.actions.IAction;
import org.ism.core.actions.impl.*;
import org.ism.core.config.Config;
import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Boutiquier;
import org.ism.services.*;
import org.ism.views.BoutiquierView;

import java.util.HashMap;
import java.util.Map;


public abstract class BoutiquierMenu {

    private BoutiquierMenu(){}

    private static final Map<Integer, IAction> actions = new HashMap<>();

    static {
        actions.put(1, new ClientMenuIActionImpl(Config.getClientService()));
        actions.put(2, new ArticleMenuIActionImpl(Config.getArticleService()));
        actions.put(3, new DemandeMenuIActionImpl(Config.getDemandeService()));
        actions.put(4, new DetteMenuIActionImpl(Config.getDetteService()));
    }


    public static void start(IBoutiquierService boutiquierService) {
        // Authentification
        Boutiquier boutiquier = LoginMenu.connexionUtilisateur(boutiquierService, "Boutiquier");

        if (boutiquier != null) {
            int choice;
            do {
                MessagePrinter.printMessage("\n===== Menu Boutiquier =====");
                actions.forEach((key, action) -> System.out.println(key + ". " + action.getDescription()));
                MessagePrinter.printMessage("0. Déconnexion");

                choice = BoutiquierView.menu();

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
