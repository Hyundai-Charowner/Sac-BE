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

    @PostMapping("")
    public ResponseEntity<UserLikePostDTO> postLike(RequestEntity<UserLikePostDTO> requestEntity){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        log.info(requestEntity.toString());
        if(accessToken !=null && usersService.isExistToken(accessToken)){
            try {
                requestEntity.getBody().setUser_id(userId);
                userLikePostService.postLike(requestEntity.getBody());
                return ResponseEntity.status(200).body(requestEntity.getBody());
            } catch (Exception e){ return ResponseEntity.status(500).build();}

        }
        return ResponseEntity.status(500).build();
    }

    @DeleteMapping
    public ResponseEntity<UserLikePostDTO> postLikeDelete(RequestEntity<UserLikePostDTO> requestEntity){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            try{
                requestEntity.getBody().setUser_id(userId);
                userLikePostService.postDelete(requestEntity.getBody());
                log.info(requestEntity.toString());
                return ResponseEntity.status(200).body(requestEntity.getBody());
            } catch (Exception e){
                return ResponseEntity.status(500).build();
            }

        }
        return ResponseEntity.status(500).build();
    }


    @GetMapping("/like") //수정 필요
    public ResponseEntity<Map<String,Object>> getUserLikePosts(RequestEntity<String> requestEntity){

        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        try{
            List<Long> list = userLikePostService.getPostsByUserId(userId);
            List<PostDTO> posts = postService.getPostsByLike(list);

            Map<String,Object> result = new HashMap<>();
            result.put("posts", posts);
            result.put("count", posts.size());

            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);}
        }

    }

