package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.dto.UserLikePostDTO;
import site.sac.service.PostService;
import site.sac.service.UserLikePostService;
import site.sac.service.UsersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/posts/like")
public class UserLikePostController {
    @Autowired
    private UserLikePostService userLikePostService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PostService postService;

    @PostMapping("/{postId}")
    public ResponseEntity<UserLikePostDTO> postLike(RequestEntity<UserLikePostDTO> requestEntity, @PathVariable Long postId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        log.info(requestEntity.toString());
        if(accessToken !=null && usersService.isExistToken(accessToken)){
            requestEntity.getBody().setUser_id(userId);
            userLikePostService.postLike(requestEntity.getBody());
            return ResponseEntity.ok().body(requestEntity.getBody());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("")
    public ResponseEntity<UserLikePostDTO> postLikeDelete(RequestEntity<UserLikePostDTO> requestEntity){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            requestEntity.getBody().setUser_id(userId);
            userLikePostService.postDelete(requestEntity.getBody());
            log.info(requestEntity.toString());
            return ResponseEntity.ok().body(requestEntity.getBody());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("") //수정 필요
    public ResponseEntity<Map<String,Object>> getUserLikePosts(RequestEntity<String> requestEntity){

        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        log.info(requestEntity.toString());
        try{
            List<Long> list = userLikePostService.getPostsByUserId(userId);
            List<PostDTO> posts = new ArrayList<>();
            log.info(list.toString());
            list.forEach(postId -> { posts.add(postService.getPostDetail(postId));
            });

            Map<String,Object> result = new HashMap<>();
            result.put("posts", posts);
            result.put("count", posts.size());

            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);}
        }

    }

