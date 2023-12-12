package site.sac.dto;

import lombok.Data;

@Data
public class JWTPayloadDTO {
    private String iss;
    private String azp;
    private String aud;
    private String sub;
    private String email;
    private boolean email_verified;
    private long nbf;
    private String name;
    private String picture;
    private String given_name;
    private String locale;
    private String family_name;
    private long iat;
    private long exp;
    private String jti;
}