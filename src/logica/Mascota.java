package logica;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Mascota {
    // valores por defecto
    public static final double PRECIO_MASCOTA_POR_DEFECTO = 0d;
    public static final String PAIS_POR_DEFECTO = "NN";

    // Atribuos
    private int id;
    private ArrayList<String> vacunas;
    private double precio;
    private String paisOrigen;

    //Contador para el id
    private static int contador = 1;

    // Constructores 
    // 2 argumentos
    public Mascota(double precio, String paisOrigen) {
        vacunas = new ArrayList<String>();
        this.precio = precio;
        this.paisOrigen = paisOrigen;
        this.id = contador++; // agrego el valor del id y lo aumento en 1
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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setVacunas(ArrayList<String> vacunas){
        this.vacunas = vacunas;
    }

    public void mostrarVacunas(){
        System.out.println("-- Vacunas -- ");
        for (String vacuna : vacunas) {
            System.out.println(vacuna);
        }
    }


    public int getCantidadVacunas(){
        int cantVacunas =  vacunas.size();
        return cantVacunas;
    }
    // Metodos
    public abstract void mostrarInformacion();

}
