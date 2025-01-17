package com.blog.my_blog.article;

import com.blog.my_blog.tag.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<ArticleResponse> createArticle(@RequestBody @Validated ArticleRequest articleRequest) {
        Article article = articleService.createArticle(articleRequest);

        ArticleResponse response = new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.getPublicationDate(),
                article.getTags().stream().map(Tag::getName).collect(Collectors.toSet())
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
