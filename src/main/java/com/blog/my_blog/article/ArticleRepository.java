package com.blog.my_blog.article;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    List<Article> findByTags_NameIn(Set<String> tags);

    List<Article> findByCreatedAtBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);

    List<Article> findAllByOrderByCreatedAtDesc();

    List<Article> findAllByOrderByCreatedAtAsc();
}
