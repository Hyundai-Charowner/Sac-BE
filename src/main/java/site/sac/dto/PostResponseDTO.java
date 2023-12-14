package site.sac.dto;

import lombok.Data;

@Data
public class PostResponseDTO {
    private long post_id;
    private String board_category;
    private String post_head;
    private String post_content;
    private String created_date;
    private String updated_date;
    private long post_count;
    private long post_likes;

    private String user_name;
    private String user_image;

    private long reply_count;
}
