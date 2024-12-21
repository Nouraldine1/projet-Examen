package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.ism.core.factory.IEntity;
import org.ism.entities.enums.RoleUser;


@Data
@AllArgsConstructor
public class User implements IEntity {
    private int id;
    private String login; // unique
    private String password;
    private RoleUser role;  // ADMIN, BOUTIQUIER, CLIENT
    private boolean isActive;

    private static int cpt;

    public User() {
        cpt++;
        this.id = cpt;
    }

    public User(String login, String password, RoleUser role, boolean isActive) {
        cpt++;
        this.id = cpt;
        this.login = login;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login +
                ", password='" + password +
                ", role='" + role.getValue() +
                ", isActive='" + isActive +
                '}';
    }
}
