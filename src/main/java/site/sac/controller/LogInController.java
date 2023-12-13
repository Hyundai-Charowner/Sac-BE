package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/google")
    public ResponseEntity<String> googleLogin(@RequestBody GoogleOAuthDTO googleOAuth, HttpServletResponse response) {
         try{
            return ResponseEntity.status(HttpStatus.OK).body(usersService.register(googleOAuth));
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
