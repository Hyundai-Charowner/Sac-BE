package site.sac.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.service.UsersService;
@Slf4j
@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/google")
    public ResponseEntity<String> googleLogin(@RequestBody GoogleOAuthDTO googleOAuth) {
        log.info(googleOAuth.toString());
        log.info("===============");
        return ResponseEntity.status(HttpStatus.OK).body(usersService.register(googleOAuth));
    }
}
