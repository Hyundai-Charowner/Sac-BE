package site.sac.user;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Log
@RestController
@RequestMapping("/google/*")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/oauth")
    public void register(@RequestBody Users users) {
        System.out.println(users);
        System.out.println("유저");
        usersService.register(users);
    }

}
