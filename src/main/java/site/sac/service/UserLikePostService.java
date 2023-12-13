package site.sac.service;

import site.sac.dto.UserLikePostDTO;

import java.util.List;

public interface UserLikePostService {
    public void postLike(UserLikePostDTO userLikePostDTO);

    public void postDelete(UserLikePostDTO userLikePostDTO);

    public int countLikeByPostId(long postId);

    public List<Long> getPostsByUserId(long userId);

}
