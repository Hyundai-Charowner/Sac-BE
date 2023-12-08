package site.sac.dto;

import lombok.Data;

@Data
public class UserLikeBoardDTO {
    private long board_fav_id;
    private long user_id;
    private long board_id;
}
