package com.blog.exception;

public class AuthenticationException extends BaseBlogException {
	private static final long serialVersionUID = -2046393456026802274L;
	
	public AuthenticationException() {
		super();
	}
	
	public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

}
