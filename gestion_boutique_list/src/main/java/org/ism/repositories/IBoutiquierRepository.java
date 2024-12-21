package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Boutiquier;

public interface IBoutiquierRepository extends IRepository<Boutiquier> {
    Boutiquier findByLogin(String login);
}
