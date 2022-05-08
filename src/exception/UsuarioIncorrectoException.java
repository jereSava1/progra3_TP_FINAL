package exception;

/**
 * Excepcion por validacion erronea del Usuario en el login
 */
public class UsuarioIncorrectoException extends Exception {
	private String dato;

	public UsuarioIncorrectoException(String nombreUsuario,String message) {
		super(message);
		this.dato = nombreUsuario;
	}

	public String getDato() {
		return dato;
	}

}
