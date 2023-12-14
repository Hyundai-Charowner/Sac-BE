package site.sac.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private long post_id;
    private long user_id;
    private long board_id;
    private String post_head;
    private String post_content;
    private Date created_date;
    private Date updated_date;
    private long post_count;
    private long post_likes;
}
