package dto;

import types.TipoUsuario;

public class RegistroRequestEmpleado extends RegistroRequest {
	private String nombre;
	private String apellido;
	private String telefono;
	private String nombreUsuario;
	private String contrasena;
	private String email;
	private String edad;
	
	
	public RegistroRequestEmpleado( String nombre,String apellido,String telefono,String nombreUsuario, String contrasena,String email,String edad) {
		super(nombreUsuario, contrasena,TipoUsuario.EMPLEADO);
	    this.telefono=telefono;
	    this.email=email;
	    String nombreCompleto=nombre + " "+this.apellido;
		this.nombre = nombreCompleto;
	    this.apellido=apellido;
	    this.edad=edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


	

	
	
}
