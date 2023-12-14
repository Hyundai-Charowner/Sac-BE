package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sac.dto.PostDTO;
import site.sac.dto.PostResponseDTO;
import site.sac.mapper.PostMapper;
import site.sac.mapper.PostResponseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostResponseMapper postResponseMapper;

    @Transactional
    @Override
    public void register(PostDTO postDTO, long userId) {
        postDTO.setUser_id(userId);
        postMapper.insert(postDTO);
    }

    @Override
    public Map<String,Object> getAllPost() {
        List<PostDTO> allPost = postMapper.getAllPost();
        Map<String,Object> result = new HashMap<>();
        result.put("posts", allPost);
        return result;
    }

    @Override
    public Map<String,Object> getPostsByBoardId(Long boardId) {
        List<PostDTO> postsByBoardId = postMapper.getAllPostsByBoardId(boardId);

        if (postsByBoardId == null){
            throw new NullPointerException();
        }

        Map<String,Object> result = new HashMap<>();
        result.put("posts", postsByBoardId);
        result.put("count", postsByBoardId.size());

        return result;
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
    public Map<String, Object> getAllPostByUserLikeBoard(long userId) {
        List<PostResponseDTO> posts = postResponseMapper.getPostByBoardLike(userId);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public void postEdit(PostDTO postDTO, long userId) {
        PostDTO post = postMapper.read(postDTO.getPost_id());

        log.info("--------------------");
        log.info("" + userId);
        log.info("" + post.getUser_id());
        log.info("--------------------");

        if(post.getUser_id() == userId){
            post.setPost_head(postDTO.getPost_head());
            post.setPost_content(postDTO.getPost_content());
            postMapper.update(postDTO);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void delete(PostDTO postDTO, long userId) {
        PostDTO post = postMapper.read(postDTO.getPost_id());

        log.info("--------------------");
        log.info("" + userId);
        log.info("" + post.getUser_id());
        log.info("--------------------");

        if(post.getUser_id() == userId) {
            postMapper.delete(postDTO.getPost_id());
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<PostDTO> getPostsByLike(List<Long> likes) {
        return postMapper.getPostsByLike(likes);
    }
}
