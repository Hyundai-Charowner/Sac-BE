package site.sac.mapper;

import site.sac.dto.UsersDTO;

public interface UsersMapper {
    void insert(UsersDTO users);
    Long select(String user_email);
}