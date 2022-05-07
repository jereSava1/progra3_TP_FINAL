package model.ticket.pretensionSalarial;

import model.ticket.DatosDeEmpleo;

public abstract class PretensionSalarial extends DatosDeEmpleo {
    private float remuneracion;

    public PretensionSalarial(String valor, int peso, float remuneracionPretendida) {
        super(valor, peso);
        this.remuneracion = remuneracionPretendida;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getValor() {
        return this.getValor();
    }

    public int getPeso() {
        return this.peso;
    }

	  public float getRemuneracion() {
		return remuneracion;
	}

}