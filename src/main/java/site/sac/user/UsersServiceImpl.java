package site.sac.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.sac.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper mapper;

    @Override
    public void register(Users users) {
        System.out.println("서비스임플");
        mapper.insert(users);
    }

    @Override
    public void login(Users users) {
        //login 기능
    }

    @Override
    public boolean remove(Users users){
        try {
            mapper.delete(users);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
