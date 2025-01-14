package com.blog.my_blog.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final List<Article> articles = Arrays.asList(
            new Article(1, "Hello", "first blog post", LocalDateTime.now(), "gabriel", Arrays.asList("dev", "tech")),
            new Article(2, "Best tech stack", "spring with react", LocalDateTime.now(), "gabriel", Arrays.asList("dev", "tech", "job")),
            new Article(3, "Super cars", "honda fit 2007", LocalDateTime.now(), "gabriel", Arrays.asList("cars", "sport"))
    );

    @GetMapping
    public List<Article> getArticles() {
        return articles;
    }
}
