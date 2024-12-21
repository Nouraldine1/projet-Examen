package org.ism.menus;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Admin;
import org.ism.entities.Boutiquier;
import org.ism.entities.Client;
import org.ism.entities.enums.RoleUser;
import org.ism.services.*;
import org.ism.views.UserView;

public abstract class UserMenu {

    private UserMenu() {}

    public static void start(IUserService userService, IAdminService adminService, IBoutiquierService boutiquierService, IClientService clientService) {
        int choice;
        do {
            // Menu User
            choice = UserView.menu();
            switch (choice) {
                case 1:
                    RoleUser role = UserView.selectRole();
                    switch (role) {
                        case ADMIN:
                            Admin admin = UserView.create(role);
                            assert admin != null;
                            userService.save(admin.getUser());
                            adminService.save(admin);
                            break;
                        case BOUTIQUIER:
                            Boutiquier boutiquier = UserView.create(role);
                            assert boutiquier != null;
                            userService.save(boutiquier.getUser());
                            boutiquierService.save(boutiquier);
                            break;
                        case CLIENT :
                            Client client = UserView.create(role);
                            assert client != null;
                            userService.save(client.getUser());
                            clientService.save(client);
                            break;
                    }
                    break;
                case 2:
                    break;
                case 0:
                    MessagePrinter.printMessage("Déconnexion...");
                    break;
                default: MessagePrinter.printMessage("Choix invalide!");
            }
        } while (choice != 0);
    }
}
