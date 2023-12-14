package site.sac.service;

import site.sac.dto.UserLikeBoardDTO;

import java.util.Map;

public interface UserLikeBoardService {

    void insert(UserLikeBoardDTO userLikeBoardDTO, long userId);
    void delete(UserLikeBoardDTO userLikeBoardDTO, long userId);
    Map<String,Object> getAllByUserId(long userId);
}
