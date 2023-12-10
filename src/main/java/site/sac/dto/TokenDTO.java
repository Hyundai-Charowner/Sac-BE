package site.sac.dto;

import lombok.Data;

@Data
public class TokenDTO {
    private Long auth_id;
    private Long user_id;
    private String token;
}
