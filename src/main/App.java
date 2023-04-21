package main;
import java.util.ArrayList;
import java.util.List;
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
                case 5: listarMascotas();
                break;
                default: break;
            } 
        } while (opc!=6);  
        sc.close();
    }

    /* Menú que permite seleccionar alguna de las mascotas y posteriormente insertarla en la lista de Mascotas */
    public static void insertarMascota() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n---------Agregando Mascota--------\n");
        System.out.println("Que tipo de mascota desea agregar?");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.print("Ingrese una opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner
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

    /* funcion que permite agregar un objeto tipo Perro. Pide los datos necesarios, los cuales son almacenados en
    variables, las cuales posteriormente se usan como argumentos para crear un objeto de tipo Perro, el cual es
    almacenado en la lista de mascotas */ 
    public static void agregarPerro(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del perro: ");
        String nombrePerro = sc.nextLine();
        // Menu para ingresar Raza
        RazaPerro raza = asignarRaza();
        System.out.print("Ingrese las vacunas del perro: ");
        byte vacunasPerro = sc.nextByte();
        System.out.println("Ingrese el precio del perro: ");
        double precioPerro = sc.nextDouble();
        sc.nextLine(); // limpio entrada
        System.out.println("Ingrese el pais de origen del perro: ");
        String paisOrigenP = sc.nextLine();

        //Creo el objeto Perro y lo agrego a la lista de mascotas
        Perro nuevoPerro = new Perro(nombrePerro, raza, vacunasPerro, precioPerro, paisOrigenP);
        mascotas.add(nuevoPerro);

        System.out.println("\nMascota agregada con exito\n");
    }

    /*Asignar la raza de un perro requiere una comprobacion adicional para verificar que lo ingresado sea igual a
        uno de los valores del Enum de Razas. La funcion crea una lista de las razas transformandolas a Strings,
        imprime estas en pantalla, posteriormente pide al usuario el ingreso del nombre de alguna de estas razas
        y verifica si esa raza se encuentra en la lista de strings. Cuando el valor se encuentre en la lista
        se convierte ese valor en su correspondiente en el Enum de razas y se retorna esta raza */
    private static RazaPerro asignarRaza() {
        System.out.println("\n-- Ingresando raza del perro --\nRazas:\n");
        RazaPerro razaSeleccionada = RazaPerro.NoRegistrado;
    
        //Crear una lista de razas, usando el enum, esta lista sera String
        List<String> razasList = new ArrayList<>();
        for (RazaPerro raza : RazaPerro.values()) {
            System.out.printf("--> %s\n", raza); //  Muestro las razas
            razasList.add(raza.name()); // añado la raza a la lista de razas
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre de una de las razas disponibles: ");
        //Comprobacion
        String seleccion = sc.nextLine();
        while (!razasList.contains(seleccion)){ // si el lo que escribo no se encuenta dentro de la lista entonces se ejecuta
            System.out.printf("\nError, la raza que ha ingresado %s no existe. Ingrese una de las establecidas.\n"+
            "Ingrese el nombre de una de las razas disponibles: ", seleccion);
            seleccion = sc.nextLine();
        }
        razaSeleccionada = RazaPerro.valueOf(seleccion);      
        return razaSeleccionada;
    }

    /*Funcion que permite agregar un Gato, cuenta con el mismo funcionamiento de la funcion para agregar Perro */
    public static void agregarGato(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del gato: ");
        String nombreGato = sc.nextLine();
        System.out.print("Ingrese las vacunas del gato: ");
        byte vacunasGato= sc.nextByte();
        System.out.println("Ingrese el precio del gato: ");
        double precioGato = sc.nextDouble();
        sc.nextLine(); // limpio entrada
        System.out.println("Ingrese el pais de origen del gato: ");
        String paisOrigenG = sc.nextLine();
      
        //Creo el objeto Gato y lo agrego a la lista de mascotas
        Gato nuevoGato = new Gato(nombreGato, vacunasGato, precioGato, paisOrigenG );
        mascotas.add(nuevoGato);

        System.out.println("\nMascota agregada con exito\n");
    }

    /* Listo todas las mascotas y sus datos correspondientes. La funcion recorre toda la lista de mascotas y por cada mascota
     llama el metodo mostraInformacion() el cual tiene un formato predefinido para mostrar todos los datos del objeto.
     */
    public static void listarMascotas(){
        System.out.println("\n--------Lista de todas las mascotas--------");
        for (Mascota mascota : mascotas) {
            System.out.println("--------------------");
            mascota.mostrarInformacion();
        }
    }

    public static void main(String[] args) throws Exception {

        //Agregando mascotas para tener datos de antemano
        Perro kaiser = new Perro("Kaiser", RazaPerro.Pastor, (byte)3, 1_000_000d, "Alemania");
        mascotas.add(kaiser);
        Gato pancho = new Gato("Pancho",(byte)2, 543_000d, "Colombia");
        mascotas.add(pancho);
        Perro baki = new Perro("Baki", RazaPerro.Labrador, (byte)0, 985_900d, "Francia");
        mascotas.add(baki);
        Perro alfred = new Perro("Alfred", RazaPerro.Tacita, (byte)1, 655_000d, "USA");
        mascotas.add(alfred);
        Gato mono = new Gato("Mono", (byte)1, 450_000d, "Sudan");
        mascotas.add(mono);

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
         */

    } 
}
