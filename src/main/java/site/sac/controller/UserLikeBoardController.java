package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.BoardDTO;
import site.sac.dto.PostDTO;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.dto.UsersDTO;
import site.sac.service.UserLikeBoardService;
import site.sac.service.UserLikeBoardServiceImpl;
import site.sac.service.UsersService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserLikeBoardController {
    @Autowired
    private UserLikeBoardService userLikeBoardService;

    @Autowired
    private UsersService usersService;
    @GetMapping("/user/boards")
    public ResponseEntity<Map<String,Object>> getUserLikeBoards(RequestEntity<UserLikeBoardDTO> requestEntity){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);
        if(accessToken !=null && usersService.isExistToken(accessToken)){
            try {
                List<String> list = userLikeBoardService.getAllByUserId(userId);
                Map<String,Object> result = new HashMap<>();

                result.put("likeList", list);
                result.put("count", list.size());
                return ResponseEntity.ok().body(result);
            } catch (Exception e){return ResponseEntity.status(500).body(null);}

        }
        return ResponseEntity.status(500).body(null);
    }
    @PostMapping("/user/boards/{boardId}")
    public ResponseEntity<String> insertLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity, @PathVariable Long boardId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            requestEntity.getBody().setUser_id(userId);
            UserLikeBoardDTO dto = requestEntity.getBody();
            userLikeBoardService.insert(dto);
            return ResponseEntity.ok().body("board 추가 성공");
        }

        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/user/boards/{boardId}")
    public ResponseEntity<String> deleteLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity, @PathVariable Long boardId){
        String accessToken = requestEntity.getHeaders().getFirst("accessToken");
        long userId = usersService.findUserIdByToken(accessToken);

        if(accessToken !=null && usersService.isExistToken(accessToken)){
            try {
                requestEntity.getBody().setUser_id(userId);
                userLikeBoardService.delete(requestEntity.getBody());
                return ResponseEntity.ok().body("board 삭제 성공");
            }
            catch (Exception e){
                return ResponseEntity.notFound().build();
            }

        }
        return ResponseEntity.notFound().build();
    }
}
