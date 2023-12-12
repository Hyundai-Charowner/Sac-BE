package site.sac.service;

import site.sac.dto.GoogleOAuthDTO;


public interface UsersService {
    public String register(GoogleOAuthDTO googleOAuthDTO);

    public boolean isExistToken(String token);

    public long findUserIdByToken(String token);
}