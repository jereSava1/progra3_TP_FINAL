package model.usuario;

import lombok.Getter;

@Getter
public class RankingEmpleado {
  Empleado empleado;
  int puntaje;

  public RankingEmpleado(Empleado empleado, int puntaje){
    this.empleado = empleado;
    this.puntaje = puntaje;
  }
}
