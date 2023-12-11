package site.sac.mapper;

import site.sac.dto.UserLikeBoardDTO;

import java.util.List;

public interface UserLikeBoardMapper {
    public void insert(UserLikeBoardDTO userLikeBoardDTO);

    public void delete(UserLikeBoardDTO userLikeBoardDTO);

    public List<String> getAllByUserId(long user_id);
}
