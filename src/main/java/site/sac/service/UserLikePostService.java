package site.sac.service;

import site.sac.dto.UserLikePostDTO;

public interface UserLikePostService {
    void postLike(UserLikePostDTO userLikePostDTO, long userId);

    void postDelete(UserLikePostDTO userLikePostDTO, long userId);


}
