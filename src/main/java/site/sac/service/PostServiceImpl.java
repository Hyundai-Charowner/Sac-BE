package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.sac.dto.PostDTO;
import site.sac.mapper.PostMapper;

@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Transactional
    @Override
    public void register(PostDTO postDTO, long userId) {
        postDTO.setUser_id(userId);
        postMapper.insert(postDTO);
    }

    @Override
    public void postEdit(PostDTO postDTO, long userId) {
        PostDTO post = postMapper.read(postDTO.getPost_id());
        if (post.getUser_id() == userId) {
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
        if (post.getUser_id() == userId) {
            postMapper.delete(postDTO.getPost_id());
        } else {
            throw new NullPointerException();
        }
    }
}
