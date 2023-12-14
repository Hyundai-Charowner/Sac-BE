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
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private PostResponseService postResponseService;

    @PostMapping
    public ResponseEntity<String> postInsert(RequestEntity<PostDTO> postDTO) {
        try {
            postService.register(postDTO.getBody());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping("/page")
    public ResponseEntity<Map<String, Object>> getAllPost(@RequestBody Map<String, Long> requestBody) {
        try {
            Map<String, Object> result = postResponseService.getPagingPost(requestBody.get("pageNum"));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostDetail(RequestEntity<String> requestEntity, @PathVariable Long postId) {
        try {
            PostDTO postDetail = postService.getPostDetail(postId);
            return new ResponseEntity<>(postDetail, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }

    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Map<String, Object>> getAllPostByBoardId(RequestEntity<String> requestEntity, @PathVariable Long boardId) {
        try {
            Map<String, Object> result = postService.getPostsByBoardId(boardId);

            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

    }

    @GetMapping("/like")
    public ResponseEntity<Map<String, Object>> getLikePostByUserId(RequestEntity<String> requestEntity) {
        try {
            Map<String, Object> result = postService.getAllPostByUserId(Long.parseLong(requestEntity.getBody()));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> postEdit(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId) {
        try {
            postService.postEdit(requestEntity.getBody());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDTO> postDelete(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId) {
        try {
            postService.delete(requestEntity.getBody(), postId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
