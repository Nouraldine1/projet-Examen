package org.ism.core.actions.impl;

import org.ism.core.actions.IAction;
import org.ism.menus.ArticleMenu;
import org.ism.services.IArticleService;

public class ArticleMenuIActionImpl implements IAction {
    private final IArticleService articleService;

    public ArticleMenuIActionImpl(IArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public void execute() {
        // Déléguer la gestion au menu Article
        ArticleMenu.start(articleService);
    }

    @Override
    public String getDescription() {
        return "Articles";
    }
}
