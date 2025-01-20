package com.blog.my_blog.article;

import com.blog.my_blog.tag.Tag;

import java.util.stream.Collectors;

public class ArticleResponseBuilder {
    public static ArticleResponse build(Article article) {
        return new ArticleResponse(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.getCreatedAt(),
                article.getTags().stream().map(Tag::getName).collect(Collectors.toSet())
        );
    }
}
