package model.ticket.pretensionSalarial;

import interfaces.Puntajes;

public abstract class PretensionSalarial implements Puntajes {
    private final String valor;
    private int peso;
    private float remuneracion;

    public abstract float calculaPuntaje(PretensionSalarial var1);

    public PretensionSalarial(String valor, int peso,float remuneracionPretendida) {
        this.valor = valor;
        this.peso = peso;
        this.remuneracion=remuneracionPretendida;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getValor() {
        return this.valor;
    }

    public int getPeso() {
        return this.peso;
    }

	public float getRemuneracion() {
		return remuneracion;
	}

}