package types;

import lombok.Getter;

@Getter
public enum CargaHoraria {
    MEDIA(1F, -0.5F, -1F),
    COMPLETA(-0.5F,1F,-0.5F),
    EXTENDIDA(-1F, 1F, -0.5F);

    private float matchMedia;
    private float matchCompleta;
    private float matchExtendida;

    CargaHoraria(float matchMedia, float matchCompleta, float matchExtendida) {
        this.matchMedia = matchMedia;
        this.matchCompleta = matchCompleta;
        this.matchExtendida = matchExtendida;
    }
}
