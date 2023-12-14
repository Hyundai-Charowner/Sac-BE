package site.sac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;
import site.sac.mapper.PostResponseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
    public Map<String, Object> getPagingPostByBoardId(long pageNum, long boardId) {
        Criteria cri = new Criteria();
        cri.setPageNum(pageNum);
        List<PostResponseDTO> posts = postResponseMapper.getPostAllByBoardId(cri,boardId);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }
}
