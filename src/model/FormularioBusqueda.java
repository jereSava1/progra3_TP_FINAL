package model;

import lombok.Getter;
import lombok.Setter;
import types.*;

@Getter
@Setter
public class FormularioBusqueda {
    private Float remuneracionMinima;
    private Float remuneracionMaxima;
    private Integer edadMinima;
    private Integer edadMaxima;
    private Locacion locacion;
    private ExperienciaPrevia experienciaPrevia;
    private CargaHoraria cargaHoraria;
    private TipoDePuesto tipoDePuesto;
    private Estudios estudios;    
}
