package site.sac.user;

import lombok.Data;

@Data
public class Users {
    private Long user_id;
    private String user_name;
    private String user_image;
    private String user_email;
}
