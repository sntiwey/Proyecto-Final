package org.example;

import org.example.Vista.VentanaFutbol;
import org.example.controlador.Controlador;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaFutbol ventanaFutbol = new VentanaFutbol("Pryoecto Final");
        Controlador controlador = new Controlador(ventanaFutbol);
    }
}