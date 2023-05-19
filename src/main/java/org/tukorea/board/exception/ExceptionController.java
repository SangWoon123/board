package org.tukorea.board.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Component
@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(IllegalStateException.class)
    public String handleIllegalStateException(IllegalStateException ex) {
        return "exception/usernameerror";
    }
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String handelDataIntegrityViolationException(DataIntegrityViolationException ex) {
		return "exception/nicknameerror";
	}

}
