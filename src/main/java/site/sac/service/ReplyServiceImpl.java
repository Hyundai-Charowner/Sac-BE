package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.ReplyDTO;
import site.sac.mapper.ReplyMapper;

import java.util.List;
@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public void replyInsert(ReplyDTO replyDTO) {
        replyMapper.insert(replyDTO);
    }

    @Override
    public void replyDelete(long replyId) {
        replyMapper.delete(replyId);
    }

    @Override
    public ReplyDTO replyRead(long replyId) {

        return replyMapper.read(replyId);
    }

    @Override
    public List<ReplyDTO> getAllReplyByPostId(long postId) {
        return replyMapper.getAllReplyByPostId(postId);
    }

    @Override
    public List<ReplyDTO> getAllReplyByUserId(long userId) {
        return replyMapper.getAllReplyByUserId(userId);
    }

    @Override
    public void replyUpdate(ReplyDTO replyDTO) {

        replyMapper.update(replyDTO);

    }
}
