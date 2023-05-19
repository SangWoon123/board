package org.tukorea.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loginAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(loginAspect.class);
	
	@AfterReturning(pointcut = "execution(* org.tukorea.board.service.UserService.authenticateUser(..))", returning = "result")
	public void loginSuccess(JoinPoint joinPoint, boolean result) {
		Object[] args = joinPoint.getArgs();
        String username = (String) args[0];
        String password = (String) args[1];
        
        if (result) {
            logger.info("Successful login - Username: {}", username);
        } else {
            logger.info("Login failed - Username: {}", username);
        }
	}

}
