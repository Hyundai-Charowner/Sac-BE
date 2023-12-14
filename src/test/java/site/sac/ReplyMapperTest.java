package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.ReplyDTO;
import site.sac.mapper.ReplyMapper;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
public class ReplyMapperTest {
    @Autowired
    private ReplyMapper replyMapper;

    @Test
    void testInsert(){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setPost_id(1);
        replyDTO.setUser_id(1);
        replyDTO.setReply_content("들어갔으면 좋겠따223");
        replyMapper.insert(replyDTO);
    }
    @Test
    void testRead(){

        log.info(replyMapper.read(1).toString());
    }

    @Test
    void testGetAllReplyByPostId(){
        List<ReplyDTO> list = replyMapper.getAllReplyByPostId(1);
        list.forEach(a ->log.info(a.toString()));

    }

    @Test
    void testDelete(){
        replyMapper.delete(1);
    }
}
