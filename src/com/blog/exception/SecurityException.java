package com.blog.exception;

public class SecurityException extends BaseBlogException {
	private static final long serialVersionUID = 666428491152679388L;
	
	public SecurityException() {
		super();
	}
	
	public SecurityException(String message) {
        super(message);
    }

    public SecurityException(Throwable cause) {
        super(cause);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

}
