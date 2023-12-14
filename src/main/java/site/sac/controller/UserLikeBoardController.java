package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public ResponseEntity<Map<String,Object>> getUserLikeBoards(RequestEntity<String> requestEntity) throws DataAccessException {
        Map<String,Object> result = userLikeBoardService.getAllByUserId(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/boards")
    public ResponseEntity<String> insertLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity) throws DataAccessException {
        log.info(requestEntity.toString());
        userLikeBoardService.insert(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<String> deleteLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity) throws DataAccessException {
        userLikeBoardService.delete(requestEntity.getBody());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
