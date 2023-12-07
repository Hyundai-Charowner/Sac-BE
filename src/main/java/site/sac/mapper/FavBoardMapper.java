package site.sac.mapper;

import site.sac.dto.FavBoardDTO;

import java.util.List;

public interface FavBoardMapper {
    public void insert(FavBoardDTO favBoardDTO);

    public void delete(FavBoardDTO favBoardDTO);

    public List<FavBoardDTO> getAllByUserId(long user_id);
}
