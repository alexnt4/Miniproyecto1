package main;

import logica.Gato;
import logica.Perro;
import logica.RazaPerro;

public class App {
    public static void main(String[] args) throws Exception {

        // Prueba con objetos Perro
        System.out.println("\nPruebas obj Perro");
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


        

    }
}
