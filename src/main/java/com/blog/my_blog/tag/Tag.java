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
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tags", schema = "public")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private UUID id;

    @NotEmpty
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    @NotNull
    private List<Article> articles = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }
}
