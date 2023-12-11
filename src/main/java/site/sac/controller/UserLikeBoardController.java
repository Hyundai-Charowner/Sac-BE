package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import site.sac.service.UserLikeBoardService;
import site.sac.service.UserLikeBoardServiceImpl;

@Controller
public class UserLikeBoardController {
    @Autowired
    private UserLikeBoardService userLikeBoardService;


}
