package likelion13th.blog.controller;

import likelion13th.blog.dto.*;
import likelion13th.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;
import java.util.List;
import java.util.ArrayList;
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleService articleService;

    /*게시글 추가*/
    @PostMapping
    public ResponseEntity<ApiResponse> createArticle(@RequestBody AddArticleRequest request){
        ArticleResponse response=articleService.addArticle(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse(true,201,"게시글 등록 성공",response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> readAllArticles(){
        List<SimpleArticleResponse> articles = articleService.getAllArticles();
        return ResponseEntity.ok(new ApiResponse(true, 200, "게시글 조회 성공", articles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> readArticle(@PathVariable Long id){
        ArticleDetailResponse response = articleService.getArticle(id);
        return ResponseEntity.ok(new ApiResponse(true, 200, "게시글 조회 성공", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request){
        ArticleResponse response = articleService.updateArticle(id, request);

        return ResponseEntity.ok(new ApiResponse(true, 204, "게시글 수정 성공", response));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<ApiResponse> deleteArticle(@PathVariable Long id, @RequestBody DeleteRequest request){
        articleService.deleteArticle(id, request);
        return ResponseEntity.ok(new ApiResponse(true, 204, "게시글 삭제 성공"));
    }
}