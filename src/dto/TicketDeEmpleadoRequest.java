package dto;

import exception.ConstructorInvalidoException;
import factory.CargaHorariaFactory;
import factory.EstudiosFactory;
import factory.ExperienciaFactory;
import factory.LocacionFactory;
import factory.PretensionSalarialFactory;
import factory.RangoEtarioFactory;
import factory.TipoDePuestoFactory;
import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class TicketDeEmpleadoRequest {

	private DatosDeEmpleo locacion;
	private PretensionSalarial remuneracion;
	private DatosDeEmpleo puesto;
	private DatosDeEmpleo rEtario;
	private DatosDeEmpleo experiencia;
	private DatosDeEmpleo estudios;
	private DatosDeEmpleo horario;
	
	public TicketDeEmpleadoRequest(String locacion, String pesoLocacion, String estudio, String pesoEstudio, String experiencia,
								String pesoExperiencia, String horario, String pesoHorario, String rangoEtario, String pesoRangoEtario,
								String remuneracion, String pesoRemuneracion ,	String tipoDePuesto, String pesoTipoDePuesto) throws ConstructorInvalidoException {
		
			this.locacion = LocacionFactory.getLocacion(locacion, Integer.parseInt(pesoLocacion));
			this.remuneracion = PretensionSalarialFactory.getPretensionSalarial(Integer.parseInt(pesoRemuneracion), Float.parseFloat(remuneracion));
			this.experiencia = ExperienciaFactory.getExperiencia(experiencia, Integer.parseInt(pesoExperiencia));
			this.estudios = EstudiosFactory.getEstudios(estudio, Integer.parseInt(pesoEstudio));
			this.horario = CargaHorariaFactory.getCargaHoraria(horario, Integer.parseInt(pesoHorario));
			this.rEtario = RangoEtarioFactory.getRangoEtario(rangoEtario, Integer.parseInt(pesoRangoEtario));
			this.puesto = TipoDePuestoFactory.getTipoDePuesto(tipoDePuesto, Integer.parseInt(pesoTipoDePuesto));

	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public PretensionSalarial getRemuneracion() {
		return remuneracion;
	}

	public DatosDeEmpleo getPuesto() {
		return puesto;
	}

	public DatosDeEmpleo getrEtario() {
		return rEtario;
	}

	public DatosDeEmpleo getExperiencia() {
		return experiencia;
	}

	public DatosDeEmpleo getEstudios() {
		return estudios;
	}

	public DatosDeEmpleo getHorario() {
		return horario;
	}
	
	

}
