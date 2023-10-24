package model.exceptions;

public class WithdrawException extends RuntimeException {
	private static final long serialVersionUID = 1L; //Serialização da exceção, exigido pelo Java
	
	public WithdrawException (String errorMessage) {
		super(errorMessage);
	}
}
