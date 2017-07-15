package com.adp.exceptions;

/**
 * Exception generique.
 * @author Talan Tunisie : mehdi benamor
 * @version 1.0 <br>
 *          Date de creation : 15 janv. 10 <br>
 *          Date de modification : 15 janv. 10 <br>
 */
public class ADPException extends Exception {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe ORAException
	 */
	public ADPException() {
	}

	/**
	 * Exception avec message
	 * @param message
	 *            message
	 */
	public ADPException(String message) {
		super(message);
	}

	/**
	 * Exception avec message et cause
	 * @param message
	 *            message
	 * @param cause
	 *            Cause
	 */
	public ADPException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Exception avec cause
	 * @param cause
	 *            Cause
	 */
	public ADPException(Throwable cause) {
		super(cause);
	}
}
