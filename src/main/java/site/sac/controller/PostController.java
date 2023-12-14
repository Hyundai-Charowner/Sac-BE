package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.dto.PostResponseDTO;
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

    @PostMapping
    public ResponseEntity<String> postInsert(RequestEntity<PostDTO> postDTO, HttpServletRequest request) throws DataAccessException {
        postService.register(postDTO.getBody(), (long) request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/page")
    public ResponseEntity<Map<String, Object>> getAllPost(@RequestBody Map<String, Long> requestBody) {
        Map<String, Object> result = postResponseService.getPagingPost(requestBody.get("pageNum"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO> getPostDetail(@PathVariable Long postId) throws DataAccessException {
        PostResponseDTO postDetail = postResponseService.getDetail(postId);
        return new ResponseEntity<>(postDetail, HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<Map<String,Object>> getAllPostByBoardId(@RequestBody Map<String, Long> requestBody) throws DataAccessException {
        Map<String, Object> result= postResponseService.getPagingPostByBoardId(requestBody.get("boardId"), requestBody.get("pageNum"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String,Object>> getAllPostByUserId(HttpServletRequest request){
            Map<String,Object> result = postService.getAllPostByUserId((long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping
    public ResponseEntity<PostDTO> postEdit(RequestEntity<PostDTO> requestEntity, HttpServletRequest request) throws DataAccessException, NullPointerException {
        postService.postEdit(requestEntity.getBody(), (long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping
    public ResponseEntity<PostDTO> postDelete(RequestEntity<PostDTO> requestEntity, HttpServletRequest request){
        log.info(requestEntity.toString());
        postService.delete(requestEntity.getBody(), (long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
