package model.ticket;

import java.time.LocalDate;

import lombok.Getter;

import lombok.Setter;

import model.Usuario;
import types.CargaHoraria;
import types.EstadoTicket;
import types.Estudios;

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

    public float coincidenciaEstudios(FormularioBusqueda otroFormulario, int peso){
        float result;

        if (otroFormulario.getEstudios() == Estudios.PRIMARIO){
            result = this.formularioDeBusqueda.getEstudios().getMatchPrimario();
        } else if (otroFormulario.getEstudios() == Estudios.SECUNDARIO) {
            result = this.formularioDeBusqueda.getEstudios().getMatchSecundario();
        } else {
            result = this.formularioDeBusqueda.getEstudios().getMatchTerciario();
        }

        return peso * result;
    }

    public float coincidenciaHoraria(FormularioBusqueda otroFormulario, int peso){
        float result;

        if (otroFormulario.getCargaHoraria() == CargaHoraria.COMPLETA) {
            result = this.formularioDeBusqueda.getCargaHoraria().getMatchCompleta();
        } else if (otroFormulario.getCargaHoraria() == CargaHoraria.MEDIA) {
            result = this.formularioDeBusqueda.getCargaHoraria().getMatchMedia();
        } else {
            result = this.formularioDeBusqueda.getCargaHoraria().getMatchExtendida();
        }

        return peso * result;
    }

}
