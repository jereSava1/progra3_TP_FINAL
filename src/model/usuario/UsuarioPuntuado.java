package model.usuario;

import java.util.Date;

/**
 *
 */

public class UsuarioPuntuado implements Comparable<UsuarioPuntuado> {
	 private Date fechaDeGeneracion;
	 private Usuario usuario;
	 private Float puntaje;
	 private boolean seleccionado;
	 private boolean contratado;


  public UsuarioPuntuado(Usuario usuario, float puntaje){
    this.usuario = usuario;
    this.puntaje = puntaje;
    this.fechaDeGeneracion = new Date();
    this.seleccionado = false;
    this.contratado = false;
  }

  
  
  @Override
public String toString() {
	return "usuario=" + usuario + ", puntaje=" + puntaje;
}



@Override
  public int compareTo(UsuarioPuntuado item) {
    return this.getPuntaje().compareTo(item.getPuntaje());
  }

  //GETTERS Y SETTERS
public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public Float getPuntaje() {
	return puntaje;
}

public void setPuntaje(Float puntaje) {
	this.puntaje = puntaje;
}

public boolean isSeleccionado() {
	return seleccionado;
}

public void setSeleccionado(boolean seleccionado) {
	this.seleccionado = seleccionado;
}

public Date getFechaDeGeneracion() {
	return fechaDeGeneracion;
}

public boolean isContratado() {
	return contratado;
}



}
