package site.sac.controller;

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

@RestController
@RequestMapping("/api/posts")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/replies/{postId}") //수정 필요
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
                return ResponseEntity.status(500).body(null);
            }
        }
        return ResponseEntity.status(500).body(null);
    }

    @PostMapping("/reply/{postId}")
    public ResponseEntity<String> replyInesrt(RequestEntity<ReplyDTO> requestEntity, @PathVariable long postId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            requestEntity.getBody().setUser_id(userId);
            replyService.replyInsert(requestEntity.getBody());
            return ResponseEntity.ok().body("reply insert : success");
        }
        return ResponseEntity.status(500).body("reply insert : fail");

    }

    @PutMapping("/reply/{postId}")
    public ResponseEntity<ReplyDTO> replyEdit(RequestEntity<ReplyDTO> requestEntity, @PathVariable long postId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            if (replyService.replyRead(requestEntity.getBody().getUser_id()).getUser_id() == userId){
                ReplyDTO replyDTO = replyService.replyUpdate(requestEntity.getBody());
            return ResponseEntity.ok().body(replyDTO);
        }
    }
        return ResponseEntity.status(500).body(null);
    }

    @DeleteMapping("/reply/{postId}")
    public ResponseEntity<String> replyDelete(RequestEntity<Long> requestEntity, @PathVariable long postId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            if (replyService.replyRead(requestEntity.getBody()).getUser_id() == userId){
                replyService.replyDelete(requestEntity.getBody());
                return ResponseEntity.ok().body(requestEntity.getBody() +" num, reply delete");
            }
        }
        return ResponseEntity.status(500).body("reply delete : fail");

    }

}
