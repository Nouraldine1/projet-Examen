package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.menus.UserMenu;
import org.ism.services.*;

public class UserMenuIActionImpl implements IAction {
    private final IUserService userService;
    private final IAdminService adminService;
    private final IClientService clientService;
    private final IBoutiquierService boutiquierService;

    public UserMenuIActionImpl(IUserService userService, IAdminService adminService, IBoutiquierService boutiquierService, IClientService clientService) {
        this.userService = userService;
        this.adminService = adminService;
        this.boutiquierService = boutiquierService;
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        UserMenu.start(userService, adminService, boutiquierService, clientService);
    }

    @Override
    public String getDescription() {
        return "Utilisateurs";
    }
}
