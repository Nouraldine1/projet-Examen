package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.menus.DetteMenu;
import org.ism.services.IDetteService;

public class DetteMenuIActionImpl implements IAction {
    private final IDetteService detteService;

    public DetteMenuIActionImpl(IDetteService detteService) {
        this.detteService = detteService;
    }

    @Override
    public void execute() {
        DetteMenu.start(detteService);
    }

    @Override
    public String getDescription() {
        return "Dettes";
    }
}
