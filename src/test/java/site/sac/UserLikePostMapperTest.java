package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.UserLikePostDTO;
import site.sac.mapper.UserLikePostMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
public class UserLikePostMapperTest {
    @Autowired
    UserLikePostMapper userLikePostMapper;

    @Test
    void testInsert(){
        UserLikePostDTO userLikePostDTO = new UserLikePostDTO();
        userLikePostDTO.setPost_id(243);
        userLikePostDTO.setUser_id(1);
        userLikePostMapper.insert(userLikePostDTO);
    }
    @Test
    void testDelete(){
        UserLikePostDTO userLikePostDTO = new UserLikePostDTO();
        userLikePostDTO.setPost_id(1);
        userLikePostDTO.setUser_id(1);
        userLikePostMapper.delete(userLikePostDTO);
    }

    @Test
    void testCountByPostId(){
        System.out.println(userLikePostMapper.countByPostId(2));
    }

    @Test
    void testGetAllByUserId(){
        log.info(userLikePostMapper.getAllByUserId(1).toString());
    }
}
