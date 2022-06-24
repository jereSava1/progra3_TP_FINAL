package dto;

import exception.ConstructorInvalidoException;

public class TicketDeEmpleadorRequest extends TicketDeEmpleadoRequest {

	private int cantEmpleados;
	
	public TicketDeEmpleadorRequest(String locacion, String pesoLocacion, String estudio, String pesoEstudio,
			String experiencia, String pesoExperiencia, String horario, String pesoHorario, String rangoEtario,
			String pesoRangoEtario, String remuneracion, String pesoRemuneracion, String tipoDePuesto,
			String pesoTipoDePuesto,int cantEmpleados) throws ConstructorInvalidoException {
		super(locacion, pesoLocacion, estudio, pesoEstudio, experiencia, pesoExperiencia, horario, pesoHorario, rangoEtario,
				pesoRangoEtario, remuneracion, pesoRemuneracion, tipoDePuesto, pesoTipoDePuesto);
		// TODO Auto-generated constructor stub
		this.cantEmpleados=cantEmpleados;
	}

	public int getCantEmpleados() {
		return cantEmpleados;
	}

	public void setCantEmpleados(int cantEmpleados) {
		this.cantEmpleados = cantEmpleados;
	}
	
	

}
