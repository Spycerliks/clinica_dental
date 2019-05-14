/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.naming.NamingException;
import modelo.Tratamiento;

/**
 *
 * @author matias
 */
public class TratamientoDAO {
    //Listar Tratamiento
    public ArrayList<Tratamiento> listarTratamiento() throws NamingException, SQLException{
        String sql = "SELECT * FROM tratamiento";
        ResultSet rs = Conexion.consulta(sql);
        ArrayList<Tratamiento> tratamientos = new ArrayList();
        Tratamiento t;
        while(rs.next()){
            t = new Tratamiento();
            t.setId_tratamiento(rs.getInt("id_tratamiento"));
            t.setNombre(rs.getString("nombre"));
            t.setCosto(rs.getInt("costo"));
            tratamientos.add(t);
        }
        return tratamientos;
    }
    
    public Tratamiento findById(int id) throws SQLException, NamingException{
        String sql = "SELECT * FROM tratamiento WHERE id_tratamiento = ?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, id);
        Tratamiento t = null;
        ResultSet rs = Conexion.consulta(sql, params);
        while(rs.next()){
            t = new Tratamiento();
            t.setId_tratamiento(rs.getInt("id_tratamiento"));
            t.setNombre(rs.getString("nombre"));
            t.setCosto(rs.getInt("costo"));
        }
        return t;
    }
}
