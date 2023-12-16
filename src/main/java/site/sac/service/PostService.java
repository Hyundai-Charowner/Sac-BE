package site.sac.service;

import site.sac.dto.PostDTO;

public interface PostService {

    void register(PostDTO postDTO, long userId);

    void postEdit(PostDTO postDTO, long postId);

    void delete(PostDTO postDTO, long postId);

}
