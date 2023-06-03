package org.example.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Futbol {
    private int id;
    private String jugador;
    private String numero;
    private String sobrenombre;
    private String equipo;
    private String paisNacimiento;
    private String url;

    public Futbol() {
    }

    public Futbol(int id, String jugador, String numero, String sobrenombre, String equipo, String paisNacimiento, String url) {
        this.id = id;
        this.jugador = jugador;
        this.numero = numero;
        this.sobrenombre = sobrenombre;
        this.equipo = equipo;
        this.paisNacimiento = paisNacimiento;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSobrenombre() {
        return sobrenombre;
    }

    public void setSobrenombre(String sobrenombre) {
        this.sobrenombre = sobrenombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Futbol{" +
                "id=" + id +
                ", jugador='" + jugador + '\'' +
                ", numero='" + numero + '\'' +
                ", sobrenombre='" + sobrenombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", paisNacimiento='" + paisNacimiento + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
