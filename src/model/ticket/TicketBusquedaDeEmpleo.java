package model.ticket;

import model.Usuario;
import model.usuario.Empleado;
import types.Resultado;

public class TicketBusquedaDeEmpleo extends Ticket {
    
    private Resultado resultado;
    
    public TicketBusquedaDeEmpleo(FormularioBusqueda formularioBusqueda, Empleado empleado) {
        super(formularioBusqueda, empleado);
    }

    @Override
    public String toString(){
        return "Remuneración minima: " + this.getFormularioDeBusqueda().getRemuneracionMinima() + "\n" +
                "Remuneracion maxima: " + this.getFormularioDeBusqueda().getRemuneracionMaxima() + "\n" +
                "Resltado " + (this.resultado != null ? this.resultado.toString() : "inconcluso") + "\n";
    }
}
