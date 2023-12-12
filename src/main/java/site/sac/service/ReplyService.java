package site.sac.service;

import site.sac.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    public void replyInsert(ReplyDTO replyDTO);

    public void replyDelete(long replyId);

    public ReplyDTO replyRead(long replyId);

    public List<ReplyDTO> getAllReplyByPostId(long postId);

    public List<ReplyDTO> getAllReplyByUserId(long postId);
}
