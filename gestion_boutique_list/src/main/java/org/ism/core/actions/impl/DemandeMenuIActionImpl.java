package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.menus.DemandeMenu;
import org.ism.services.IDemandeService;

public class DemandeMenuIActionImpl implements IAction {
    private final IDemandeService demandeService;

    public DemandeMenuIActionImpl(IDemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @Override
    public void execute() {
        // Déléguer la gestion au menu Demandes
        DemandeMenu.start(demandeService);
    }

    @Override
    public String getDescription() {
        return "Demandes";
    }
}
