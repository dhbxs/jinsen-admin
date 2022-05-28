package top.dhbxs.jinsen.admin.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.dhbxs.jinsen.admin.entity.UserEntity;
import top.dhbxs.jinsen.admin.service.ex.ServiceException;
import top.dhbxs.jinsen.admin.service.ex.TokenErr;
import top.dhbxs.jinsen.admin.service.ex.UsernameNotFoundException;
import top.dhbxs.jinsen.admin.service.impl.UserServiceImpl;
import top.dhbxs.jinsen.admin.util.SpringContextUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 执行认证
        if (StrUtil.isBlank(token)) {
            throw new ServiceException("无token，请重新登录");
        }
        // 获取token中的user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException j) {
            throw new TokenErr("token 验证失败");
        }

        UserServiceImpl userService = SpringContextUtil.getBean(UserServiceImpl.class);
//        System.out.println("***************************************" + userService);
        UserEntity user = userService.getById(Integer.valueOf(userId));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在，请重新登录");
        }

        // 验证token 用户密码加签名验证token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token); // 验证token
        } catch (JWTVerificationException e){
            throw new ServiceException("token 验证失败");
        }
        return true;
    }
}
