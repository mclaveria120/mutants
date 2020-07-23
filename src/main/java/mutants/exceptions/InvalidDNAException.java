package mutants.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.*;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "Invalid DNA")
public class InvalidDNAException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidDNAException() {
	
	}

	public InvalidDNAException(String message) {
	        super(message);
	}
}
