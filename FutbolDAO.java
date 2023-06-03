package org.example.Persistencia;

import org.example.Modelo.Futbol;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FutbolDAO implements IntefazDAO {
    public FutbolDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO futbol (jugador, numero, sobrenombre, equipo, paisnacimiento, url) VALUES (?,?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("futbolDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Futbol) obj).getJugador());
        pstm.setString(2, ((Futbol) obj).getNumero());
        pstm.setString(3, ((Futbol) obj).getSobrenombre());
        pstm.setString(4, ((Futbol) obj).getEquipo());
        pstm.setString(5, ((Futbol) obj).getPaisNacimiento());
        pstm.setString(6, ((Futbol) obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public boolean update(Object obj) throws SQLException {
        {
            String sqlUpdate = "UPDATE futbol SET jugador = ?, numero = ?, sobrenombre = ?, equipo = ?, paisnacimiento = ?, url = ? WHERE id = ? ; ";
            int rowCount = 0;
            PreparedStatement pstm = ConexionSingleton.get_instance("futbolDB.db").getConnection().prepareStatement(sqlUpdate);
            pstm.setString(1, ((Futbol) obj).getJugador());
            pstm.setString(2, ((Futbol) obj).getNumero());
            pstm.setString(3, ((Futbol) obj).getSobrenombre());
            pstm.setString(4, ((Futbol) obj).getEquipo());
            pstm.setString(5, ((Futbol) obj).getPaisNacimiento());
            pstm.setString(6, ((Futbol) obj).getUrl());
            pstm.setInt(7, ((Futbol) obj).getId());
            rowCount = pstm.executeUpdate();
            return rowCount > 0;
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM futbol WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("futbolDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;

    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM futbol ;";
        ArrayList<Futbol> resultado = new ArrayList<>();
        Statement stn = ConexionSingleton.get_instance("futbolDB.db").getConnection().createStatement();
        ResultSet rst = stn.executeQuery(sql);
        while(rst.next()){
            resultado.add((new Futbol(rst.getInt(1),rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6), rst.getString(7))));

        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "Select * FROM futbol WHERE id = ? ; ";
        Futbol futbol = null;
        PreparedStatement pstm = ConexionSingleton.get_instance("futbolDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            futbol = new Futbol(rst.getInt(1),rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6), rst.getString(7));
            return  futbol;

        }
        return null;
    }
}
