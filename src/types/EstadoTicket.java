package types;

public enum EstadoTicket {
    ACTIVO, //al momento de alta
    SUSPENDIDO, //no se tiene en cuenta para las busquedas
    CANCELADO, //el empleador lo cancela
    FINALIZADO //alcanzo la cantidad de empleados solicitados
}
