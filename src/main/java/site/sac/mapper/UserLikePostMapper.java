package site.sac.mapper;

import site.sac.dto.UserLikeBoardDTO;
import site.sac.dto.UserLikePostLikeDTO;

import java.util.List;

public interface UserLikePostMapper {
    public void insert(UserLikePostLikeDTO userLikePostLikeDTO);

    public void delete(UserLikePostLikeDTO userLikePostLikeDTO);

    public int countByPostId(long post_id);

    public List<Integer> getAllByUserId(long user_id);
}
