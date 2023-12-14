package site.sac.service;

import site.sac.dto.UserLikePostDTO;

import java.util.List;
import java.util.Map;

public interface UserLikePostService {
    public void postLike(UserLikePostDTO userLikePostDTO);

    public void postDelete(UserLikePostDTO userLikePostDTO);

    public int countLikeByPostId(long postId);

    public Map<String,Object> getPostsByUserId(long userId);

}
