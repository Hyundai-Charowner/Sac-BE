package site.sac;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import site.sac.dto.BoardDTO;
import site.sac.mapper.BoardMapper;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({ "file:src/test/resources/root-context.xml" })
@Slf4j
public class BoardMapperTest {
    @Autowired
    BoardMapper boardMapper;

    @Test
    void testInsert(){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_category("피구");

        int a = boardMapper.insert(boardDTO);
        System.out.println(a);
    }

    @Test
    void testReadAll(){
        List<BoardDTO> list = boardMapper.readAll();
        list.forEach(a->log.info(a.toString()));

    }
}
