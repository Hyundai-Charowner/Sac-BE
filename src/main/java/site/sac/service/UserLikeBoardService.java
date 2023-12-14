package site.sac.service;

import site.sac.dto.UserLikeBoardDTO;

import java.util.List;
import java.util.Map;

public interface UserLikeBoardService {

    void insert(UserLikeBoardDTO userLikeBoardDTO);
    void delete(UserLikeBoardDTO userLikeBoardDTO);
    Map<String,Object> getAllByUserId(long userId);
}
