package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.service.UsersService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/google")
    public ResponseEntity<String> googleLogin(@RequestBody GoogleOAuthDTO googleOAuth) {
        try {
            String token = usersService.register(googleOAuth);
            return ResponseEntity.status(200).body(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Fail");
        }
    }
}
