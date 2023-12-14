package site.sac.mapper;

import site.sac.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    int insert(BoardDTO boardDTO);

    List<BoardDTO> readAll();

}
