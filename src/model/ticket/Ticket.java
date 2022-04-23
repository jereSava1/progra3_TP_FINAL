package model.ticket;

import java.time.LocalDate;

import lombok.Getter;

import lombok.Setter;

import model.Usuario;
import types.EstadoTicket;

@Getter
@Setter

public class Ticket {
    private Usuario dueno;
    private FormularioBusqueda formularioDeBusqueda;
    private LocalDate fechaDeAlta; //LocalDate -> Represents a date (year, month, day (yyyy-MM-dd))  
    private EstadoTicket estadoTicket;


    public Ticket(FormularioBusqueda formularioDeBusqueda, Usuario usuario) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = LocalDate.now();
        this.estadoTicket = EstadoTicket.ACTIVO;
        this.dueno = usuario;
    }


}
