package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.UserLikePostDTO;
import site.sac.service.PostService;
import site.sac.service.UserLikePostService;
import site.sac.service.UsersService;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/posts/like")
public class UserLikePostController {
    @Autowired
    private UserLikePostService userLikePostService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<UserLikePostDTO> postLike(RequestEntity<UserLikePostDTO> requestEntity){
        userLikePostService.postLike(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping
    public ResponseEntity<UserLikePostDTO> postLikeDelete(RequestEntity<UserLikePostDTO> requestEntity){
        userLikePostService.postDelete(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/list") //수정 필요
    public ResponseEntity<Map<String,Object>> getUserLikePosts(RequestEntity<String> requestEntity){
        long userId = Long.parseLong(requestEntity.getBody());
        Map<String,Object> result = userLikePostService.getPostsByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);

        }

    }

