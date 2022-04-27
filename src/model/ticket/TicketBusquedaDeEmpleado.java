package model.ticket;

import lombok.Getter;
import lombok.Setter;
import model.usuario.Empleador;

@Getter
@Setter
public class TicketBusquedaDeEmpleado extends Ticket {
     
    private int empleadosNecesitados;
    private int empleadosObtenidos = 0;

    
    public TicketBusquedaDeEmpleado(FormularioBusqueda formularioDeBusqueda, int empleadosNecesitados, Empleador empleador) {
        super(formularioDeBusqueda, empleador);
        this.empleadosNecesitados = empleadosNecesitados;
    }

    //TODO: completar
    @Override
    public String toString(){
        return "Cantidad de empleados: " + this.empleadosNecesitados + "\n" +
                "Empleados obtenidos: " + this.empleadosObtenidos + "\n";
    }

}
