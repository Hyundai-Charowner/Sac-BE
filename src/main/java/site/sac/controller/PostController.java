package site.sac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.sac.mapper.PostMapper;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostMapper postMapper;

    

}
