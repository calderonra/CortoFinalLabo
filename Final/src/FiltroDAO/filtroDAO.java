/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiltroDAO;

import Modelo.alumno;
import conexion.Conexion;
import interfaz.metodos;
import java.util.ArrayList;

/**
 *
 * @author LN710Q
 */
public class filtroDAO implements metodos<alumno> {
private static final String SQL_INSERT =" INSERT INTO alumno(codFiltro,marca,stock,existencia) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE ="UPDATE alumno SET marca=?,stock=?,existencia=? WHERE codFiltro=?";
    private static final String SQL_DELETE ="DELETE FROM alumno WHERE codFiltro=?";
    private static final String SQL_READ ="SELECT * FROM alumno WHERE codFiltro=?";
    private static final String SQL_READALL ="SELECT * FROM alumno";
    private static final Conexion con=Conexion.conectar();
    
    @Override
    public boolean create(alumno g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(alumno c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
