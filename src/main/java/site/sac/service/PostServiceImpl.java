package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.dto.PostDTO;
import site.sac.mapper.PostMapper;
import site.sac.mapper.UserLikeBoardMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserLikeBoardMapper userLikeBoardMapper;

    @Override
    public void register(PostDTO postDTO, long userId) {
        postDTO.setUser_id(userId);
        postMapper.insert(postDTO);
    }

    @Override
    public Map<String,Object> getAllPostByUserId(Long userId){
        List<PostDTO> posts = postMapper.getPostsByUserId(userId);

        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        result.put("count", posts.size());
        return result;
    }

    @Override
    public void postEdit(PostDTO postDTO, long userId) {
        if(postMapper.read(postDTO.getPost_id()).getUser_id()== userId){
            postMapper.update(postDTO);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void delete(PostDTO postDTO, long userId) {
        if(postMapper.read(postDTO.getPost_id()).getUser_id() == userId){
            postMapper.delete(postDTO.getPost_id());
        } else {
            throw new NullPointerException();
        }
    }

}
