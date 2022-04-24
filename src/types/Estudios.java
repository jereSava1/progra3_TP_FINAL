package types;

import lombok.Getter;

@Getter
public enum Estudios {
    PRIMARIO(1F, 1.5F, 2F),
    SECUNDARIO(-0.5F, 1F, 1.5F),
    TERCIARIO(-2, -1.5F, 1);

    private float matchPrimario;
    private float matchSecundario;
    private float matchTerciario;

    Estudios(float matchPrimario, float matchSecundario, float matchTerciario) {
        this.matchPrimario = matchPrimario;
        this.matchSecundario = matchSecundario;
        this.matchTerciario = matchTerciario;
    }
}
