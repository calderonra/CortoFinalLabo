/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiltroDAO;

import Modelo.alumno;
import conexion.Conexion;
import interfaz.metodos;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public class filtroDAO implements metodos<alumno> {

    private static final String SQL_INSERT = " INSERT INTO alumno(id,carnet,nombres,apellidos,edad,universidad,estado) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumno SET carnet=?,nombres=?,apellidos=?,edad=?,universidad=?,estado=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE id=?";
    private static final String SQL_READ = "SELECT * FROM alumno WHERE id=?";
    private static final String SQL_READALL = "SELECT * FROM alumno";
    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(alumno g) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setInt(1, g.getId());
            ps.setInt(2, g.getCarnet());
            ps.setString(3, g.getNombre());
            ps.setString(4, g.getApellidos());
            ps.setInt(5, g.getEdad());
            ps.setString(6, g.getUniversidad());
            ps.setBoolean(7, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("no furulo");
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("rip delete");
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(alumno c) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getCarnet());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getApellidos());
            ps.setInt(5, c.getEdad());
            ps.setString(6, c.getUniversidad());
            ps.setBoolean(7, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("no furulo");
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public alumno read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<alumno> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
