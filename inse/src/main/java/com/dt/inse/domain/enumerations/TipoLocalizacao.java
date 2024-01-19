package com.dt.inse.domain.enumerations;

public enum TipoLocalizacao {
    Urbana(1), Rural(1);
    public final Integer code;

    public static TipoLocalizacao fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Urbana;
            case 2 -> Rural;
            default -> null;
        };
    }

    TipoLocalizacao(Integer code) {
        this.code = code;
    }
}
