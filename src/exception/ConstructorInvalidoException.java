package exception;

import lombok.Getter;

@Getter
public class ConstructorInvalidoException extends Exception {
  private String dato;

  public ConstructorInvalidoException(String dato){
    super("Constructor llamado con parámetros invalidos");
    this.dato = dato;
  }
}
