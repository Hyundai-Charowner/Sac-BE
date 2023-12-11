package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import site.sac.dto.PostDTO;
import site.sac.mapper.PostMapper;

import java.util.List;

@Service
@Slf4j
public class PostServiceImpl implements PostService{
    @Autowired
    private PostMapper postMapper;

    @Transactional
    @Override
    public void register(PostDTO postDTO) {
        log.info("Post : " + postDTO.toString());
        postMapper.insert(postDTO);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<PostDTO> allPost = postMapper.getAllPost();
        allPost.forEach(post->log.info("post : " + post.toString()));

        return allPost;
    }

    @Override
    public PostDTO getPostDetail(Long postId) {
        PostDTO post = postMapper.read(postId);

        log.info(post.toString());
        return post;
    }

    @Override
    public List<PostDTO> getPostsByBoardId(Long boardId) {
        List<PostDTO> postsByBoardId = postMapper.getAllPostsByBoardId(boardId);
        postsByBoardId.forEach(post->log.info("post : " + post.toString()));

        return postsByBoardId;
    }

}
