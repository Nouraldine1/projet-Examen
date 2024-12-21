package org.ism.menus;

import org.ism.core.config.Config;
import org.ism.entities.Client;
import org.ism.entities.User;
import org.ism.entities.enums.RoleUser;
import org.ism.services.IClientService;
import org.ism.services.IUserService;
import org.ism.views.ClientView;
import org.ism.views.UserView;

import java.util.Scanner;

public abstract class ClientMenu {
    private static final IUserService userService = Config.getUserService();

    private static final Scanner scanner = new Scanner(System.in);

    private ClientMenu() {}

    public static void start(IClientService clientService) {
        int choix;

        do {
            choix = ClientView.menu();

            switch (choix) {
                case 1 :
                    Client client = ClientView.create();

                    System.out.println("Voulez-vous associer un compte utilisateur à ce client ?");
                    String response = scanner.nextLine();

                    if(response.equalsIgnoreCase("oui")) {
                        User user = UserView.createAccount();
                        user.setRole(RoleUser.CLIENT);
                        userService.save(user);
                        client = userService.associerUser(client, user);
                    }

                    clientService.save(client);
                    break;
                case 2 :
                    ClientView.show(clientService.findAll());
                    break;
                case 3 :
                    String telephone = ClientView.inputTelephone();
                    Client clientTrouve = clientService.findClientByTelephone(telephone);
                    ClientView.showClientByPhone(clientTrouve);
                    break;
                case 0 :
                    System.out.println("Retour au menu principal.");
                    return;
                default : System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }
}
