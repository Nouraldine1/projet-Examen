package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.HasUser;
import org.ism.core.factory.IEntity;

@Data
@AllArgsConstructor
public class Boutiquier implements IEntity, HasUser {
    protected int id;
    protected String noms;
    protected String prenoms;
    protected String telephone;
    protected User user;

    protected static int cpt;

    public Boutiquier() {
        cpt++;
        this.id = cpt;
    }

    public Boutiquier(String noms, String prenoms, String telephone, User user) {
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
        return "Boutiquier{" +
                "id=" + id +
                ", noms='" + noms + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", telephone='" + telephone + '\'' +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }
}
