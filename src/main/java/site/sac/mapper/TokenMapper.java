package site.sac.mapper;

import site.sac.dto.TokenDTO;

public interface TokenMapper {
    void insert(TokenDTO token);
    TokenDTO select(String token);
}
