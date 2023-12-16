package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.UserLikePostDTO;
import site.sac.mapper.PostMapper;
import site.sac.mapper.UserLikePostMapper;


@Slf4j
@Service
public class UserLikePostServiceImpl implements UserLikePostService{
    @Autowired
    private UserLikePostMapper userLikePostMapper;
    @Autowired
    private PostMapper postMapper;

    @Override
    public void postLike(UserLikePostDTO userLikePostDTO, long userId) {
        userLikePostDTO.setUser_id(userId);
        postMapper.likeUp(userLikePostDTO.getPost_id());
        userLikePostMapper.insert(userLikePostDTO);
    }

    @Override
    public void postDelete(UserLikePostDTO userLikePostDTO, long userId) {
        userLikePostDTO.setUser_id(userId);
        postMapper.likeDown(userLikePostDTO.getPost_id());
        userLikePostMapper.delete(userLikePostDTO);
    }
}
