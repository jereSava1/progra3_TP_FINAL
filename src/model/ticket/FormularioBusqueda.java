package model.ticket;


import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.PretensionSalarial;

/**
 * Define el formulario de busqueda que contendra los datos necesarios para generar
 * tickets de busquedas para el usuario
 */
public class FormularioBusqueda {

	/**
	 * - Pretension Salarial
	 *     - R < V1
	 *     - V1 < R < V2
	 *     - R > V2
	 *     -> V1, V2 Seran valores para establecer un rango, son establecidos arbitrariamente por la Agencia
	 */
	private PretensionSalarial pretensionSalarial;
	/**
	 * - Remuneracion Pretendida
	 * 	   - El usuario ingresa la remuneracion que desea, a partir de esta pretension se establece
	 * 	   el estado de Pretension salarial, que sera el rango en el que se encuentre la Remuneracion Pretendida
	 */
    private float remuneracionPretendida;
	/**
	 * - Rango etario
	 *     - E < 40
	 *     - 40 < E < 50
	 *     - E > 50
	 */
    private DatosDeEmpleo rangoEtario;
	/**
	 * - Locación
	 *     - Remoto
	 *     - Presencial
	 *     - Cualquiera
	 */
    private DatosDeEmpleo locacion;
	/**
	 * - Experiencia previa
	 *     - Nada
	 *     - Media
	 *     - Mucha
	 */
    private DatosDeEmpleo experienciaPrevia;
	/**
	 * - Carga horaria
	 *     - Media
	 *     - Completa
	 *     - Extendida
	 */
    private DatosDeEmpleo cargaHoraria;
	/**
	 * - Tipo de puesto
	 *     - Junior
	 *     - Senior
	 *     - etc.
	 */
    private DatosDeEmpleo tipoDePuesto;
	/**
	 * - Estudios
	 *     - Primario
	 *     - Secundario
	 *     - Terciario
	 */
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
