package site.sac.service;

import site.sac.dto.UserLikeBoardDTO;

import java.util.List;

public interface UserLikeBoardService {

    public void insert(UserLikeBoardDTO userLikeBoardDTO);

    public void delete(UserLikeBoardDTO userLikeBoardDTO);

    public List<String> getAllByUserId(long userId);
}
