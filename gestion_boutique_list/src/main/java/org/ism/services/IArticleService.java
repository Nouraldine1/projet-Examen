package org.ism.services;

import java.util.List;

import org.ism.core.IRepository;
import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;


public interface IArticleService extends IRepository<Article> {
    Article findByLibelle(String libelle);
    List<Article> findByEtat(EtatArticle etat);

    void updateEtat(Article article);
}
