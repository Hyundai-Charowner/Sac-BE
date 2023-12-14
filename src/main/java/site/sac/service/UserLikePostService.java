package site.sac.service;

import site.sac.dto.UserLikePostDTO;

import java.util.Map;

public interface UserLikePostService {
    public void postLike(UserLikePostDTO userLikePostDTO, long userId);

    public void postDelete(UserLikePostDTO userLikePostDTO, long userId);

    public int countLikeByPostId(long postId);

    public Map<String,Object> getPostsByUserId(long userId);

}
