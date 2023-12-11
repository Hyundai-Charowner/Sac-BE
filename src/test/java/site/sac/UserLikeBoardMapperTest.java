package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.mapper.UserLikeBoardMapper;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
public class UserLikeBoardMapperTest {
    @Autowired
    UserLikeBoardMapper userLikeBoardMapper;

    @Test
    void testInsert(){
        UserLikeBoardDTO userLikeBoardDTO = new UserLikeBoardDTO();
        userLikeBoardDTO.setUser_id(1);
        userLikeBoardDTO.setBoard_id(3);
        userLikeBoardMapper.insert(userLikeBoardDTO);
    }

    @Test
    void testGetAllByUserId(){
        List<String> list = userLikeBoardMapper.getAllByUserId(1);
        list.forEach(a->log.info(a.toString()));
        log.info(list.toString());
    }
}
