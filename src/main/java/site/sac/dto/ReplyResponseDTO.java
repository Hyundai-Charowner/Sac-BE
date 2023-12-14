package site.sac.dto;

import lombok.Data;

@Data
public class ReplyResponseDTO {
    private String reply_content;
    private String user_name;
    private String user_image;
}
