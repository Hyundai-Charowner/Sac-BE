package site.sac.service;

import site.sac.dto.PostDTO;

import java.util.Map;

public interface PostService {
    void register(PostDTO postDTO, long userId);
    Map<String,Object> getAllPostByUserId(Long userId);
    void postEdit(PostDTO postDTO, long postId);
    void delete(PostDTO postDTO, long postId);
}
