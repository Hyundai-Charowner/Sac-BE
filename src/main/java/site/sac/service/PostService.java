package site.sac.service;

import site.sac.dto.PostDTO;

import java.util.List;
import java.util.Map;

public interface PostService {

    void register(PostDTO postDTO, long userId);
    Map<String,Object>  getAllPost();

    public PostDTO getPostDetail(Long postId);

    Map<String,Object> getPostsByBoardId(Long boardId) throws NullPointerException;

    Map<String,Object> getAllPostByUserId(Long userId);

    List<PostDTO> getAllPostByUserLikeBoard(List<String> userLikeBoards);
    void postEdit(PostDTO postDTO, long postId);


    void delete(PostDTO postDTO, long postId);

    List<PostDTO> getPostsByLike(List<Long> likes);



}
