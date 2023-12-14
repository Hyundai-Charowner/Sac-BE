package site.sac.dto;

import lombok.Data;

@Data
public class ReplyDTO {
    private long reply_id;
    private long post_id;
    private long user_id;
    private String reply_content;
}
