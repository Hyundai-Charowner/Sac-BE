package site.sac.service;

import site.sac.dto.ReplyDTO;

import java.util.Map;

public interface ReplyService {
    void replyInsert(ReplyDTO replyDTO, long userId);

    void replyDelete(ReplyDTO replyDTO,long userId);

    ReplyDTO replyRead(long replyId);

    Map<String,Object> getAllReplyByPostId(long postId);

    Map<String, Object> getAllReplyByUserId(long userId);

    void replyUpdate(ReplyDTO replyDTO, long replyId);
}
