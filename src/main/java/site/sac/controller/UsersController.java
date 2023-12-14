package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.dto.UsersDTO;
import site.sac.service.ReplyService;
import site.sac.service.UsersService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/replies")
    public ResponseEntity<Map<String, Object>> getAllRepliesByUserId(HttpServletRequest request) {
        Map<String, Object> result = replyService.getAllReplyByUserId((long)request.getAttribute("userId"));
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/info")
    public ResponseEntity<UsersDTO> getUserInfo(HttpServletRequest request) {
        UsersDTO result = usersService.userInfo((   long)request.getAttribute("userId"));
        return ResponseEntity.ok().body(result);
    }
}
