package net.themoviea.themovieapi_base.exceptions;

/**
 * An exception when the input is not a specific type of object.
 * @author Themoviea
 *
 */
public class InputNotAnObjectException extends Exception {
	private static final long serialVersionUID = -6630984535096311996L;
	
	public InputNotAnObjectException(String message) {
		super(message);
	}
}
