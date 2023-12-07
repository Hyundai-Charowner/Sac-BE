package site.sac.dto;

import lombok.Data;

@Data
public class LikeDTO {
    private long like_id;
    private long post_id;
    private long user_id;
}
