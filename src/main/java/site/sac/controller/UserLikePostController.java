package site.sac.controller;

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

@RestController
@RequestMapping("/api/posts")
public class UserLikePostController {
    @Autowired
    private UserLikePostService userLikePostService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private PostService postService;

    @PostMapping("/{postId}")
    public ResponseEntity<UserLikePostDTO> postLike(RequestEntity<UserLikePostDTO> userLikePostDTO, @PathVariable Long postId){
        String accessToken = userLikePostDTO.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            userLikePostDTO.getBody().setUser_id(userId);
            userLikePostService.postLike(userLikePostDTO.getBody());
            return ResponseEntity.ok().body(userLikePostDTO.getBody());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<UserLikePostDTO> postLikeDelete(RequestEntity<UserLikePostDTO> userLikePostDTO, @PathVariable Long postId){
        String accessToken = userLikePostDTO.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            userLikePostDTO.getBody().setUser_id(userId);
            userLikePostService.postDelete(userLikePostDTO.getBody());
            return ResponseEntity.ok().body(userLikePostDTO.getBody());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/") //수정 필요
    public ResponseEntity<Map<String,Object>> getUserLikePosts(RequestEntity<String> requestEntity){

        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        try{
            List<Long> list = userLikePostService.getPostsByUserId(userId);
            List<PostDTO> posts = new ArrayList<>();
            list.forEach(postId -> {
                PostDTO postDTO = postService.getPostDetail(postId);
                posts.add(postDTO);
            });

            Map<String,Object> result = new HashMap<>();
            result.put("posts", posts);
            result.put("count", posts.size());

            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }

    }

}
