package exception;

/**
 * Excepcion por validacion erronea de la contrasena en el login
 */
public class ContrasenaIncorrectaException extends Exception {
	

	public ContrasenaIncorrectaException(String message) {
		super(message);
	}

}
