package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.mapper.PostMapper;
import site.sac.service.PostService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public String postInsert(@RequestBody PostDTO postDTO){
        try {
            postService.register(postDTO);
            return "sucess";
        }catch (Exception e){
            return "fail";
        }
    }

    @GetMapping("/posts")
    public ResponseEntity<Map<String,Object>> getAllPost(){
        List<PostDTO> posts = postService.getAllPost();
        Map<String,Object> result = new HashMap<>();

        result.put("posts", posts);
        result.put("count", posts.size());
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostDetail(@PathVariable Long postId){
        PostDTO postDetail = postService.getPostDetail(postId);
        if (postDetail == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(postDetail, HttpStatus.OK);
    }
    @GetMapping("/posts/{boardId}")
    public ResponseEntity<Map<String,Object>> getAllPostByBoardId(@PathVariable Long boardId){
        List<PostDTO> posts = postService.getPostsByBoardId(boardId);
        if (posts==null){
            return ResponseEntity.notFound().build();
        }
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        result.put("count", posts.size());
        return ResponseEntity.ok().body(result);
    }

}
