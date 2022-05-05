package model.ticket;


import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class FormularioBusqueda {

    private PretensionSalarial pretensionSalarial;
    private float remuneracionPretendida;
    private DatosDeEmpleo rangoEtario;
    private DatosDeEmpleo locacion;
    private DatosDeEmpleo experienciaPrevia;
    private DatosDeEmpleo cargaHoraria;
    private DatosDeEmpleo tipoDePuesto;
    private DatosDeEmpleo estudios;


    public FormularioBusqueda(DatosDeEmpleo rangoEtario, DatosDeEmpleo locacion, DatosDeEmpleo experienciaPrevia, DatosDeEmpleo cargaHoraria,
                              DatosDeEmpleo tipoDePuesto, DatosDeEmpleo estudios, float remuneracionPretendida) {
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


	public DatosDeEmpleo getRangoEtario() {
		return rangoEtario;
	}


	public DatosDeEmpleo getLocacion() {
		return locacion;
	}


	public DatosDeEmpleo getExperienciaPrevia() {
		return experienciaPrevia;
	}


	public DatosDeEmpleo getCargaHoraria() {
		return cargaHoraria;
	}


	public DatosDeEmpleo getTipoDePuesto() {
		return tipoDePuesto;
	}


	public DatosDeEmpleo getEstudios() {
		return estudios;
	}

    
}
