package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Gato;
import logica.Mascota;
import logica.Perro;
import logica.RazaPerro;

public class App {

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void esperarEnter() {
        System.out.print("\nPresiona enter para continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        // scanner.close();
    }

    static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    //Menu principal
    public static void MenuPrincipal() {
        limpiarConsola();
        Scanner sc= new Scanner(System.in);
        byte opc=0;
        do {
            limpiarConsola();          
            System.out.print("\n---------MENU--------\n"
                               +"1. Insertar mascota\n"
                               +"2. Actualizar mascota\n"
                               +"3. Eliminar mascota\n"
                               +"4. Buscar mascota por nombre\n"
                               +"5. Listar todas las mascotas\n"
                               +"0. Salir\n"
                               +"Ingrese una opcion: ");
            opc=sc.nextByte();
            switch(opc){
                case 1: limpiarConsola(); insertarMascota();
                break;
                case 2:
                break;
                case 3: 
                break;
                case 4: limpiarConsola(); buscarMascotaPorNombre();
                break;
                case 5: limpiarConsola(); listarMascotas();
                break;
                case 0: limpiarConsola(); System.out.println("Gracias por usar el programa.");
                break;
                default: System.out.println("\nError, seleccione una opcion correcta."); esperarEnter();
            } 
        } while (opc!=0);  
        sc.close();
    }

    /* Menú que permite seleccionar alguna de las mascotas y posteriormente insertarla en la lista de Mascotas */
    public static void insertarMascota() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("\n------Agregando Mascota------\n");
            System.out.print("Que tipo de mascota desea agregar?\n" +
                            "1. Perro\n" + 
                            "2. Gato\n" + 
                            "0. Regresar\n" + 
                            "Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner
            switch(opcion) {
                case 1:
                    limpiarConsola(); agregarPerro();
                    break;
                case 2:
                    limpiarConsola(); agregarGato();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nError, seleccione una opcion correcta."); esperarEnter(); limpiarConsola(); 
                    break;
            }
        }while(opcion != 0);
       
        
    }

    /* funcion que permite agregar un objeto tipo Perro. Pide los datos necesarios, los cuales son almacenados en
    variables, las cuales posteriormente se usan como argumentos para crear un objeto de tipo Perro, el cual es
    almacenado en la lista de mascotas */ 
    public static void agregarPerro(){
        System.out.println("----Agregando Perro----");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del perro: ");
        String nombrePerro = sc.nextLine();
        // Menu para ingresar Raza
        RazaPerro raza = asignarRaza();
        System.out.print("Ingrese las vacunas del perro: ");
        byte vacunasPerro = sc.nextByte();
        System.out.print("Ingrese el precio del perro: ");
        double precioPerro = sc.nextDouble();
        sc.nextLine(); // limpio entrada
        System.out.print("Ingrese el pais de origen del perro: ");
        String paisOrigenP = sc.nextLine();

        //Creo el objeto Perro y lo agrego a la lista de mascotas
        Perro nuevoPerro = new Perro(nombrePerro, raza, vacunasPerro, precioPerro, paisOrigenP);
        mascotas.add(nuevoPerro);

        limpiarConsola();
        System.out.printf("\nLa mascota %s se ha agregado con exito\n", nuevoPerro.getNombre());
        esperarEnter();
        limpiarConsola();
    }

    /*Asignar la raza de un perro requiere una comprobacion adicional para verificar que lo ingresado sea igual a
        uno de los valores del Enum de Razas. La funcion crea una lista de las razas transformandolas a Strings,
        imprime estas en pantalla, posteriormente pide al usuario el ingreso del nombre de alguna de estas razas
        y verifica si esa raza se encuentra en la lista de strings. Cuando el valor se encuentre en la lista
        se convierte ese valor en su correspondiente en el Enum de razas y se retorna esta raza */
    private static RazaPerro asignarRaza() {
        System.out.println("\n-- Ingresando raza del perro --\nRazas:");
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
        System.out.println("----Agregando Gato----");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del gato: ");
        String nombreGato = sc.nextLine();
        System.out.print("Ingrese las vacunas del gato: ");
        byte vacunasGato= sc.nextByte();
        System.out.print("Ingrese el precio del gato: ");
        double precioGato = sc.nextDouble();
        sc.nextLine(); // limpio entrada
        System.out.print("Ingrese el pais de origen del gato: ");
        String paisOrigenG = sc.nextLine();
      
        //Creo el objeto Gato y lo agrego a la lista de mascotas
        Gato nuevoGato = new Gato(nombreGato, vacunasGato, precioGato, paisOrigenG );
        mascotas.add(nuevoGato);

        limpiarConsola();
        System.out.printf("\nLa mascota %s se ha agregado con exito\n", nuevoGato.getNombre());
        esperarEnter();
        limpiarConsola();
    }

    /* Listo todas las mascotas y sus datos correspondientes. La funcion recorre toda la lista de mascotas y por cada mascota
     llama el metodo mostraInformacion() el cual tiene un formato predefinido para mostrar todos los datos del objeto.
     */
    public static void listarMascotas(){
        
        System.out.println("\n-----Lista de todas las mascotas-----");
        for (Mascota mascota : mascotas) {
            System.out.println("--------------------");
            mascota.mostrarInformacion();
        }
        esperarEnter();
    }

    /* Busco mascotas por su nombre e imprimo los datos de esta misma. La funcion recorre toda la lista de mascotas y comprueba uno por 
        los nombres de las mascotas, si esta equivale al nombre digitado, imprime los datos de lo contrario dara un mensaja con que el nombre de la mascota 
        no existe.
     */
    public static void buscarMascotaPorNombre(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--------Buscando mascota por nombre--------");
        System.out.print("Ingrese el nombre de la mascota: ");
        String nombreMascota = sc.nextLine();
        boolean mascotaExiste = false;
        limpiarConsola();
        
        for (Mascota mascota : mascotas) {
            if (mascota instanceof Perro) { // Verifica que la mascota sea un perro
                Perro perro = (Perro) mascota; // Hace un cast de la mascota a un objeto de tipo Perro
                if (perro.getNombre().equals(nombreMascota)) {
                    System.out.println("--Datos de la mascota " + nombreMascota + "--");
                    mascota.mostrarInformacion();                    
                    mascotaExiste = true;
                    break;
                }
            }else if(mascota instanceof Gato){
                Gato gato = (Gato) mascota; // Hace un cast de la mascota a un objeto de tipo Gato
                if (gato.getNombre().equals(nombreMascota)) {
                    System.out.println("--Datos de la mascota " + nombreMascota + "--");
                    mascota.mostrarInformacion();
                    mascotaExiste = true;
                    break;   
                }
            }           
        }         
        if (!mascotaExiste){
            System.out.println("La mascota " + nombreMascota + " no existe.");}  
        esperarEnter();          
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
        
    } 
}
