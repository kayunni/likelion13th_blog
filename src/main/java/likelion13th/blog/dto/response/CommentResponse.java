package likelion13th.blog.dto.response;

import likelion13th.blog.domain.Comment;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Builder @AllArgsConstructor
public class CommentResponse {
    private final Long id;
    private final Long articleId;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;


    public static CommentResponse of(Comment comment){
        return CommentResponse.builder()
                .id(comment.getId())
                .articleId(comment.getArticle().getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .createdAt(comment.getCreatedAt())
                .build();

    }
}