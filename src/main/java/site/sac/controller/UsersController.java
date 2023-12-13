package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.dto.ReplyDTO;
import site.sac.service.ReplyService;
import site.sac.service.UsersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/replies")
    public ResponseEntity<Map<String,Object>> getAllRepliesByUserId(RequestEntity<String> requestEntity){

        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)) {
            try {
                List<ReplyDTO> replies = replyService.getAllReplyByUserId(userId);
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
}
