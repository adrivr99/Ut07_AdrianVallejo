/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author adrian
 */
public class Ej4 {

    public static void main(String[] args) {
        //se crean modelos de vehiculos para luego generar matriculas aleatorias que no se repitan
        final String MARCADEPORTIVO = "Seat";
        final String MODELODEPORTIVO = "Leon";
        final String COLORDEPORTIVO = "Azul";
        final boolean DISPONIBLEDEPORTIVO = true;
        final int TARIFADEPORTIVO = 2000;
        final boolean MARCHAAUTOMATICADEPORTIVO = false;
        final int CILINDRADADEPORTIVO = 2000;

        final String MARCATURISMO = "Peugeot";
        final String MODELOTURISMO = "508";
        final String COLORTURISMO = "Rojo";
        final boolean DISPONIBLETURISMO = true;
        final int PUERTASTURISMO = 5;
        final int TARIFATURISMO = 1000;
        final boolean MARCHAAUTOMATICATURISMO = true;

        final long BASTIDORFURGONETA = 344444;
        final String MARCAFURGONETA = "Citroen";
        final String MODELOFURGONETA = "C15";
        final String COLORFURGONETA = "Blanco";
        final boolean DISPONIBLEFURGONETA = true;
        final int CARGAFURGONETA = 5;
        final int TARIFAFURGONETA = 3000;
        final int VOLUMENFURGONETA = 444;

        ArrayList<Vehiculo> vehiculosLista = new ArrayList<>();

        //se realizan 3 for para llenar el arraylist
        for (int i = 0; i < 30; i++) {
            vehiculosLista.add(new Turismo(matriculaAleatoria(vehiculosLista), MARCATURISMO, MODELOTURISMO, COLORTURISMO, TARIFATURISMO, DISPONIBLETURISMO, PUERTASTURISMO, MARCHAAUTOMATICATURISMO));
        }

        for (int i = 0; i < 30; i++) {
            vehiculosLista.add(new Deportivo(matriculaAleatoria(vehiculosLista), MARCADEPORTIVO, MODELODEPORTIVO, COLORDEPORTIVO, TARIFADEPORTIVO, DISPONIBLEDEPORTIVO, MARCHAAUTOMATICADEPORTIVO, CILINDRADADEPORTIVO));
        }

        for (int i = 0; i < 30; i++) {
            vehiculosLista.add(new Furgoneta(BASTIDORFURGONETA, matriculaAleatoria(vehiculosLista), MARCAFURGONETA, MODELOFURGONETA, COLORFURGONETA, TARIFAFURGONETA, DISPONIBLEFURGONETA, CARGAFURGONETA, VOLUMENFURGONETA));
        }

        //ahora empezamos a escribir el CSV
        String ej4 = "vehiculos.CSV";
        String tmp;

        //cada tipo de vehiculo tiene asignado un numero entre 0 y 2
        final String TURISMO = "0", DEPORTIVO = "1", FURGONETA = "2";
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(ej4))) {
            
            
            
            //dependiendo del tipo de vehiculo imprimira el correspondiente
            for (int i = 0; i < vehiculosLista.size(); i++) {

                if (vehiculosLista.get(i) instanceof Turismo) {
                    flujo.write(TURISMO + ":" + vehiculosLista.get(i).toString());
                } else if (vehiculosLista.get(i) instanceof Deportivo) {
                    flujo.write(DEPORTIVO + ":" + vehiculosLista.get(i).toString());
                } else if (vehiculosLista.get(i) instanceof Furgoneta) {
                    flujo.write(FURGONETA + ":" + vehiculosLista.get(i).toString());
                }

                flujo.newLine();
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + ej4 + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //metodo para generar matricula aleatoria
    public static String matriculaAleatoria(ArrayList<Vehiculo> vehiculosLista) {
        Random random = new Random();
        String matricula, letras = "", numeros = "";
        boolean validez = true;
        //do while que genera una matricula y en caso de que se repita genera una nueva
        do {
            for (int i = 0; i < 7; i++) {
                if (i > 0 && i < 3) {
                    numeros += String.valueOf(random.nextInt(10));
                } else {
                    letras += String.valueOf((char) random.nextInt(26) + 'a');
                }
            }
            matricula = letras + numeros;
            
            //comprueba si la matricula esta vacia o no y comprueba si es igual 
            if (!vehiculosLista.isEmpty()) {
                for (int i = 0; i < vehiculosLista.size(); i++) {
                    if (vehiculosLista.get(i).getMatricula().equals(matricula)) {
                        validez = false;
                    }
                }
            }
        } while (!validez);
        return matricula;
    }
}
