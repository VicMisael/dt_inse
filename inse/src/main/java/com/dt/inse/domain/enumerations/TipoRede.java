package com.dt.inse.domain.enumerations;

public enum TipoRede {
    Federal(1), Estadual(2), Municipal(3);

    public final Integer code;

    public static TipoRede fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Federal;
            case 2 -> Estadual;
            case 3 -> Municipal;
            default -> null;
        };
    }

    TipoRede(Integer code) {
        this.code = code;
    }

}
