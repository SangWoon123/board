package org.tukorea.board.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class loginLogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(loginLogAspect.class);
	
	@AfterReturning(pointcut = "execution(* org.tukorea.board.service.UserService.authenticateUser(..))", returning = "result")
	public void loginSuccess(JoinPoint joinPoint, boolean result) {
		Object[] args = joinPoint.getArgs();
        String username = (String) args[0];
        String password = (String) args[1];
        
        if (result) {
            logger.info("Successful login - Username: {}", username);
        } else {
        	String script = "alert('잘못된 접근입니다.아이디와 비밀번호를 확인해주세요.');";
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            request.setAttribute("alertScript", script);
            logger.info("Login failed - Username: {}", username);
        }
	}
	

}
