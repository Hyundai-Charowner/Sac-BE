package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.dto.ReplyDTO;
import site.sac.service.ReplyService;
import site.sac.service.UsersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/posts")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/replies/{postId}")
    public ResponseEntity<Map<String,Object>> getAllRepliesByPostId(RequestEntity<String> requestEntity, @PathVariable long postId){

        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            try {
                List<ReplyDTO> replies = replyService.getAllReplyByPostId(postId);
                Map<String, Object> result = new HashMap<>();
                result.put("replies", replies);
                result.put("count", replies.size());
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.status(500).build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    @PostMapping("/reply/{postId}")
    public ResponseEntity<String> replyInesrt(RequestEntity<ReplyDTO> requestEntity, @PathVariable long postId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            requestEntity.getBody().setUser_id(userId);
            requestEntity.getBody().setPost_id(postId);
            replyService.replyInsert(requestEntity.getBody());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(500).build();

    }

    @PutMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDTO> replyEdit(RequestEntity<ReplyDTO> requestEntity, @PathVariable long replyId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            if (replyService.replyRead(replyId).getUser_id() == userId){

                requestEntity.getBody().setReply_id(replyId);
                replyService.replyUpdate(requestEntity.getBody());
                return ResponseEntity.status(200).body(requestEntity.getBody());
        }
    }
        return ResponseEntity.status(500).body(requestEntity.getBody());
    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<String> replyDelete(RequestEntity<Long> requestEntity, @PathVariable long replyId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            if (replyService.replyRead(replyId).getUser_id() == userId){
                replyService.replyDelete(replyId);
                return ResponseEntity.ok().body(requestEntity.getBody() +" num, reply delete");
            }
        }
        return ResponseEntity.status(500).body("reply delete : fail");

    }

}
