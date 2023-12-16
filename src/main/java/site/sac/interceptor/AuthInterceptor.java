package site.sac.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import site.sac.service.UsersService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler){
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }

        String token = request.getHeader("accessToken");
        if (token == null || !usersService.isExistToken(token)){
            response.setStatus(401);
            return false;
        }

        long userId = usersService.findUserIdByToken(token);
        request.setAttribute("userId", userId);

        return true;
    }
}
