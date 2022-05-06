package exception;

/**
 * Excepcion por ingreso de lista vacia a un cierto metodo
 */
public class ListaVaciaException extends Exception {
  private String dato;

  public ListaVaciaException(String message){
    super(message);
  }
}
