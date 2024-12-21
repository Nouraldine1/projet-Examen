package org.ism.menus;

import org.ism.core.config.Config;
import org.ism.core.initializers.AdminInitializer;
import org.ism.core.initializers.ArticleInitializer;
import org.ism.core.utils.MessagePrinter;
import org.ism.menus.clients.MenuClient;
import org.ism.services.*;
import org.ism.views.LoginView;

public abstract class MainMenu {
    private static final IAdminService adminService = Config.getAdminService();
    private static final IBoutiquierService boutiquierService = Config.getBoutiquierService();
    private static final IClientService clientService = Config.getClientService();
    private static final IUserService userService = Config.getUserService();
    private static final IArticleService articleService = Config.getArticleService();


    private MainMenu() {}

    public static void start() {
        initialize();
        int choice;
        do {
            choice = LoginView.menuConnexion();

            switch (choice) {
                case 1 -> AdminMenu.start(adminService);
                case 2 -> BoutiquierMenu.start(boutiquierService);
                case 3 -> MenuClient.start(clientService);
                case 0 -> MessagePrinter.printMessage("Au revoir!");
                default -> MessagePrinter.printMessage("Choix invalide!");
            }
        } while (choice != 0);
    }

    public static void initialize() {
        // Initialiser l'Admin par défaut
        AdminInitializer adminInitializer = new AdminInitializer(adminService, userService);
        adminInitializer.initializeDefaultAdmin();

        ArticleInitializer articleInitializer = new ArticleInitializer(articleService);
        articleInitializer.initializeDefaultArticles();
    }
}
