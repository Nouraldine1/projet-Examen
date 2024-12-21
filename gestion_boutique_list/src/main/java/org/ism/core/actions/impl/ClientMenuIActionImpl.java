package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.menus.ClientMenu;
import org.ism.services.IClientService;

public class ClientMenuIActionImpl implements IAction {
    private final IClientService clientService;

    public ClientMenuIActionImpl(IClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        // Déléguer la gestion au menu Client
        ClientMenu.start(clientService);
    }

    @Override
    public String getDescription() {
        return "Clients";
    }
}
