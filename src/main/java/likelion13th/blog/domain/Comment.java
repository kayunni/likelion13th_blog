//import java.time.LocalDateTime;
//
//public class Comment {
//    private Long id;
//    private Article article;
//    private String content;
//    private String author;
//    private String password;
//    private LocalDateTime createdAt;
//
//    public Comment(Long id, Article article, String content, String author, String password) {
//        this.id = id;
//        this.article = article;
//        this.content = content;
//        this.author = author;
//        this.password = password;
//        this.createdAt = LocalDateTime.now();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Article getArticle() {
//        return article;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//}

package likelion13th.blog.domain;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="article_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Article article;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
