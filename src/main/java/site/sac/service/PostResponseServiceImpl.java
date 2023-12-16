package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.domain.Criteria;
import site.sac.dto.PostResponseDTO;
import site.sac.dto.ReplyResponseDTO;
import site.sac.mapper.PostMapper;
import site.sac.mapper.PostResponseMapper;
import site.sac.mapper.ReplyResponseMapper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PostResponseServiceImpl implements PostResponseService{
    @Autowired
    private PostResponseMapper postResponseMapper;
    @Autowired
    private ReplyResponseMapper replyResponseMapper;

    @Autowired
    private PostMapper postMapper;
    @Override
    public Map<String,Object> getPagingPost(long pageNum) {
        Criteria cri = new Criteria();
        cri.setPageNum(pageNum);
        List<PostResponseDTO> posts = postResponseMapper.getPostAll(cri)
                .stream()
                .sorted(Comparator.comparing(PostResponseDTO::getCreated_date).reversed())
                .map((post) -> {
                    post.setCreated_date(post.getCreated_date().substring(0, 16));
                    post.setUpdated_date(post.getUpdated_date().substring(0, 16));
                    return post;
                })
                .collect(Collectors.toList());

        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public Map<String,Object> getDetail(long postId) {
        PostResponseDTO post = postResponseMapper.getPostDetail(postId);
        post.setCreated_date(post.getCreated_date().substring(0, 16));
        List<ReplyResponseDTO> replies = replyResponseMapper.getAllReply(postId)
                .stream()
                .sorted(Comparator.comparing(ReplyResponseDTO::getCreated_date).reversed())
                .map((reply) -> {
                    reply.setCreated_date(reply.getCreated_date().substring(0, 16));
                    return reply;
                })
                .collect(Collectors.toList());
        postMapper.countUp(postId);

        Map<String,Object> result = new HashMap<>();
        result.put("post", post);
        result.put("reply", replies);
        return result;
    }

    @Override
    public Map<String, Object> getPostsByBoardId(long boardId) {
        List<PostResponseDTO> postsByBoardId = postResponseMapper.getPostByBoard(boardId);

        if (postsByBoardId == null){
            throw new NullPointerException();
        }

        Map<String,Object> result = new HashMap<>();
        result.put("posts", postsByBoardId);

        return result;
    }

    @Override
    public Map<String, Object> getAllPostByUserId(long userId) {
        List<PostResponseDTO> posts = postResponseMapper.getPostByPostLike(userId);

        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public Map<String, Object> getAllPostByLikeBoard(long userId) {
        List<PostResponseDTO> posts = postResponseMapper.getPostByBoardLike(userId);

        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

    @Override
    public Map<String, Object> getResisterPost(long userId) {
        List<PostResponseDTO> posts = postResponseMapper.getResiterPost(userId);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        return result;
    }

}
