package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.service.PostResponseService;
import site.sac.service.PostService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostResponseService postResponseService;

    @PostMapping("/posts")
    public ResponseEntity<String> postInsert(RequestEntity<PostDTO> postDTO) {
        try {
            postService.register(postDTO.getBody());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

//    @GetMapping("/posts") // 로그인 처리X
//    public ResponseEntity<Map<String, Object>> getAllPost() {
//        try {
//            Map<String, Object> result = postService.getAllPost();
//            return ResponseEntity.status(HttpStatus.OK).body(result);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//
//    }
    @GetMapping("/posts/page/{pageNum}") // 로그인 처리X
    public ResponseEntity<Map<String, Object>> getAllPost(@PathVariable long pageNum) {
        try {
            Map<String, Object> result = postResponseService.getPagingPost(pageNum);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostDetail(RequestEntity<String> requestEntity, @PathVariable Long postId) {
        try {
            PostDTO postDetail = postService.getPostDetail(postId);
            return new ResponseEntity<>(postDetail, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }

    @GetMapping("/post/{boardId}")
    public ResponseEntity<Map<String, Object>> getAllPostByBoardId(RequestEntity<String> requestEntity, @PathVariable Long boardId) {
        try {
            Map<String, Object> result = postService.getPostsByBoardId(boardId);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/posts/like") //수정 필요
    public ResponseEntity<Map<String, Object>> getLikePostByUserId(RequestEntity<String> requestEntity) {
        try {
            Map<String, Object> result = postService.getAllPostByUserId(Long.parseLong(requestEntity.getBody()));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> postEdit(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId) {
        try {
            postService.postEdit(requestEntity.getBody());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> postDelete(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId) {
        try {
            postService.delete(requestEntity.getBody(), postId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
