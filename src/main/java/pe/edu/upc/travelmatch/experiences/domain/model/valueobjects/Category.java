package pe.edu.upc.travelmatch.experiences.domain.model.valueobjects;

public enum Category {
    CULTURA(1),
    GASTRONOMIA(2),
    NATURALEZA(3),
    DEPORTE(4);

    private final int code;

    Category(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Category fromCode(int code) {
        return switch (code) {
            case 1 -> CULTURA;
            case 2 -> GASTRONOMIA;
            case 3 -> NATURALEZA;
            case 4 -> DEPORTE;
            default -> throw new IllegalArgumentException("Invalid category code: " + code);
        };
    }
}