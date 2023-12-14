package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;
import site.sac.mapper.PostResponseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
@Transactional
public class PostResponseServiceImpl implements PostResponseService{
    @Autowired
    private PostResponseMapper postResponseMapper;
    @Override
    public Map<String,Object> getPagingPost(long pageNum) {
        Criteria cri = new Criteria();
        cri.setPageNum(pageNum);
        List<PostResponseDTO> posts = postResponseMapper.getPostAll(cri);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public PostResponseDTO getDetail(long postId) {
        PostResponseDTO dto = postResponseMapper.getPostDetail(postId);

        return dto;
    }

    @Override
    public Map<String, Object> getPagingPostByBoardId(long boardId) {
        log.info("보드아이디    " + boardId);
        List<PostResponseDTO> posts = postResponseMapper.getPostAllByBoardId(boardId);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public Map<String, Object> getPagingPostByuserId(long userId) {
        List<PostResponseDTO> posts = postResponseMapper.getPostAllByBoardId(userId);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }
}
