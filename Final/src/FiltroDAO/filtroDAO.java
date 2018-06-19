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

/**
 *
 * @author LN710Q
 */
public class filtroDAO implements metodos<alumno> {

    private static final String SQL_INSERT = " INSERT INTO alumnos(id,carnet,nombres,apellidos,edad,universidad,estado) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET carnet=?,nombres=?,apellidos=?,edad=?,universidad=?,estado=? WHERE id=?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE id=?";
    private static final String SQL_READ = "SELECT * FROM alumnos WHERE id=?";
    private static final String SQL_READALL = "SELECT * FROM alumnos";
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
            ps.setInt(1, c.getCarnet());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setInt(4, c.getEdad());
            ps.setString(5, c.getUniversidad());
            ps.setBoolean(6, c.isEstado());
            ps.setInt(7, c.getCarnet());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("no furulo update");
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public alumno read(Object key) {
        alumno a = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.getCnx().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                a = new alumno(rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7),rs.getBoolean(8));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        } finally{
            con.cerrarConexion();
        }
        return a;
    }

    @Override
    public ArrayList<alumno> readAll() {
       ArrayList<alumno> all = new ArrayList();
        Statement s;
        ResultSet rs;
         try{
           s=con.getCnx().prepareStatement(SQL_READALL);
           rs=s.executeQuery(SQL_READALL);
           while(rs.next()){
               all.add(new alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getBoolean(6)));
           }
            rs.close();
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
           System.out.println("rip read all");
       }finally{
           
           con.cerrarConexion();
       }
         return all;
    }

}
