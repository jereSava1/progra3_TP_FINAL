package model.usuario;

import lombok.Getter;

@Getter
public class RankingEmpleado implements Comparable {
  Empleado empleado;
  Float puntaje;



  public RankingEmpleado(Empleado empleado, float puntaje){
    this.empleado = empleado;
    this.puntaje = puntaje;
  }

  @Override
  public int compareTo(Object o) {
    RankingEmpleado item = (RankingEmpleado) o;

    return this.getPuntaje().compareTo(item.getPuntaje());
  }
}
