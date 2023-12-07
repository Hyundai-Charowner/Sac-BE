package site.sac.mapper;

import site.sac.dto.LikeDTO;

public interface LikeMapper {
    public void insert(LikeDTO likeDTO);

    public void delete(LikeDTO likeDTO);

    public int countByPostId(long post_id);
}
