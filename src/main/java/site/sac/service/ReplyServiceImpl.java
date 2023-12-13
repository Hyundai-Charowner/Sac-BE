package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.ReplyDTO;
import site.sac.mapper.ReplyMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void replyInsert(ReplyDTO replyDTO) {
        replyMapper.insert(replyDTO);
    }

    @Override
    public void replyDelete(ReplyDTO replyDTO, long replyId) {
        if (replyMapper.read(replyId).getUser_id() == replyDTO.getUser_id()) {
            replyMapper.delete(replyId);
        } else throw new NullPointerException();
    }

    @Override
    public ReplyDTO replyRead(long replyId) {

        return replyMapper.read(replyId);
    }

    @Override
    public Map<String, Object> getAllReplyByPostId(long postId) {
        List<ReplyDTO> replies = replyMapper.getAllReplyByPostId(postId);
        Map<String, Object> result = new HashMap<>();
        result.put("replies", replies);
        return result;
    }

    @Override
    public Map<String, Object> getAllReplyByUserId(long userId) {
        List<ReplyDTO> replies = replyMapper.getAllReplyByUserId(userId);
        Map<String, Object> result = new HashMap<>();
        result.put("replies", replies);
        result.put("count", replies.size());

        return result;
    }

    @Override
    public void replyUpdate(ReplyDTO replyDTO, long replyId) {
        if (replyMapper.read(replyId).getUser_id() == replyDTO.getUser_id()) {
            replyMapper.update(replyDTO);
        } else throw new NullPointerException();


    }
}
