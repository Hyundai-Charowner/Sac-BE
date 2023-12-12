package site.sac.mapper;

import site.sac.dto.PostDTO;
import site.sac.dto.ReplyDTO;

import java.util.List;

public interface ReplyMapper {
    public void insert(ReplyDTO replyDTO);
    public ReplyDTO read(long reply_id);
    public List<ReplyDTO> getAllReplyByPostId(long post_id);

    public List<ReplyDTO> getAllReplyByUserId(long user_id);

    public void delete(long reply_Id);

    public void update(ReplyDTO replyDTO);
}