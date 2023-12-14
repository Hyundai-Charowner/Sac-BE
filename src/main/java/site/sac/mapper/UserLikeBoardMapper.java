package site.sac.mapper;

import site.sac.dto.UserLikeBoardDTO;

import java.util.List;

public interface UserLikeBoardMapper {
    void insert(UserLikeBoardDTO userLikeBoardDTO);

    void delete(UserLikeBoardDTO userLikeBoardDTO);

    List<String> getAllByUserId(long user_id);
}
