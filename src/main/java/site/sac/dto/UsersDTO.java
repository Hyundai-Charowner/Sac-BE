package site.sac.dto;

import lombok.Data;

@Data
public class UsersDTO {
    private Long user_id;
    private String user_name;
    private String user_image;
    private String user_email;
}