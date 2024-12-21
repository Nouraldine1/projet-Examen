package org.ism.repositories;

import org.ism.core.IRepository;
import org.ism.entities.Article;
import org.ism.entities.enums.EtatArticle;

public interface IArticleRepository extends IRepository<Article> {
    Article findByLibelle(String libelle);
    void updateEtat(Article article);
}
