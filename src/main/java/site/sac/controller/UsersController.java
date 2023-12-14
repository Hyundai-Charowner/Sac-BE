package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.service.ReplyService;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/replies")
    public ResponseEntity<Map<String, Object>> getAllRepliesByUserId(RequestEntity<String> requestEntity) {
        long userId = Long.parseLong(requestEntity.getBody());
        Map<String, Object> result = replyService.getAllReplyByUserId(userId);
        return ResponseEntity.ok().body(result);
    }
}
