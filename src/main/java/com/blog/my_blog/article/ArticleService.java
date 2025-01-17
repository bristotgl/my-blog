package com.blog.my_blog.article;

import com.blog.my_blog.tag.Tag;
import com.blog.my_blog.tag.TagService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final TagService tagService;

    public ArticleService(ArticleRepository articleRepository, TagService tagService) {
        this.articleRepository = articleRepository;
        this.tagService = tagService;
    }

    @Transactional
    public Article createArticle(ArticleRequest articleRequest) {
        Article article = new Article();

        article.setTitle(articleRequest.title());
        article.setContent(articleRequest.content());
        article.setAuthor(articleRequest.author());
        article.setPublicationDate(LocalDateTime.now());

        Set<Tag> tags = tagService.findOrCreateTags(articleRequest.tags());
        tags.forEach(article::addTag);

        return articleRepository.saveAndFlush(article);
    }
}
