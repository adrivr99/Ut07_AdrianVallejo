/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author adrian
 */
public class Ej3 {
    public static void main(String[] args) {
        Random random = new Random();
        String idFichero = "arrayEj3.txt";
        String tmp;
        char letra;
        
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < 50; i++) {
                
                if (random.nextInt(2) == 1){
                    letra = (char)(random.nextInt(26) + 65);
                }else{
                    letra = (char)(random.nextInt(26) + 97);
                }
                tmp = String.valueOf(letra);
                if (tmp.equalsIgnoreCase("x")){
                    flujo.write(tmp + "\n");
                }else{
                    flujo.write(tmp + ", ");
                }
                
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
