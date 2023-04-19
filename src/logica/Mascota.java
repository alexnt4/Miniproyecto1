package logica;

public abstract class Mascota {
    // valores por defecto
    public static final double PRECIO_MASCOTA_POR_DEFECTO = 0d;
    public static final String PAIS_POR_DEFECTO = "NN";

    // Atribuos
    private byte vacunas;
    private double precio;
    private String paisOrigen;

    // Constructores 
    // 3 argumentos
    public Mascota(byte vacunas, double precio, String paisOrigen) {
        this.vacunas = vacunas;
        this.precio = precio;
        this.paisOrigen = paisOrigen;
    }
    // 2 argumentos
    public Mascota(byte vacunas, double precio) {
        this(vacunas, precio, PAIS_POR_DEFECTO);
    }
    // 1 argumento
    public Mascota(byte vacunas) {
        this(vacunas, PRECIO_MASCOTA_POR_DEFECTO, PAIS_POR_DEFECTO);
    }


    // Setters - Getters
    public byte getVacunas() {
        return vacunas;
    }

    public void setVacunas(byte vacunas) {
        this.vacunas = vacunas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }


    // Metodos
    public abstract void mostrarInformacion();

}
