package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/google")
    public ResponseEntity<String> googleLogin(@RequestBody GoogleOAuthDTO googleOAuth, HttpServletResponse response) {
        try {
            log.info(googleOAuth.toString());
            String token = usersService.register(googleOAuth);
            return ResponseEntity.status(200).body(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login Fail");
        }
    }
}
