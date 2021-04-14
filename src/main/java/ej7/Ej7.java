/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author adrian
 */
public class Ej7 {
    public static void main(String[] args) {
        String idFichero = "vehiculos.CSV";
        
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);
        
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                
                Vehiculo aux;
                for(int i = 0; i < tokens.length; i++){
                    for(int j=0; j < tokens.length-i-1; j++){
                       if(Vehiculo.get(j+1).getMarca() < Vehiculo.get(j).getMarca()){
                        aux = Vehiculo.get(j+1);
                        Vehiculo.set(j+1, Vehiculo.get(j));
                        Vehiculo.set(j, aux);                
                } 
                    }
                }
                    
                
                
                /*Collections.sort(tokens, new Comparator<ej4.Vehiculo>() {
                public int compare(ej4.Vehiculo obj1, ej4.Vehiculo obj2) {
                return obj1.getMarca().compareTo(obj2.getMarca());
                    }
                 });*/

                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
