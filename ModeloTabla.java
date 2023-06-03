package org.example.Modelo;

import org.example.Persistencia.FutbolDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTabla implements TableModel {
    public static final int COLUMNS = 7;
    private ArrayList<Futbol> datos;
    private FutbolDAO futdao;

    public ModeloTabla() {
        futdao =new FutbolDAO();
        datos = new ArrayList<>();
    }

    public ModeloTabla(ArrayList<Futbol> datos) {
        this.datos = datos;
        futdao = new FutbolDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "jugador";
            case 2:
                return "numero";
            case 3:
                return "sobrenombre";
            case 4:
                return "equipo";
            case 5:
                return "paisnacimiento";
            case 6:
                return "url";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Futbol tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getJugador();
            case 2:
                return tmp.getNumero();
            case 3:
                return tmp.getSobrenombre();
            case 4:
                return tmp.getEquipo();
            case 5:
                return tmp.getPaisNacimiento();
            case 6:
                return tmp.getUrl();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setJugador((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setNumero((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setSobrenombre((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setEquipo((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setPaisNacimiento((String) aValue);
                break;
            case 6:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("no se agrego nada");
        }


    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos() {
        try {
            datos = futdao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarInfo(Futbol Fut) {
        boolean resultado = false;
        try {
            if (futdao.insertar(Fut)) {
                datos.add(Fut);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public Futbol getJugadorAtIndex(int idx){
        return  datos.get(idx);
    }
    public boolean actualizarInfo(Futbol futbolActualizar){
        boolean resultado = true;
        try{
            if (futdao.update(futbolActualizar)){
                datos.add(futbolActualizar);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean eliminarDatoa(String id){
        boolean resultado = false;
        try{
            if (futdao.delete(id)){
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
}
