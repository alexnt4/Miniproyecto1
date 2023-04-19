package logica;

public class Gato extends Mascota implements MejorAmigo {
    // Atributos por defecto - constantes
    public static final String NOMBRE_POR_DEFECTO = "NN";
    // Atributos
    private String nombre;

    // Constructores
    // 4 argumentos
    public Gato(String nombre, byte vacunas, double precio, String paisOrigen){
        super(vacunas, precio, paisOrigen);
        this.nombre = nombre;
    }

    // 3 argumentos
    public Gato(String nombre, byte vacunas, double precio){
        super(vacunas, precio);
        this.nombre = nombre;
    }

    // 2 argumentos
    public Gato(String nombre, byte vacunas){
        super(vacunas);
        this.nombre = nombre;
    }

    // sin argumentos
    public Gato(){
        super((byte)0, PRECIO_MASCOTA_POR_DEFECTO, PAIS_POR_DEFECTO);
        this.nombre = NOMBRE_POR_DEFECTO;
    }


    // Getters - setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodos
    @Override
    public String saludar() {
       return String.format("Miauu!, soy %s", getNombre());
    }


    @Override
    public String apodo() {
        return String.format("Michi :D");
    }


    @Override
    public String tributo() {
        return String.format("Rata :(");
    }

    @Override
    public void mostrarInformacion() {
        // TODO: Modificar formato de informacion
        System.out.printf("Gato: Nombre: %s, vacunas: %d, precio: %.2f, paisOrigen: %s%n",
         getNombre(), super.getVacunas(), super.getPrecio(), super.getPaisOrigen());
    }
    
}
