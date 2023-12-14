package site.sac.mapper;

import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;

import java.util.List;
import java.util.Map;

public interface PostResponseMapper {
    List<PostResponseDTO> getPostAll(Criteria cri);

    Map<String,Object> getPostDetail(long post_id);
}
