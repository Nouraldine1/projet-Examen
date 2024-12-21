package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.HasUser;
import org.ism.core.factory.IEntity;

@Data
@AllArgsConstructor
public class Admin implements IEntity, HasUser {
    private int id;
    private String noms;
    private String prenoms;
    private String telephone;
    private User user;

    private static int cpt;

    public Admin() {
        cpt++;
        this.id = cpt;
    }

    public Admin(String noms, String prenoms, String telephone, User user) {
        cpt++;
        this.id = cpt;
        this.noms = noms;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.user = user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", noms='" + noms + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }

}
