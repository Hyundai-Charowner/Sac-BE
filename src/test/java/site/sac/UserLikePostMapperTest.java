package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.UserLikePostLikeDTO;
import site.sac.mapper.UserLikePostMapper;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
public class UserLikePostMapperTest {
    @Autowired
    UserLikePostMapper userLikePostMapper;

    @Test
    void testInsert(){
        UserLikePostLikeDTO userLikePostLikeDTO = new UserLikePostLikeDTO();
        userLikePostLikeDTO.setPost_id(243);
        userLikePostLikeDTO.setUser_id(1);
        userLikePostMapper.insert(userLikePostLikeDTO);
    }
    @Test
    void testDelete(){
        UserLikePostLikeDTO userLikePostLikeDTO = new UserLikePostLikeDTO();
        userLikePostLikeDTO.setPost_id(1);
        userLikePostLikeDTO.setUser_id(1);
        userLikePostMapper.delete(userLikePostLikeDTO);
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
