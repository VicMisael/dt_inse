package com.dt.inse.domain.enumerations;

public enum TipoCapital {
    Capital(1), Interior(2);
    public final Integer code;

    public static TipoCapital fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Capital;
            case 2 -> Interior;
            default -> null;
        };
    }

    TipoCapital(Integer code) {
        this.code = code;
    }
}
