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
import modelo.Especialidad;

/**
 *
 * @author matias
 */
public class EspecialidadDAO {
    //Listar Especialidad
    public ArrayList<Especialidad> listarEspecialidad() throws NamingException, SQLException{
        String sql = "SELECT * FROM especialidad";
        ResultSet rs = Conexion.consulta(sql);
        ArrayList<Especialidad> especialidades = new ArrayList();
        Especialidad e;
        while(rs.next()){
            e = new Especialidad();
            e.setId_especialidad(rs.getInt("id_especialidad"));
            e.setNombre(rs.getString("nombre"));
            especialidades.add(e);
        }
        return especialidades;
    }
    
    public Especialidad findById(int id) throws SQLException, NamingException{
        String sql = "SELECT * FROM especialidad WHERE id_especialidad = ?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, id);
        Especialidad e = null;
        ResultSet rs = Conexion.consulta(sql, params);
        while(rs.next()){
            e = new Especialidad();
            e.setId_especialidad(rs.getInt("id_especialidad"));
            e.setNombre(rs.getString("nombre"));
        }
        return e;
    }
}
