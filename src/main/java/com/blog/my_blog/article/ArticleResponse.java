package com.blog.my_blog.article;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record ArticleResponse(
        UUID id,
        String title,
        String content,
        String author,
        LocalDateTime createdAt,
        Set<String> tags
) {
}
