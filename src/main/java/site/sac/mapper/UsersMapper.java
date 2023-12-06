package site.sac.mapper;

import site.sac.user.Users;

public interface UsersMapper {

    public void insert(Users users);

    public void login(Users users);
    public int delete(Users users);

}
