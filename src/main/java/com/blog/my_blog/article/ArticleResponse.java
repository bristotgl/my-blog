package com.blog.my_blog.article;

import java.time.LocalDateTime;
import java.util.Set;

public record ArticleResponse(
        long id,
        String title,
        String content,
        String author,
        LocalDateTime publicationDate,
        Set<String> tags
) {
}
