package org.tukorea.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CrudLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(CrudLogAspect.class);
	
	@AfterReturning(pointcut = "execution(* org.tukorea.board.service.BoardServiceImpl.* (..))")
	public void crudLog(JoinPoint jp) {
			
		Signature sig=jp.getSignature();
		String methodName=sig.getName();
		String className=jp.getTarget().getClass().getName();
		logger.info("CRUD 메소드 실행 함수: {}.{}",className,methodName);
		
	}
}
