package site.sac.mapper;

import site.sac.dto.BoardDTO;

public interface BoardMapper {
    public int insert(BoardDTO boardDTO);

    public BoardDTO read(Long board_id);
}
