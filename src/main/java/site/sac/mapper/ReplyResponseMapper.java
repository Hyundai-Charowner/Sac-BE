package site.sac.mapper;

import site.sac.dto.ReplyResponseDTO;

import java.util.List;

public interface ReplyResponseMapper {

    List<ReplyResponseDTO> getAllReply(long post_id);
}
