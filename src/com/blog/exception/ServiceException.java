package com.blog.exception;

public class ServiceException extends BaseBlogException {
	private static final long serialVersionUID = 8515968689320464563L;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
