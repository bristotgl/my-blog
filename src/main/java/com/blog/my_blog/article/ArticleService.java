package com.blog.my_blog.article;

import com.blog.my_blog.exception.ResourceNotFoundException;
import com.blog.my_blog.tag.Tag;
import com.blog.my_blog.tag.TagService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final TagService tagService;

    public ArticleService(ArticleRepository articleRepository, TagService tagService) {
        this.articleRepository = articleRepository;
        this.tagService = tagService;
    }

    @Transactional
    protected Article createArticle(ArticleRequest articleRequest) {
        Article article = new Article();

        article.setTitle(articleRequest.title());
        article.setContent(articleRequest.content());
        article.setAuthor(articleRequest.author());
        article.setCreatedAt(LocalDateTime.now());

        Set<Tag> tags = tagService.findOrCreateTags(articleRequest.tags());
        tags.forEach(article::addTag);

        return articleRepository.save(article);
    }

    protected List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    protected Article getArticleById(UUID id) {
        return articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article with id " + id + " not found"));
    }

    protected void deleteArticleById(UUID id) {
        if (!articleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Article with id " + id + "not found");
        }
        articleRepository.deleteById(id);
    }

    public void updateArticleById(UUID id, ArticleRequest articleRequest) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article with id " + id + " not found"));
        article.setTitle(articleRequest.title());
        article.setContent(articleRequest.content());

        Set<Tag> tags = tagService.findOrCreateTags(articleRequest.tags());
        article.setTags(tags);

        articleRepository.save(article);
    }

    public List<Article> getArticlesByTags(Set<String> tags) {
        return articleRepository.findByTags_NameIn(tags);
    }

    public List<Article> getArticlesByDate(LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
        return articleRepository.findByCreatedAtBetween(startOfDay, endOfDay);
    }

    public List<Article> getArticlesByNewest() {
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Article> getArticlesByOldest() {
        return articleRepository.findAllByOrderByCreatedAtAsc();
    }
}
