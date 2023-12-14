package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.UserLikeBoardDTO;
import site.sac.mapper.UserLikeBoardMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserLikeBoardServiceImpl implements UserLikeBoardService{
    @Autowired
    private UserLikeBoardMapper userLikeBoardMapper;

    @Override
    public void insert(UserLikeBoardDTO userLikeBoardDTO, long userId) {
        userLikeBoardDTO.setUser_id(userId);
        userLikeBoardMapper.insert(userLikeBoardDTO);
    }

    @Override
    public void delete(UserLikeBoardDTO userLikeBoardDTO, long userId) {
        userLikeBoardDTO.setUser_id(userId);
        userLikeBoardMapper.delete(userLikeBoardDTO);
    }

    @Override
    public Map<String,Object> getAllByUserId(long userId) {

        List<String> list = userLikeBoardMapper.getAllByUserId(userId);
        Map<String,Object> result = new HashMap<>();
        result.put("likeList", list);
        result.put("count", list.size());
        return result;
    }
}
