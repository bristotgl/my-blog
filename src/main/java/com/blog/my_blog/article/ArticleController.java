package com.blog.my_blog.article;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleResponse>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        List<ArticleResponse> response = articles.stream()
                .map(ArticleResponseBuilder::build)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("by-tags")
    public ResponseEntity<List<ArticleResponse>> getArticlesByTags(@RequestParam Set<String> tags) {
        List<Article> articles = articleService.getArticlesByTags(tags);
        List<ArticleResponse> response = articles.stream().map(ArticleResponseBuilder::build).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("by-date")
    public ResponseEntity<List<ArticleResponse>> getArticlesByDate(@RequestParam LocalDate date) {
        List<Article> articles = articleService.getArticlesByDate(date);
        List<ArticleResponse> response = articles.stream().map(ArticleResponseBuilder::build).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("by-newest")
    public ResponseEntity<List<ArticleResponse>> getArticlesByNewest() {
        List<Article> articles = articleService.getArticlesByNewest();
        List<ArticleResponse> response = articles.stream().map(ArticleResponseBuilder::build).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("by-oldest")
    public ResponseEntity<List<ArticleResponse>> getArticlesByOldest() {
        List<Article> articles = articleService.getArticlesByOldest();
        List<ArticleResponse> response = articles.stream().map(ArticleResponseBuilder::build).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable UUID id) {
        Article article = articleService.getArticleById(id);
        ArticleResponse response = ArticleResponseBuilder.build(article);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody @Validated ArticleRequest articleRequest) {
        Article article = articleService.createArticle(articleRequest);

        ArticleResponse response = ArticleResponseBuilder.build(article);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteArticleById(@PathVariable UUID id) {
        articleService.deleteArticleById(id);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateArticleById(@PathVariable UUID id, @RequestBody @Validated ArticleRequest articleRequest) {
        articleService.updateArticleById(id, articleRequest);
    }
}
