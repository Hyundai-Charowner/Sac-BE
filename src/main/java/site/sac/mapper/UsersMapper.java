package site.sac.mapper;

import site.sac.dto.UsersDTO;

public interface UsersMapper {
    public void insert(UsersDTO users);
    public Long select(String user_email);
}