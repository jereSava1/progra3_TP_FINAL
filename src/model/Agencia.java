package model;


import lombok.Getter;
import lombok.Setter;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.Empleador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Agencia {
    private List<Empleado> empleados;
    private List<Empleador> empleadores;
    private List<TicketBusquedaDeEmpleo> busquedas;
    private List<TicketBusquedaDeEmpleado> solicitudes;
    static private Agencia singleton = null;
    
    private Agencia(){
        this.empleadores = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.busquedas = new ArrayList<>();
        this.solicitudes = new ArrayList<>();
    }

    public static Agencia getAgencia(){

        if( singleton == null ){
            singleton = new Agencia();
        }
        return singleton;

    }

    public void mostrarEmpleados(){
        for (Empleado empleado : this.empleados) {
            System.out.println(empleado);
        }
    }

    public void mostrarEmpleador(){
        for (Empleador empleador : this.empleadores) {
            System.out.println(empleador.toString());
        }
    }

    public void mostrarTicketBusqueda() {
        for (TicketBusquedaDeEmpleo ticket : busquedas) {
            System.out.println(ticket.toString());
        }
    }

    public void mostrarTicketSolicitud() {
        for (TicketBusquedaDeEmpleado ticket : solicitudes) {
            System.out.println(ticket.toString());
        }
    }
}
