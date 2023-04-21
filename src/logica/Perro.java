package logica;

import java.util.ArrayList;

public class Perro extends Mascota implements MejorAmigo {
    // valores por defecto
    public static final String NOMBRE_POR_DEFECTO = "NN";
    public static final RazaPerro RAZA_DEFAULT = RazaPerro.NoRegistrado;

    // Atributos
    private String nombre;
    private RazaPerro raza;
    private ArrayList<Pulga> pulgas; //? Por definir implementacion

    //Constructores
    // 5 argumentos
    public Perro(String nombre, RazaPerro raza, byte vacunas, double precio, String paisOrigen){
        super(vacunas, precio, paisOrigen);
        this.nombre = nombre;
        this.raza = raza;
        pulgas = new ArrayList<Pulga>();

    }
    // 4 argumentos
    public Perro(String nombre, RazaPerro raza, byte vacunas, double precio){
        super(vacunas, precio);
        this.nombre = nombre;
        this.raza = raza;
        pulgas = new ArrayList<Pulga>();
    }
    // 3 argumentos
    public Perro(String nombre, RazaPerro raza, byte vacunas){
        super(vacunas);
        this.nombre = nombre;
        this.raza = raza;
        pulgas = new ArrayList<Pulga>();
    }
    // sin argumentos
    public Perro(){
        super((byte)0, PRECIO_MASCOTA_POR_DEFECTO, PAIS_POR_DEFECTO);
        this.nombre = NOMBRE_POR_DEFECTO;
        this.raza = RAZA_DEFAULT;
        pulgas = new ArrayList<Pulga>();
    }



    // Getters - setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public RazaPerro getRaza() {
        return raza;
    }
    public void setRaza(RazaPerro raza) {
        this.raza = raza;
    }
    public ArrayList<Pulga> getPulgas() {
        return pulgas;
    }
    public void setPulgas(ArrayList<Pulga> pulgas) {
        this.pulgas = pulgas;
    }

    // Metodos
 
    @Override
    public String saludar() {
        return String.format("Wufff!, soy %s", getNombre());
    }

    @Override
    public String apodo() {
        return String.format("Firulais");
    }

    @Override
    public String tributo() {
        return String.format("Rama");
    }

    @Override
    public void mostrarInformacion() {
        System.out.printf("ID: %d%n" +
                            "Tipo: Perro%n" + 
                            "Nombre: %s%n" +  
                            "Raza: %s%n" + 
                            "Vacunas: %d%n" + 
                            "Precio: %.2f%n" + 
                            "paisOrigen: %s%n",
                            super.getId(), getNombre(), getRaza(), super.getVacunas(), super.getPrecio(), super.getPaisOrigen());
    }
    

    //? Se añadira alguna funcionalidad con las pulgas?
    // public void insertarPulga(Pulga pulga){
    //     pulgas.add(pulga);
    // }

    // public void imprimirPulgas(){
    //     for (int i = 0; i < pulgas.size(); i++){
    //         System.out.println(pulgas.get(i).getNombre());
    //     }
    // }
}
