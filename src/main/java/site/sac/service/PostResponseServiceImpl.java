package site.sac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;
import site.sac.mapper.PostResponseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostResponseServiceImpl implements PostResponseService{
    @Autowired
    private PostResponseMapper postResponseMapper;
    @Override
    public Map<String,Object> getPagingPost(long pageNum) {
        Criteria cri = new Criteria();
        cri.setPageNum(pageNum);
        List<PostResponseDTO> posts = postResponseMapper.getPostAll(cri).stream().map((post) -> {
            post.setCreated_date(post.getCreated_date().substring(0, 16));
            return post;
        }).collect(Collectors.toList());;

        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }
}
