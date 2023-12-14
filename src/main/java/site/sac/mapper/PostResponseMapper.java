package site.sac.mapper;

import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;

import java.util.List;

public interface PostResponseMapper {
    List<PostResponseDTO> getPostAll(Criteria cri); //유저 아이디 받고 likepost테이블에서 where user_id

    PostResponseDTO getPostDetail(long post_id);

    List<PostResponseDTO> getPostByBoardLike(long user_id);


    List<PostResponseDTO> getPostByPostLike(long user_id);

    List<PostResponseDTO> getPostByBoard(long board_id);
}
