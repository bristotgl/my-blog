package com.blog.my_blog.tag;

import com.blog.my_blog.article.Article;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    long id;

    @NotNull
    @NotEmpty
    @Column(nullable = false, unique = true)
    String name;

    @ManyToMany(mappedBy = "tags")
    @NotNull
    private List<Article> articles = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public void addArticle(Article article) {
        articles.add(article);
        article.getTags().add(this);
    }
}
