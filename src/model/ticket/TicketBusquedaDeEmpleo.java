package model.ticket;

import model.usuario.Empleado;
import model.usuario.Usuario;
import types.Resultado;

public class TicketBusquedaDeEmpleo extends Ticket {
    
    private Resultado resultado;
    
    public TicketBusquedaDeEmpleo(FormularioBusqueda formularioBusqueda, Empleado empleado) {
        super(formularioBusqueda, empleado);
        this.resultado = Resultado.INCONCLUSO;
    }

    //TODO: completar to string con todos los atributos del form
    @Override
    public String toString(){
        return "Remuneracion pretendida: " + this.getFormularioDeBusqueda().getRemuneracionPretendida() + "\n" +
                "Resultado " + (this.resultado != null ? this.resultado.toString() : "inconcluso") + "\n";
    }
}
