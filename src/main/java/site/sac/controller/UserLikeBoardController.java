package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.PostDTO;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.dto.UsersDTO;
import site.sac.service.UserLikeBoardService;
import site.sac.service.UserLikeBoardServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserLikeBoardController {
    @Autowired
    private UserLikeBoardService userLikeBoardService;

    @GetMapping("/user/boards")
    public ResponseEntity<Map<String,Object>> getUserLikeBoards(@RequestBody UsersDTO usersDTO){
        long testId = 1L;
        List<String> list = userLikeBoardService.getAllByUserId(testId);
        Map<String,Object> result = new HashMap<>();

        result.put("likeList", list);
        result.put("count", list.size());
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/user/boards/{boardId}")
    public ResponseEntity<String> insertLikeBoard(@PathVariable Long boardId){
        long testId = 1L;
        UserLikeBoardDTO dto = new UserLikeBoardDTO();
        dto.setBoard_id(boardId);
        dto.setUser_id(testId);
        userLikeBoardService.insert(dto);
        return ResponseEntity.ok().body("success");

    }

}
