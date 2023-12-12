package site.sac.service;

import site.sac.dto.PostDTO;

import java.util.List;

public interface PostService {

    public void register(PostDTO postDTO);
    public List<PostDTO> getAllPost();

    public PostDTO getPostDetail(Long postId);

    public List<PostDTO> getPostsByBoardId(Long boardId);

    public List<PostDTO> getAllPostByUserLikeBoard(List<String> userLikeBoards);

    public PostDTO postEdit(PostDTO postDTO);

    public void delete(Long postId);

    public List<PostDTO> getPostsByLike(List<Long> likes);
}
