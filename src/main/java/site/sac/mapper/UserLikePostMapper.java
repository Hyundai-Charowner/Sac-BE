package site.sac.mapper;

import site.sac.dto.UserLikePostDTO;

import java.util.List;

public interface UserLikePostMapper {
    void insert(UserLikePostDTO userLikePostDTO);

    void delete(UserLikePostDTO userLikePostDTO);

    int countByPostId(long post_id);

    List<Long> getAllByUserId(long user_id);
}
