package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.PostDTO;
import site.sac.mapper.PostMapper;
import site.sac.mapper.UserLikeBoardMapper;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
class PostMapperTest {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserLikeBoardMapper userLikeBoardMapper;

    @BeforeEach
    void setUp() {
        log.info("되나");
    }
    @DisplayName("Post_insert")
    @Test
    void testInsert() {
        PostDTO postDTO = new PostDTO();
        postDTO.setUser_id(Integer.parseInt("1"));
        postDTO.setBoard_id(Integer.parseInt("2"));
        postDTO.setPost_head("222222222");
        postDTO.setPost_content("2222222222222 집이요142");
        System.out.println(postDTO);
        postMapper.insert(postDTO);
        log.info("되는지좀 알려줘요");
    }
    @DisplayName("Post_read")
    @Test
    void testRead(){
        PostDTO postDTO= postMapper.read(1);
        log.info("post 1: " + postDTO.toString());
    }

    @DisplayName("Post_update")
    @Test
    void testUpdate(){
        PostDTO postDTO = postMapper.read(1);
        postDTO.setPost_content("수정이 될까 안될까");

        log.info("update    " + postDTO.toString());
        postMapper.update(postDTO);
    }
    @DisplayName("Post_delete")
    @Test
    void testDelete(){
        postMapper.delete(4);
    }

    @DisplayName("count_up")
    @Test
    void testCountUp(){
        postMapper.countUp(1);

    }
    @DisplayName("like_up")
    @Test
    void testLikeup(){
        postMapper.likeUp(1);
    }
    @DisplayName("like_down")
    @Test
    void testLikedown(){
        postMapper.likeDown(1);
    }
    @DisplayName("all List")
    @Test
    void testGetAllPost(){
        List<PostDTO> list = postMapper.getAllPost();
        list.forEach(postDTO -> log.info("get all : " +postDTO.toString()));

    }

    @Test
    void testGetAllPostByUserID(){
        //user_id가 1일때
        List<String> test = userLikeBoardMapper.getAllByUserId(1);
        log.info(test.toString());
        List<PostDTO> list =postMapper.getAllPostByUserLikeBoard(test);
        list.forEach(a->log.info(a.toString()));
    }
}
