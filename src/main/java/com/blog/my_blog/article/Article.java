package com.blog.my_blog.article;

import java.time.LocalDateTime;
import java.util.List;

public record Article(long id, String title, String content, String author, LocalDateTime publicationDate,
                      List<String> tags) {
}
