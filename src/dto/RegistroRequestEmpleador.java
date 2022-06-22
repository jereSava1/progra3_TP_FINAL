package dto;

import types.TipoUsuario;

public class RegistroRequestEmpleador extends RegistroRequest {
	public String TipoPersona;
	public String Rubro;
	
	public RegistroRequestEmpleador(String nombreUsuario, String contrasena, String TipoPersona, String Rubro, String nombre) {
		super(nombreUsuario, contrasena, TipoUsuario.EMPLEADOR);
		this.TipoPersona = TipoPersona;
		this.Rubro = Rubro;
		this.setNombre(nombre);
	}

	public String getTipoPersona() {
		return TipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		TipoPersona = tipoPersona;
	}

	public String getRubro() {
		return Rubro;
	}

	public void setRubro(String rubro) {
		Rubro = rubro;
	}
	
	
}
