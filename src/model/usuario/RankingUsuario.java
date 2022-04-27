package model.usuario;

import java.util.Date;

import lombok.Getter;

import model.Usuario;

@Getter
public class RankingUsuario implements Comparable<RankingUsuario> {
  private Date fechaDeGeneracion;
  private Usuario usuario;
  private Float puntaje;



  public RankingUsuario(Usuario usuario, float puntaje){
    this.usuario = usuario;
    this.puntaje = puntaje;
    this.fechaDeGeneracion=new Date();
  }

  @Override
  public int compareTo(RankingUsuario item) {
    return this.getPuntaje().compareTo(item.getPuntaje());
  }
}
