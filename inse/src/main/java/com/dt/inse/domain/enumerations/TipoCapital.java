package com.dt.inse.domain.enumerations;

public enum TipoCapital {
    Capital, Interior;

    public static TipoCapital fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Capital;
            case 2 -> Interior;
            default -> null;
        };
    }
}
