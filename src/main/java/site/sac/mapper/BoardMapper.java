package site.sac.mapper;

import site.sac.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    public int insert(BoardDTO boardDTO);

    public List<BoardDTO> readAll();
}
