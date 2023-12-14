package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.ReplyDTO;
import site.sac.service.ReplyService;
import site.sac.service.UsersService;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/posts")
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/replies/{postId}")
    public ResponseEntity<Map<String,Object>> getAllRepliesByPostId(RequestEntity<String> requestEntity, @PathVariable long postId){
            try {
                Map<String, Object> result = replyService.getAllReplyByPostId(postId);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.status(500).build();
            }
    }

    @PostMapping("/reply/{postId}")
    public ResponseEntity<String> replyInesrt(RequestEntity<ReplyDTO> requestEntity, @PathVariable long postId){
            try{
                requestEntity.getBody().setPost_id(postId);
                replyService.replyInsert(requestEntity.getBody());
                return ResponseEntity.status(200).build();
            } catch (Exception e){return ResponseEntity.status(500).build();}

    }

    @PutMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDTO> replyUpdate(RequestEntity<ReplyDTO> requestEntity, @PathVariable long replyId){
            replyService.replyUpdate(requestEntity.getBody(), replyId);
            return ResponseEntity.status(200).body(requestEntity.getBody());

    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<String> replyDelete(RequestEntity<ReplyDTO> requestEntity, @PathVariable long replyId){
        try{
            replyService.replyDelete(requestEntity.getBody(), replyId);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
