package org.ism.core.actions;

public interface IAction {
    void execute();           // Exécuter l'action
    String getDescription();  // Description affichée dans le menu
}
