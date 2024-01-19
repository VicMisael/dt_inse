package com.dt.inse.domain.enumerations;

public enum TipoLocalizacao {
    Urbana, Rural;

    public static TipoLocalizacao fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Urbana;
            case 2 -> Rural;
            default -> null;
        };
    }
}
