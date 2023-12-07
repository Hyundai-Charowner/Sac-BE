package site.sac.mapper;

import site.sac.dto.BoardDTO;

import java.util.List;

public interface BoardMapper {
    public int insert(BoardDTO boardDTO);

    public BoardDTO read(Long board_id);

    public List<BoardDTO> readAll();
}
