package site.sac.mapper;

import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;

import java.util.List;

public interface PostResponseMapper {
    List<PostResponseDTO> getPostAll(Criteria cri);

    PostResponseDTO getPostDetail(long post_id);

    List<PostResponseDTO> getPostAllByBoardId(long board_id);

    List<PostResponseDTO> getPostAllByUserId(long page_num, long user_id);
}
