package org.ism.core.initializers;

import org.ism.entities.Admin;
import org.ism.entities.User;
import org.ism.entities.enums.RoleUser;
import org.ism.services.IAdminService;
import org.ism.services.IUserService;

// La logique d'initialisation de l'Admin est entièrement encapsulée dans AdminInitializer
public class AdminInitializer {
    private final IAdminService adminService;
    private final IUserService userService;

    public AdminInitializer(IAdminService adminService, IUserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    public void initializeDefaultAdmin() {
        String defaultLogin = "darnel-eteno@gmail.com";
        String defaultPassword = "passer123";

        if (adminService.findByLogin(defaultLogin) == null) {
            User user = new User();
            user.setLogin(defaultLogin);
            user.setPassword(defaultPassword);
            user.setRole(RoleUser.ADMIN);
            user.setActive(true);

            Admin admin = new Admin();
            admin.setUser(user);
            admin.setPrenoms("Darnel");
            admin.setNoms("Eteno");
            admin.setTelephone("773773803");

            userService.save(user);
            adminService.save(admin);

            System.out.println("Admin par défaut créé : " + defaultLogin);
        } else {
            System.out.println("Admin par défaut déjà existant.");
        }
    }
}
