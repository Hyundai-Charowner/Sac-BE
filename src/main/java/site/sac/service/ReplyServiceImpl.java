package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.ReplyDTO;
import site.sac.dto.ReplyResponseDTO;
import site.sac.mapper.ReplyMapper;
import site.sac.mapper.ReplyResponseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private ReplyResponseMapper replyResponseMapper;

    @Override
    public void replyInsert(ReplyDTO replyDTO, long userId) {
        replyDTO.setUser_id(userId);
        replyMapper.insert(replyDTO);
    }

    @Override
    public ReplyDTO replyRead(long replyId) {
        return replyMapper.read(replyId);
    }

    @Override
    public Map<String, Object> getAllReplyByPostId(long postId) {
        log.info("----------------");
        log.info("" + postId);
        log.info("----------------");

        List<ReplyResponseDTO> replies = replyResponseMapper.getAllReply(postId);


        log.info("----------------");
        log.info("불러옴");
        log.info("----------------");
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
    public void replyUpdate(ReplyDTO replyDTO, long userId) {
        if (replyMapper.read(replyDTO.getReply_id()).getUser_id() ==userId) {
            replyMapper.update(replyDTO);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void replyDelete(ReplyDTO replyDTO, long userId) {
        if (replyMapper.read(replyDTO.getReply_id()).getUser_id() == userId) {
            replyMapper.delete(replyDTO.getReply_id());
        } else {
            throw new NullPointerException();
        }
    }
}
