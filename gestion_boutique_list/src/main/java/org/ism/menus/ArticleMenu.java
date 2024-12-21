package org.ism.menus;

import org.ism.core.utils.MessagePrinter;
import org.ism.entities.Article;
import org.ism.services.IArticleService;
import org.ism.views.ApproView;
import org.ism.views.ArticleView;

public abstract class ArticleMenu {

    private ArticleMenu(){}

    public static void start(IArticleService articleService) {
            // Menu Articles
            int choice;
            do {
                choice = ArticleView.menu();
                switch (choice) {
                    case 1:
                        // Enregistrer un article
                        Article article = ArticleView.create();
                        articleService.save(article);
                        break;
                    case 2:
                        // Lister tous les articles
                        ArticleView.show(articleService.findAll());
                        break;
                    case 3:
                        ApproMenu.start();
                        break;
                    case 4:
                        String libelle = ArticleView.inputLibelle();
                        Article articleTrouve = articleService.findByLibelle(libelle);
                        ArticleView.showByLibelle(articleTrouve);
                        break;
                    case 0:
                        MessagePrinter.printMessage("Précédent...");
                        break;
                    default:
                        MessagePrinter.printMessage("Choix invalide");
                }
            } while (choice != 0);
    }

}
