package com.blog.exception;

public class DaoException extends BaseBlogException {
	private static final long serialVersionUID = -1439168291412516161L;

	public DaoException() {
		super();
	}
	
	public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
	
}
