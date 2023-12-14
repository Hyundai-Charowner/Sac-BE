package site.sac.service;

import site.sac.dto.PostResponseDTO;

import java.util.Map;

public interface PostResponseService {

    Map<String,Object> getPagingPost(long pageNum);

    PostResponseDTO getDetail(long postId);

    Map<String,Object> getPagingPostByBoardId(long boardId);

    Map<String,Object> getPagingPostByuserId(long userId);
}
