package site.sac.mapper;

import site.sac.dto.ReplyDTO;

import java.util.List;

public interface ReplyMapper {
    public void insertReply(ReplyDTO replyDTO);
    public ReplyDTO getReplyByReplyId(long reply_id);
    public List<ReplyDTO> getAllReplyByBoardId(long board_id);

    public List<ReplyDTO> getAllReplyByUserId(long user_id);
    public void updateReply(ReplyDTO replyDTO);
    public void deleteReply(long reply_Id);
}