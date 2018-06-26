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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LN710Q
 */
public class filtroDAO implements metodos<alumno> {

    private static final String SQL_INSERT = "INSERT INTO alumnos(carnet,nombres,apellidos,universidad,edad,estado) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombres = ?, apellidos = ?,universidad =?, edad = ?, estado=? WHERE carnet=?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE carnet=?";
    private static final String SQL_READ = "SELECT * FROM alumnos WHERE carnet=?";
    private static final String SQL_READALL = "SELECT * FROM alumnos";
    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(alumno g) {
        PreparedStatement ps;
        try {
            ps = con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(1, g.getCarnet());
            ps.setString(2, g.getNombre());
            ps.setString(3, g.getApellidos());
            ps.setString(4, g.getUniversidad());
            ps.setInt(5, g.getEdad());
            ps.setBoolean(6, true);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(filtroDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println(c.getCarnet());
            ps = con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellidos());
            ps.setInt(3, c.getEdad());
            ps.setBoolean(4, c.isEstado());
            ps.setString(5, c.getUniversidad());
            ps.setString(6, c.getCarnet());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(filtroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public alumno read(Object key) {
        alumno f = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                f = new alumno(rs.getInt("id"), rs.getString("carnet"), rs.getString("nombres"), rs.getString("apellidos"), rs.getInt("edad"), rs.getString("universidad"), rs.getBoolean("estado"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(filtroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<alumno> readAll() {
        ArrayList<alumno> all = new ArrayList();
        Statement s;
        ResultSet rs;
        try {
            s = con.getCnx().prepareStatement(SQL_READALL);
            rs = s.executeQuery(SQL_READALL);
            while (rs.next()) {

                all.add(new alumno(rs.getInt("id"), rs.getString("carnet"), rs.getString("nombres"), rs.getString("apellidos"), rs.getInt("edad"), rs.getString("universidad"), rs.getBoolean("estado")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(filtroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

}
