/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author adrian
 */
public class Ej2 {
    public static void main(String[] args) {
        Scanner scaner = new Scanner (System.in);
        String idFichero = "arrayEj2.txt";
        String tmp;
        
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            do{
                System.out.println("Escribe un linea de texto");
                tmp = scaner.nextLine();
                if (!"EOF".equals(tmp)){
                    flujo.write(tmp + "\n");
                }
            }while(!"EOF".equals(tmp));            
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
