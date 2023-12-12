package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.mapper.UserLikeBoardMapper;

import java.util.List;

@Slf4j
@Service
public class UserLikeBoardServiceImpl implements UserLikeBoardService{
    @Autowired
    private UserLikeBoardMapper userLikeBoardMapper;

    @Override
    public void insert(UserLikeBoardDTO userLikeBoardDTO) {
        userLikeBoardMapper.insert(userLikeBoardDTO);
    }

    @Override
    public void delete(UserLikeBoardDTO userLikeBoardDTO) {
        userLikeBoardMapper.delete(userLikeBoardDTO);
    }

    @Override
    public List<String> getAllByUserId(long userId) {
        List<String> list = userLikeBoardMapper.getAllByUserId(userId);
        return list;
    }
}
