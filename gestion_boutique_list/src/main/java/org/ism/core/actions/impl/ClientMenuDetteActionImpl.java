package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.entities.Client;
import org.ism.menus.clients.DetteMenuClient;
import org.ism.services.IDetteService;

public class ClientMenuDetteActionImpl implements IAction {
    private final IDetteService detteService;
    private final Client client;

    public ClientMenuDetteActionImpl(IDetteService detteService, Client client) {
        this.detteService = detteService;
        this.client = client;
    }

    @Override
    public void execute() {
        DetteMenuClient.start(detteService, client);
    }

    @Override
    public String getDescription() {
        return "Dettes";
    }
}
