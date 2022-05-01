package model.ticket;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;

import lombok.Setter;
import model.usuario.ListaDeAsignaciones;
import model.usuario.Usuario;
import types.EstadoTicket;


@Getter
public class Ticket {
	 private Usuario dueno;
	 @Setter private FormularioBusqueda formularioDeBusqueda;
	 private LocalDate fechaDeAlta; //LocalDate -> Represents a date (year, month, day (yyyy-MM-dd))  
	 @Setter private EstadoTicket estadoTicket;
	 @Setter private List<ListaDeAsignaciones> listaDeAsignaciones;


    public Ticket(FormularioBusqueda formularioDeBusqueda, Usuario usuario) {
        this.formularioDeBusqueda = formularioDeBusqueda;
        this.fechaDeAlta = LocalDate.now();
        this.estadoTicket = EstadoTicket.ACTIVO;
        this.dueno = usuario;
        
    }
    
    



}
