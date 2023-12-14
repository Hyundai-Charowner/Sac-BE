package site.sac.service;

import site.sac.dto.ReplyDTO;

import java.util.List;
import java.util.Map;

public interface ReplyService {
    void replyInsert(ReplyDTO replyDTO);

    void replyDelete(ReplyDTO replyDTO,long replyId);

    ReplyDTO replyRead(long replyId);

    Map<String,Object> getAllReplyByPostId(long postId);

    Map<String, Object> getAllReplyByUserId(long postId);

    void replyUpdate(ReplyDTO replyDTO, long replyId);
}
