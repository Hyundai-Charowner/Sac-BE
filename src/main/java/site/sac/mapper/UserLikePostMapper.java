package site.sac.mapper;

import site.sac.dto.UserLikePostDTO;

import java.util.List;

public interface UserLikePostMapper {
    public void insert(UserLikePostDTO userLikePostDTO);

    public void delete(UserLikePostDTO userLikePostDTO);

    public int countByPostId(long post_id);

    public List<Long> getAllByUserId(long user_id);
}
