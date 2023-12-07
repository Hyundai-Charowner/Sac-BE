package site.sac.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    public long post_id;
    public long user_id;
    public long board_id;
    public String post_head;
    public String post_content;
    public Date created_date;
    public Date updated_date;
    public long post_count;
    public long post_likes;
}
