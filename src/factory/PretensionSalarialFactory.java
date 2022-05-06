package factory;

import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.experiencia.Media;
import model.ticket.pretensionSalarial.EntreV1YV2;
import model.ticket.pretensionSalarial.MasDeV2;
import model.ticket.pretensionSalarial.MenosV1;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class PretensionSalarialFactory {

	private Agencia agencia = Agencia.getAgencia();

	/**
	 * pre: peso >= 0;
	 * pos: Instanciar objeto de tipo Pretension salarial
	 * @param peso
	 * @param remuneracionPretendida remuneracion que pretende el usuario en su formulario de busqueda
	 * @return instancia de tipo PretensionSalarial
	 * @throws ConstructorInvalidoException
	 */
	public PretensionSalarial getPretensionSalarial(int peso, float remuneracionPretendida)
			throws ConstructorInvalidoException {
		float v1 = this.agencia.getRemuneracionV1();
		float v2 = this.agencia.getRemuneracionV2();

		if (remuneracionPretendida > 0) {
			if (remuneracionPretendida < v1) {
				return new MenosV1(peso,remuneracionPretendida);
			}

			if (remuneracionPretendida >= v1 && remuneracionPretendida <= v2) {
				return new EntreV1YV2(peso,remuneracionPretendida);
			}
			if (remuneracionPretendida > v2) {
				return new MasDeV2(peso,remuneracionPretendida);
			}
		}
		throw new ConstructorInvalidoException("Sueldo Pretendido menor a 0");
	}
}
