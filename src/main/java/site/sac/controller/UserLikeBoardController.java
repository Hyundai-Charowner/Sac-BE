package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.service.UserLikeBoardService;
import site.sac.service.UsersService;

import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserLikeBoardController {
    @Autowired
    private UserLikeBoardService userLikeBoardService;

    @Autowired
    private UsersService usersService;
    @GetMapping("/boards")
    public ResponseEntity<Map<String,Object>> getUserLikeBoards(RequestEntity<String> requestEntity){
        long userId = Long.parseLong(requestEntity.getBody());
        Map<String,Object> result = userLikeBoardService.getAllByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
    @PostMapping("/boards")
    public ResponseEntity<String> insertLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity){
        log.info(requestEntity.toString());
        userLikeBoardService.insert(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<String> deleteLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity, @PathVariable Long boardId){
        userLikeBoardService.delete(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
