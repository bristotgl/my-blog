package com.blog.my_blog.article;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final TagRepository tagRepository;

    public ArticleService(ArticleRepository articleRepository, TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Article createArticle(ArticleRequest articleRequest) {
        Article article = new Article();
        return null;
    }
}
