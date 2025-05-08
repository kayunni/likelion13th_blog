package likelion13th.blog.controller;

import jakarta.annotation.PostConstruct;
import likelion13th.blog.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final List<Article> articleDB = new ArrayList<>();
    private Long nextId = 1L;

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article newArticle = new Article(
                article.getContent(),
                nextId++,
                article.getTitle(),
                article.getAuthor(),
                article.getPassword()
        );

        // DB에 객체 저장
        articleDB.add(newArticle);

        //저장한 객체 반환
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newArticle);
    }
    @GetMapping
    public ResponseEntity<List<Article>> getArticle() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(articleDB);
    }
}
