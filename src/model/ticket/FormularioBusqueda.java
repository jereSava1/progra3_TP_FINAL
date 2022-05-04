package model.ticket;


import model.ticket.Locacion.Locacion;
import model.ticket.cargaHoraria.CargaHoraria;
import model.ticket.estudios.Estudios;
import model.ticket.experiencia.ExperienciaPrevia;
import model.ticket.pretensionSalarial.PretensionSalarial;
import model.ticket.rangoEtario.RangoEtario;
import model.ticket.tipoDePuesto.TipoDePuesto;

public class FormularioBusqueda {

    private PretensionSalarial pretensionSalarial;
    private float remuneracionPretendida;
    private RangoEtario rangoEtario;
    private Locacion locacion;
    private ExperienciaPrevia experienciaPrevia;
    private CargaHoraria cargaHoraria;
    private TipoDePuesto tipoDePuesto;
    private Estudios estudios;


    public FormularioBusqueda(RangoEtario rangoEtario, Locacion locacion, ExperienciaPrevia experienciaPrevia, CargaHoraria cargaHoraria,
                              TipoDePuesto tipoDePuesto, Estudios estudios, float remuneracionPretendida) {
        this.rangoEtario = rangoEtario;
        this.locacion = locacion;
        this.experienciaPrevia = experienciaPrevia;
        this.cargaHoraria = cargaHoraria;
        this.tipoDePuesto = tipoDePuesto;
        this.estudios = estudios;
        this.remuneracionPretendida = remuneracionPretendida;
    }

    @Override
	public String toString() {
		return "FormularioBusqueda "+" remuneracionPretendida="
				+ remuneracionPretendida + ", rangoEtario=" + rangoEtario.getValor() + ", locacion=" + locacion.getValor()
				+ ", experienciaPrevia=" + experienciaPrevia.getValor() + ", cargaHoraria=" + cargaHoraria.getValor() + ", tipoDePuesto="
				+ tipoDePuesto.getValor() + ", estudios=" + estudios.getValor() + "]";
	}


   //GETTERS
	public PretensionSalarial getPretensionSalarial() {
		return pretensionSalarial;
	}


	public float getRemuneracionPretendida() {
		return remuneracionPretendida;
	}


	public RangoEtario getRangoEtario() {
		return rangoEtario;
	}


	public Locacion getLocacion() {
		return locacion;
	}


	public ExperienciaPrevia getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}


	public TipoDePuesto getTipoDePuesto() {
		return tipoDePuesto;
	}


	public Estudios getEstudios() {
		return estudios;
	}

    
}
