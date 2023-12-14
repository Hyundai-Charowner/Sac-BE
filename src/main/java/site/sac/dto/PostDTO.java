package site.sac.dto;

import lombok.Data;

@Data
public class PostDTO {
    private long post_id;
    private long user_id;
    private long board_id;
    private String post_head;
    private String post_content;
    private String created_date;
    private String updated_date;
    private long post_count;
    private long post_likes;
}
