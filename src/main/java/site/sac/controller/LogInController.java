package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.service.UsersService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/login")
public class LogInController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/google")
    public ResponseEntity<String> googleLogin(@RequestBody GoogleOAuthDTO googleOAuth, HttpServletResponse response) {
        try {
            String token = usersService.register(googleOAuth);
            Cookie cookie = new Cookie("accessToken", token);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            return ResponseEntity.status(200).body(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Fail");
        }
    }
}
