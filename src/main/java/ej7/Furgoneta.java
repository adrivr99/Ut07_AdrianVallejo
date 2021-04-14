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
public class Furgoneta extends Vehiculo {
    // Atributos específicos

    private int carga;
    private int volumen;

    public Furgoneta(Long bastidor, String matricula, String marca, String modelo,
            String color, double tarifa, boolean disponible, int carga, int volumen) {
        super(matricula, marca, modelo, color, tarifa, disponible);
        this.carga = carga;
        this.volumen = volumen;
    }

    // métodos ‘get’ de la subclase Furgoneta. Se omiten setters
    public int getCarga() {
        return this.carga;
    }

    public int getVolumen() {
        return this.volumen;
    }

    @Override
    public String toString() {
        return super.toString() + " Carga (kg): " + this.carga
                + " Volumen (m3): " + this.volumen;
    }
}
