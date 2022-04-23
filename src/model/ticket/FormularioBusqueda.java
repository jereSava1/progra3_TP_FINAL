package model.ticket;

import lombok.Getter;
import lombok.Setter;
import types.*;
@Getter
@Setter
public class FormularioBusqueda {
    private Float remuneracionMinima; 
    private Float remuneracionMaxima; 
    private RangoEtario rangoEtario;
    private Locacion locacion;
    private ExperienciaPrevia experienciaPrevia;
    private CargaHoraria cargaHoraria;
    private TipoDePuesto tipoDePuesto;
    private Estudios estudios;


    public FormularioBusqueda(Float remuneracionMinima, Float remuneracionMaxima, RangoEtario rangoEtario,
                              Locacion locacion, ExperienciaPrevia experienciaPrevia, CargaHoraria cargaHoraria,
                              TipoDePuesto tipoDePuesto, Estudios estudios) {
        this.remuneracionMinima = remuneracionMinima;
        this.remuneracionMaxima = remuneracionMaxima;
        this.rangoEtario = rangoEtario;
        this.locacion = locacion;
        this.experienciaPrevia = experienciaPrevia;
        this.cargaHoraria = cargaHoraria;
        this.tipoDePuesto = tipoDePuesto;
        this.estudios = estudios;
    }

}
