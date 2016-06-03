package com.blog.exception;

public class BaseBlogException extends RuntimeException {
	private static final long serialVersionUID = 6007087960294312520L;
	
	public BaseBlogException() {
		super();
	}
	
	public BaseBlogException(String message) {
        super(message);
    }

    public BaseBlogException(Throwable cause) {
        super(cause);
    }

    public BaseBlogException(String message, Throwable cause) {
        super(message, cause);
    }

}
