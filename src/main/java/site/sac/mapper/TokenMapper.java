package site.sac.mapper;

import site.sac.dto.TokenDTO;

public interface TokenMapper {
    public void insert(TokenDTO token);
    public TokenDTO select(String token);
}
