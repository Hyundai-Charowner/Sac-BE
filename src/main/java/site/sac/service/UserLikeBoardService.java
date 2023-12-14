package site.sac.service;

import site.sac.dto.UserLikeBoardDTO;

import java.util.Map;

public interface UserLikeBoardService {

    void insert(UserLikeBoardDTO userLikeBoardDTO);
    void delete(UserLikeBoardDTO userLikeBoardDTO);
    Map<String,Object> getAllByUserId(String userIdString);
}
