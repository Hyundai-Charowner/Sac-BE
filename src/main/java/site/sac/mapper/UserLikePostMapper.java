package site.sac.mapper;

import site.sac.dto.PostResponseDTO;
import site.sac.dto.UserLikePostDTO;

import java.util.List;

public interface UserLikePostMapper {
    void insert(UserLikePostDTO userLikePostDTO);

    void delete(UserLikePostDTO userLikePostDTO);

    int countByPostId(long post_id);


    List<PostResponseDTO> getAllByUserId(long user_id);
}
