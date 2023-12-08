package site.sac.mapper;

import site.sac.dto.PostDTO;
import site.sac.dto.UsersDTO;

import java.util.List;

public interface PostMapper {
    public void insert(PostDTO postDTO);

    public PostDTO read(long post_id);

    public void update(PostDTO postDTO);

    public void delete(long post_id);

    public int countUp(long post_id);

    public int likeUp(long post_id);

    public int likeDown(long post_id);

    public List<PostDTO> getAllPost();

    public List<PostDTO> getAllPostByUserLikeBoard(List<String> user_like_boards);
}
