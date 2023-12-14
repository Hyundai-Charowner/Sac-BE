package site.sac.mapper;

import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;

import java.util.List;

public interface PostResponseMapper {
    List<PostResponseDTO> getPostAll(Criteria cri);
}
