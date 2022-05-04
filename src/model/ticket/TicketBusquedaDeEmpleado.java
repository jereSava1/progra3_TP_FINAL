package model.ticket;


import model.usuario.Empleador;



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
        return super.toString()+" \nCantidad de empleados: " + this.empleadosNecesitados + "\n" +
                "Empleados obtenidos: " + this.empleadosObtenidos + "\n";
    }

    public void aumentarEmpleadosObtenidos(){
        if (empleadosObtenidos < empleadosNecesitados) {
            this.empleadosObtenidos++;
        }
    }

    //GETTERS Y SETTERS
	public int getEmpleadosNecesitados() {
		return empleadosNecesitados;
	}

	public void setEmpleadosNecesitados(int empleadosNecesitados) {
		this.empleadosNecesitados = empleadosNecesitados;
	}

	public int getEmpleadosObtenidos() {
		return empleadosObtenidos;
	}

}

