package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.entities.Client;
import org.ism.menus.clients.DemandeMenuClient;
import org.ism.services.IArticleService;
import org.ism.services.IDemandeService;

public class ClientMenuDemandeActionImpl implements IAction {
    private final IDemandeService demandeService;
    private final IArticleService articleService;
    private final Client client;

    public ClientMenuDemandeActionImpl(IDemandeService demandeService, IArticleService articleService, Client client) {
        this.demandeService = demandeService;
        this.articleService = articleService;
        this.client = client;
    }

    @Override
    public void execute() {
        DemandeMenuClient.start(demandeService,articleService, client);
    }

    @Override
    public String getDescription() {
        return "Demandes";
    }
}
