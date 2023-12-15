package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.dto.UsersDTO;
import site.sac.service.PostResponseService;
import site.sac.service.ReplyService;
import site.sac.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PostResponseService postResponseService;

    @GetMapping("/replies")
    public ResponseEntity<Map<String, Object>> getAllRepliesByUserId(HttpServletRequest request) {
        log.info("1");
        Map<String, Object> result = replyService.getAllReplyByUserId((long)request.getAttribute("userId"));
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/info")
    public ResponseEntity<UsersDTO> getUserInfo(HttpServletRequest request) {
        UsersDTO result = usersService.userInfo((   long)request.getAttribute("userId"));
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/posts")
    public ResponseEntity<Map<String, Object>> getAllPostByLikeBoard(HttpServletRequest request) {
        Map<String, Object> result = postResponseService.getAllPostByLikeBoard((long)request.getAttribute("userId"));
        return ResponseEntity.ok().body(result);
    }
}
