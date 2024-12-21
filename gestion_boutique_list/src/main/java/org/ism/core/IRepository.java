package org.ism.core;

import java.util.List;

public interface IRepository<T> {
    T save(T entity); // Enregistre ou met à jour une entité
    T findById(int id); // Recherche par ID
    List<T> findAll(); // Renvoie toutes les entités
    void update(T entity);
    void delete(T entity); // Supprime une entité
    void deleteById(int id); // Supprime par ID
}
