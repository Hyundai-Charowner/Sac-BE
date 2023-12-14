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

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserLikeBoardController {
    @Autowired
    private UserLikeBoardService userLikeBoardService;


    @GetMapping("/boards")
    public ResponseEntity<Map<String,Object>> getUserLikeBoards(HttpServletRequest request) throws DataAccessException {
        Map<String,Object> result = userLikeBoardService.getAllByUserId((long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/boards")
    public ResponseEntity<String> insertLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity, HttpServletRequest request) throws DataAccessException {
        userLikeBoardService.insert(requestEntity.getBody(), (long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<String> deleteLikeBoard(RequestEntity<UserLikeBoardDTO> requestEntity, HttpServletRequest request) throws DataAccessException {
        userLikeBoardService.delete(requestEntity.getBody(), (long)request.getAttribute("userId"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
