
package us.absencemanager.exceptions;

@SuppressWarnings("serial")
public class AlreadyExistsException extends Exception {

	public AlreadyExistsException() {
		super();
	}

	public AlreadyExistsException(String message) {
		super(message);
	}

}
