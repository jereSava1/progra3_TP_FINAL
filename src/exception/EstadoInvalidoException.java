package exception;

/**
 * Excepcion cuando se quiere cancelar un ticket ya finalizado
 */
public class EstadoInvalidoException extends Exception {
	

	public EstadoInvalidoException(String message) {
		super(message);
	}

}
