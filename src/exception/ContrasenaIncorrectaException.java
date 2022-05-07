package exception;

/**
 * Excepcion por validacion erronea de la contrasena en el login
 */
public class ContrasenaIncorrectaException extends Exception {
	private String dato;

	public ContrasenaIncorrectaException(String message) {
		super(message);
	}

}
