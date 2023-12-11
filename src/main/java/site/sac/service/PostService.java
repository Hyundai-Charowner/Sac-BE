package site.sac.service;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.http.ResponseEntity;
import site.sac.dto.PostDTO;

import java.util.List;

public interface PostService {

    public void register(PostDTO postDTO);
    public List<PostDTO> getAllPost();

    public PostDTO getPostDetail(Long postId);

    public List<PostDTO> getPostsByBoardId(Long boardId);


}
