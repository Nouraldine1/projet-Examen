package org.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ism.core.HasUser;
import org.ism.core.factory.IEntity;

import java.util.List;

@Data
@AllArgsConstructor
public class Client implements IEntity, HasUser {
    private int id;
    private String noms;
    private String prenoms;
    private String telephone;
    private String adresse;
    private List<Demande> demandes;
    private List<Dette> dettes;
    private User user;

    private static int cpt;

    public Client() {
        cpt++;
        this.id = cpt;
    }

    public Client(final String noms, final String prenoms, final String telephone, final String adresse, final List<Demande> demandes, final List<Dette> dettes, final User user) {
        cpt++;
        this.id = cpt;
        this.noms = noms;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.adresse = adresse;
        this.demandes = demandes;
        this.dettes = dettes;
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
        return "Client{" +
                "id=" + id +
                ", noms=" + noms +
                ", prénoms=" + prenoms +
                ", téléphone=" + telephone +
                ", adresse=" + adresse +
                ", demandes=" + demandes.size() +
                ", dettes=" + dettes.size() +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }

}
