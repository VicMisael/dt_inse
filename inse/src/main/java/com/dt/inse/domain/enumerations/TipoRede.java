package com.dt.inse.domain.enumerations;

public enum TipoRede {
    Federal, Estadual, Municipal;

    public static TipoRede fromInteger(Integer i) {
        return switch (i) {
            case 1 -> Federal;
            case 2 -> Estadual;
            case 3 -> Municipal;
            default -> null;
        };
    }
}
