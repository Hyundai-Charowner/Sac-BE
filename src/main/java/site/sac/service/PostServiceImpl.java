package site.sac.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public void register(PostDTO postDTO) {
        postMapper.insert(postDTO);
    }

    @Override
    public Map<String,Object>  getAllPost() {

        List<PostDTO> allPost = postMapper.getAllPost();
        Map<String,Object> result = new HashMap<>();
        result.put("posts", allPost);
        return result;

    }


    @Override
    public PostDTO getPostDetail(Long postId) {
        PostDTO post = postMapper.read(postId);
        return post;
    }

    @Override
    public Map<String,Object> getPostsByBoardId(Long boardId){
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
        List<String> userLikeBoard = userLikeBoardMapper.getAllByUserId(userId);
        if (userLikeBoard == null){
            throw new NullPointerException();
        }
        List<PostDTO> posts = postMapper.getAllPostByUserLikeBoard(userLikeBoard);
        Map<String,Object> result = new HashMap<>();
        result.put("posts", posts);
        result.put("count", posts.size());
        return result;

    }

    @Override
    public List<PostDTO> getAllPostByUserLikeBoard(List<String> userLikeBoards) {
        List<PostDTO> postsByUserLikeBoard = postMapper.getAllPostByUserLikeBoard(userLikeBoards);
        postsByUserLikeBoard.forEach(post->log.info("post : " + post.toString()));
        return postsByUserLikeBoard;
    }

    @Override
    public void postEdit(PostDTO postDTO) {
        if(postMapper.read(postDTO.getPost_id()).getUser_id()== postDTO.getUser_id()){
            postMapper.update(postDTO);

        } else throw new NullPointerException();

    }

    @Override
    public void delete(PostDTO postDTO, long postId) {
        if(postMapper.read(postId).getUser_id()== postDTO.getUser_id()){
            postMapper.delete(postId);

        } else throw new NullPointerException();
    }

    @Override
    public List<PostDTO> getPostsByLike(List<Long> likes) {

        return postMapper.getPostsByLike(likes);
    }

}
