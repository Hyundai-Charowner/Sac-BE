package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.UserLikePostDTO;
import site.sac.mapper.UserLikePostMapper;

import java.util.List;


@Slf4j
@Service
public class UserLikePostServiceImpl implements UserLikePostService{
    @Autowired
    private UserLikePostMapper userLikePostMapper;

    @Override
    public void postLike(UserLikePostDTO userLikePostDTO) {
        userLikePostMapper.insert(userLikePostDTO);
    }

    @Override
    public void postDelete(UserLikePostDTO userLikePostDTO) {
        userLikePostMapper.delete(userLikePostDTO);
    }

    @Override
    public int countLikeByPostId(long postId) {
        return userLikePostMapper.countByPostId(postId);
    }

    @Override
    public List<Long> getPostsByUserId(long userId) {
        return userLikePostMapper.getAllByUserId(userId);
    }
}
