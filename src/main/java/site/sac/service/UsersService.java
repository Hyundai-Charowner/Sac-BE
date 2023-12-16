package site.sac.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import site.sac.dto.GoogleOAuthDTO;
import site.sac.dto.UsersDTO;


public interface UsersService {
    String register(GoogleOAuthDTO googleOAuthDTO) throws JsonProcessingException;

    boolean isExistToken(String token);

    long findUserIdByToken(String token);
    UsersDTO userInfo(long user_id);
}