package site.sac.service;

import java.util.Map;

public interface PostResponseService {

    Map<String,Object> getPagingPost(long pageNum);

    Map<String,Object> getDetail(long postId);

    Map<String,Object> getPostsByBoardId(long boardId);

    Map<String,Object> getAllPostByUserId(long userId);

    Map<String,Object> getAllPostByLikeBoard(long userId);

    Map<String,Object> getResisterPost(long userId);

}
