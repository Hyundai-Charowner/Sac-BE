package site.sac.mapper;

import site.sac.dto.PostDTO;

import java.util.List;

public interface PostMapper {
    void insert(PostDTO postDTO);

    PostDTO read(long post_id);

    void update(PostDTO postDTO);

    void delete(long post_id);

    int countUp(long post_id);

    int likeUp(long post_id);

    int likeDown(long post_id);

    List<PostDTO> getAllPost();

    List<PostDTO> getAllPostByUserLikeBoard(List<String> user_like_boards);

    List<PostDTO> getAllPostsByBoardId(Long board_id);

    List<PostDTO> getPostsByLike(List<Long> like_list);

    List<PostDTO> getPostsByUserId(long user_id);
}
