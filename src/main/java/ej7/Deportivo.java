/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

import java.awt.Color;

/**
 *
 * @author adrian
 */
public class Deportivo extends Vehiculo {
    // Además de los atributos de Vehiculo, esta clase tiene los siguientes

    private int cilindrada;

    @Override
    public String toString() {
        // Llamada al método toString() de la clase Vehiculo y
        // concateno los atributos de la superclase con los de la subclase
        return super.toString() + " Cilindrada (cm3):"+this.cilindrada;
    }

    public Deportivo(String matricula, String marca, String modelo, String color,
            double tarifa, boolean disponible, boolean marchaAutomatica,int cilindrada) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
