package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.service.PostResponseService;
import site.sac.service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostResponseService postResponseService;

    @PostMapping("")
    public ResponseEntity<String> postInsert(RequestEntity<PostDTO> postDTO, HttpServletRequest request) throws DataAccessException {
        postService.register(postDTO.getBody(), (long) request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/page")
    public ResponseEntity<Map<String,Object>> getAllPost() throws DataAccessException {
        Map<String, Object> result = postResponseService.getPagingPost(requestBody.get("pageNum"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostDetail(@PathVariable Long postId) throws DataAccessException {
        PostDTO postDetail = postService.getPostDetail(postId);
        return new ResponseEntity<>(postDetail, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<Map<String,Object>> getAllPostByBoardId(@PathVariable Long boardId) throws DataAccessException {
        Map<String, Object> result= postService.getPostsByBoardId(boardId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/like")
    public ResponseEntity<Map<String,Object>> getLikePostByUserId(RequestEntity<String> requestEntity){
        Map<String,Object> result = postService.getAllPostByUserId(Long.parseLong(requestEntity.getBody()));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> postEdit(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId) throws DataAccessException, NullPointerException {
        postService.postEdit(requestEntity.getBody(), postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDTO> postDelete(RequestEntity<PostDTO> requestEntity, @PathVariable Long postId){
        postService.delete(requestEntity.getBody(), postId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
