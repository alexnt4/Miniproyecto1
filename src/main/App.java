package main;
import java.util.ArrayList;
import java.util.Scanner;
import logica.Gato;
import logica.Mascota;
import logica.Perro;
import logica.RazaPerro;

public class App {

    static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    //Menu principal
    public static void MenuPrincipal() {
        Scanner sc= new Scanner(System.in);
        byte opc=0;
        do {          
            System.out.println("\n---------MENU--------\n"
                               +"1. Insertar mascota\n"
                               +"2. Actualizar mascota\n"
                               +"3. Eliminar mascota\n"
                               +"4. Buscar mascota por nombre\n"
                               +"5. Listar todas las mascotas\n"
                               +"6. Salir\n"
                               +"Ingrese una opcion: ");
            opc=sc.nextByte();
            switch(opc){
                case 1: insertarMascota();
                break;
                case 2: 
                break;
                case 3: 
                break;
                case 4: 
                break;
                case 5: 
                break;
                default: break;
            } 
        } while (opc!=6);  
        sc.close();
    }

    
    static Scanner scanner = new Scanner(System.in);

    // funcion para insertar las mascotas
    public static void insertarMascota() {
        System.out.println("Seleccione el tipo de mascota a agregar:");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        switch(opcion) {
            case 1:
                agregarPerro();
                break;
            case 2:
                agregarGato();
                break;
            default:
                System.out.println("Opción inválida");
        }
        
    }

    // funcion para agregar un perro, pido los atributos los atributos del gato y creo un objeto gato con los atributos
    // TODO falta agregar el atributo RazaPerro
    public static void agregarPerro(){
        System.out.print("Ingrese el nombre del perro: ");
        String nombrePerro = scanner.nextLine();
        System.out.println("Ingrese la raza del perro");
        //RazaPerro raza = scanner.();
        System.out.print("Ingrese las vacunas del perro: ");
        byte vacunasPerro = scanner.nextByte();
        System.out.println("Ingrese el precio del perro: ");
        double precioPerro = scanner.nextDouble();
        System.out.println("Ingrese el pais de origen del perro: ");
        String paisOrigenP = scanner.nextLine();

        scanner.nextLine(); // Limpiar el buffer del scanner
        //Perro nuevoPerro = new Perro(nombrePerro, raza, edadPerro, precioPerro, paisOrigen );
        //mascotas.add(nuevoPerro);
    }

    // funcion para agregar un gato, pido los atributos los atributos del gato y creo un objeto gato con los atributos
    public static void agregarGato(){
        System.out.print("Ingrese el nombre del gato: ");
        String nombreGato = scanner.nextLine();
        System.out.print("Ingrese las vacunas del gato: ");
        byte vacunasGato= scanner.nextByte();
        System.out.println("Ingrese el precio del gato: ");
        double precioGato = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Ingrese el pais de origen del gato: ");
        String paisOrigenG = scanner.nextLine();
      
        Gato nuevoGato = new Gato(nombreGato, vacunasGato, precioGato, paisOrigenG );
        mascotas.add(nuevoGato);

        // lista las mascotas agregradas a modo de comprobar el funcionamiento del metodo insertarMascotas
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i) instanceof Gato) {
                Gato gato1 = (Gato) mascotas.get(i);
                System.out.println(gato1.toString());
                System.out.println("Nombre: " + gato1.getNombre());
                System.out.println("Vacunas: " + gato1.getVacunas());
                System.out.println("Precio : " + gato1.getPrecio());
                System.out.println("Pais de origen : " + gato1.getPaisOrigen());
                System.out.println("Mostrar id: " + gato1.getId());
                gato1.mostrarInformacion();
                

            }
        }
    }





    public static void main(String[] args) throws Exception {

        MenuPrincipal();
        
        


        

        // Prueba con objetos Perro
        /*System.out.println("\nPruebas obj Perro");
        Perro alfred = new Perro();
        alfred.mostrarInformacion();

        Perro kaiser = new Perro("Kaiser", RazaPerro.Pastor, (byte)3, 1_000_000d, "Alemania");
        kaiser.mostrarInformacion();
        
        Perro perro1 = new Perro("Lucas", RazaPerro.Pastor, (byte)4);
        perro1.mostrarInformacion();

        Perro perro2 = new Perro("Nico", RazaPerro.Pug, (byte)4, 100_000d, "Congo");
        perro2.mostrarInformacion();

        System.out.println(perro1.apodo());
        System.out.println(perro2.tributo());
        System.out.println(kaiser.saludar()); 


        // Pruebas con objetos Gato
        System.out.println("\n\nPruebas obj Gato");

        Gato paco = new Gato();
        paco.mostrarInformacion();

        Gato garf = new Gato("Garf", (byte)3, 1_000_000d, "Brasil");
        garf.mostrarInformacion();

        Gato pancho = new Gato("Pancho",(byte)2, 543_000d, "Colombia");
        pancho.mostrarInformacion();

        Gato gato1 = new Gato("Bob", (byte)0, 250_000d );
        gato1.mostrarInformacion();

        System.out.println(gato1.apodo());
        System.out.println(garf.tributo());
        System.out.println(pancho.saludar()); 

        //Metodo menu
        App.MenuPrincipal(); */

    } 
}
