package org.ism.menus;

import java.util.Map;

import org.ism.core.HasUser;
import org.ism.core.IService;
import org.ism.entities.User;
import org.ism.views.LoginView;


public abstract class LoginMenu {
    private LoginMenu(){}

    // Connexion
    public static <T> T connexionUtilisateur(IService<T> service, String userType) {

        Map<String, String> connexion = LoginView.connexion(userType);

        T utilisateur = service.findByLogin(connexion.get("login"));
        if ((utilisateur != null) && (utilisateur instanceof HasUser)) {
            User user = ((HasUser) utilisateur).getUser();
            if (user != null && user.getLogin().equals(connexion.get("login")) && user.getPassword().equals(connexion.get("password"))) {
                return utilisateur;
            }
        }

        return null;
    }
}
