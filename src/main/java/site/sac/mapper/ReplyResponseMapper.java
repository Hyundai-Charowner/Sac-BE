package site.sac.mapper;

import site.sac.domain.Criteria;
import site.sac.dto.ReplyResponseDTO;

import java.util.List;

public interface ReplyResponseMapper {

    List<ReplyResponseDTO> getPostReply(Criteria cri, long post_id);

}
