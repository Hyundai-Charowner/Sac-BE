package site.sac.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import site.sac.dto.GoogleOAuthDTO;


public interface UsersService {
    public String register(GoogleOAuthDTO googleOAuthDTO) throws JsonProcessingException;

    public boolean isExistToken(String token);

    public long findUserIdByToken(String token);
}