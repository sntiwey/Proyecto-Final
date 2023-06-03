package org.example.controlador;

import org.example.Modelo.Futbol;
import org.example.Modelo.ModeloTabla;
import org.example.Vista.VentanaFutbol;

import javax.swing.*;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

public class Controlador extends MouseAdapter {
    private VentanaFutbol view;
    private ModeloTabla modelo;

    public Controlador(VentanaFutbol view) {
        this.view = view;
        modelo = new ModeloTabla();
        this.view.getTblFutbol().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblFutbol().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnBorrar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            modelo.cargarDatos();
            this.view.getTblFutbol().setModel(modelo);
            this.view.getTblFutbol().updateUI();
        }

        if (e.getSource() == this.view.getBtnAgregar()) {
            Futbol fut = new Futbol();
            fut.setId(0);
            fut.setJugador(this.view.getTxtJugador().getText());
            fut.setNumero(this.view.getTxtNumero().getText());
            fut.setSobrenombre(this.view.getTxtSobrenombre().getText());
            fut.setEquipo(this.view.getTxtEquipo().getText());
            fut.setPaisNacimiento(this.view.getTxtPaisNacimiento().getText());
            fut.setUrl(this.view.getTxtURL().getText());
            if (modelo.agregarInfo(fut)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso importante", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblFutbol().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos, ojo ahi cuate",
                        "Error de insertar", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == view.getTblFutbol()) {
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblFutbol().getSelectedRow();
            Futbol tmp = modelo.getJugadorAtIndex(index);
            try {
                this.view.getImagenJugador().setIcon(tmp.getImagen());
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }
        }
        if (e.getSource() == this.view.getBtnActualizar()) {
            int rowIndex = this.view.getTblFutbol().getSelectedRow();
            Futbol tmp = modelo.getJugadorAtIndex(rowIndex);
            Futbol futbolito = new Futbol();
            futbolito.setJugador(this.view.getTxtJugador().getText());
            futbolito.setNumero(this.view.getTxtNumero().getText());
            futbolito.setSobrenombre(this.view.getTxtSobrenombre().getText());
            futbolito.setEquipo(this.view.getTxtEquipo().getText());
            futbolito.setPaisNacimiento(this.view.getTxtPaisNacimiento().getText());
            futbolito.setUrl(this.view.getTxtURL().getText());
            futbolito.setId(tmp.getId());
            if (modelo.actualizarInfo(futbolito)) {
                JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarDatos();
                this.view.getTblFutbol().setModel(modelo);
                this.view.getTblFutbol().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No carnal no se pudo actualizar", "Error al actializar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.getTblFutbol().updateUI();
        }
        if (e.getSource() == this.view.getBtnBorrar()){
            ModeloTabla temp = new ModeloTabla();
            int index = this.view.getTblFutbol().getSelectedRow();
            Futbol tmp = modelo.getJugadorAtIndex(index);

            if (temp.eliminarDatoa(Integer.toString(tmp.getId()))){
                JOptionPane.showMessageDialog(view,"Se elimino correctly MUTHER FUCKER", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarDatos();
                this.view.getTblFutbol().updateUI();
                this.view.limpiar();
            }else{
                JOptionPane.showMessageDialog(view, "No carnal no se borraron, acaso estas TONTO?", "Hijole mano se pueod lee abajo", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.view.limpiar();
    }
}

