package org.example.Vista;

import org.example.Modelo.Futbol;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaFutbol extends JFrame {
    private JLabel lblId;
    private JLabel lblJugador;
    private JLabel lblNumero;
    private JLabel lblSobrenombre;
    private JLabel lblEquipo;
    private JLabel lblPaisNacimiento;
    private JLabel lblURL;
    private JTextField txtId;
    private JTextField txtJugador;
    private JTextField txtNumero;
    private JTextField txtSobrenombre;
    private JTextField txtEquipo;
    private JTextField txtPaisNacimiento;
    private JTextField txtURL;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblFutbol;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel imagenJugador;
    private JButton btnBorrar;
    private JButton btnActualizar;



    public VentanaFutbol(String title) throws HeadlessException {
        super(title);
        this.setSize(1300,700);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setBackground(new Color(135, 192, 222));
        lblId = new JLabel("ID: ");
        lblJugador = new JLabel("Jugador: ");
        lblNumero = new JLabel("Numero: ");
        lblSobrenombre = new JLabel("Sobrenombre: ");
        lblEquipo = new JLabel("Equipo: ");
        lblPaisNacimiento = new JLabel("Pais de nacimiento: ");
        lblURL = new JLabel("Link (URL): ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtJugador = new JTextField(30);
        txtNumero = new JTextField(5);
        txtSobrenombre = new JTextField(55);
        txtEquipo = new JTextField(55);
        txtPaisNacimiento = new JTextField(55);
        txtURL = new JTextField(55);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblJugador);
        panel1.add(txtJugador);
        panel1.add(lblNumero);
        panel1.add(txtNumero);
        panel1.add(lblSobrenombre);
        panel1.add(txtSobrenombre);
        panel1.add(lblEquipo);
        panel1.add(txtEquipo);
        panel1.add(lblPaisNacimiento);
        panel1.add(txtPaisNacimiento);
        panel1.add(lblURL);
        panel1.add(txtURL);
        panel1.add(btnAgregar);

        //panel2
        panel2 = new JPanel(new FlowLayout(1));
        panel2.setBackground(new Color(86, 162, 211));
        btnCargar = new JButton("Mostrar base de datos");
        panel2.add(btnCargar);
        tblFutbol = new JTable();
        scroll = new JScrollPane(tblFutbol);
        panel2.add(scroll);


        //panel3
        panel3 = new JPanel(new FlowLayout(1));
        panel3.setBackground(new Color(34, 102, 224));
        imagenJugador = new JLabel("Aqui se arrojara la imagen de tu jugador");
        panel3.add(imagenJugador);

        //panel4
        panel4 = new JPanel(new FlowLayout(1));
        panel4.setBackground(new Color(101, 89, 211));
        btnBorrar = new JButton("Borrar");
        btnActualizar = new JButton("Acctualizar");
        panel4.add(btnBorrar);
        panel4.add(btnActualizar);




        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblJugador() {
        return lblJugador;
    }

    public void setLblJugador(JLabel lblJugador) {
        this.lblJugador = lblJugador;
    }

    public JLabel getLblNumero() {
        return lblNumero;
    }

    public void setLblNumero(JLabel lblNumero) {
        this.lblNumero = lblNumero;
    }

    public JLabel getLblSobrenombre() {
        return lblSobrenombre;
    }

    public void setLblSobrenombre(JLabel lblSobrenombre) {
        this.lblSobrenombre = lblSobrenombre;
    }

    public JLabel getLblEquipo() {
        return lblEquipo;
    }

    public void setLblEquipo(JLabel lblEquipo) {
        this.lblEquipo = lblEquipo;
    }

    public JLabel getLblPaisNacimiento() {
        return lblPaisNacimiento;
    }

    public void setLblPaisNacimiento(JLabel lblPaisNacimiento) {
        this.lblPaisNacimiento = lblPaisNacimiento;
    }

    public JLabel getLblURL() {
        return lblURL;
    }

    public void setLblURL(JLabel lblURL) {
        this.lblURL = lblURL;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtJugador() {
        return txtJugador;
    }

    public void setTxtJugador(JTextField txtJugador) {
        this.txtJugador = txtJugador;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(JTextField txtNumero) {
        this.txtNumero = txtNumero;
    }

    public JTextField getTxtSobrenombre() {
        return txtSobrenombre;
    }

    public void setTxtSobrenombre(JTextField txtSobrenombre) {
        this.txtSobrenombre = txtSobrenombre;
    }

    public JTextField getTxtEquipo() {
        return txtEquipo;
    }

    public void setTxtEquipo(JTextField txtEquipo) {
        this.txtEquipo = txtEquipo;
    }

    public JTextField getTxtPaisNacimiento() {
        return txtPaisNacimiento;
    }

    public void setTxtPaisNacimiento(JTextField txtPaisNacimiento) {
        this.txtPaisNacimiento = txtPaisNacimiento;
    }

    public JTextField getTxtURL() {
        return txtURL;
    }

    public void setTxtURL(JTextField txtURL) {
        this.txtURL = txtURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblFutbol() {
        return tblFutbol;
    }

    public void setTblFutbol(JTable tblFutbol) {
        this.tblFutbol = tblFutbol;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }
    public void limpiar(){
        txtJugador.setText("");
        txtNumero.setText("");
        txtSobrenombre.setText("");
        txtEquipo.setText("");
        txtPaisNacimiento.setText("");
        txtURL.setText("");
    }

    public JLabel getImagenJugador() {
        return imagenJugador;
    }

    public void setImagenJugador(JLabel imagenJugador) {
        this.imagenJugador = imagenJugador;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public void setBtnBorrar(JButton btnBorrar) {
        this.btnBorrar = btnBorrar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

}
