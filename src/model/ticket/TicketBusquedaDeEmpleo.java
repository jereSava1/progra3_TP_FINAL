package model.ticket;

import model.usuario.Empleado;
import model.usuario.Usuario;
import types.Resultado;

/**
 * Ticket que deberan tener todos los empleados que deseen realizar busquedas de empleo.
 */
public class TicketBusquedaDeEmpleo extends Ticket {

    /**
     *  - Resultado
     *    - Exito : Al final de la ronda de contratacion el empleado consiguio empleo
     *    - Fracaso : Al final de la ronda de contratacion el empleado NO consiguio empleo
     *    - Indeterminado : La ronda de contratacion aun no finaliza, hay una posible contratacion.
     */
    private Resultado resultado;
    
    public TicketBusquedaDeEmpleo(FormularioBusqueda formularioBusqueda, Empleado empleado) {
        super(formularioBusqueda, empleado);
        this.resultado = Resultado.INCONCLUSO;
    }

    //TODO: completar to string con todos los atributos del form
    @Override
    public String toString(){
        return super.toString()+ "Remuneracion pretendida: " + this.getFormularioDeBusqueda().getRemuneracionPretendida() + "\n" +
                "Resultado " + (this.resultado != null ? this.resultado.toString() : "inconcluso") + "\n";
    }
}
