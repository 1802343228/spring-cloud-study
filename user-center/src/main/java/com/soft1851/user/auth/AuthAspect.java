package com.soft1851.user.auth;

import com.soft1851.user.util.JwtOperator;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author crq
 */
@Aspect
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthAspect {
    private final JwtOperator jwtOperator;

    @Around("@annotation(com.soft1851.user.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws  Throwable {
        checkToken();
        return point.proceed();
    }

    private void checkToken(){
        try {
            //从Header里面获取token
            HttpServletRequest request = getHttpServletRequest();
            String token  = request.getHeader("X-Token");
            Boolean isValid = jwtOperator.validateToken(token);
            if(!isValid) {
                throw new SecurityException("Token不合法");
            }
            //如果校验成功，就将用户的信息设置到request的attribute里面
            Claims claims = jwtOperator.getClaimsFromToken(token);
            request.setAttribute("id",claims.get("id"));
            request.setAttribute("wxNickname",claims.get("wxNickname"));
            request.setAttribute("role",claims.get("role"));
        }catch (Throwable throwable) {
            throw  new SecurityException("Token不合法");
        }
    }
    private HttpServletRequest getHttpServletRequest(){
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes =(ServletRequestAttributes) requestAttribute;
        assert attributes !=null;
        return attributes.getRequest();
    }
    @Around("@annotation(com.soft1851.user.auth.CheckAuthorization)")
    public Object checkAuthorization(ProceedingJoinPoint point)throws Throwable{
        try {
            //验证token
            this.checkToken();
            //验证用户角色
            HttpServletRequest request = getHttpServletRequest();
            String role = (String) request.getAttribute("role");

            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            CheckAuthorization authorization = method.getAnnotation(CheckAuthorization.class);

            String value = authorization.value();

            if(!Objects.equals(role,value)) {
                throw new SecurityException("用户无权访问");
            }
        }catch (Throwable throwable) {
            throw new SecurityException("用户无权访问",throwable);
        }
        return point.proceed();
    }
}
