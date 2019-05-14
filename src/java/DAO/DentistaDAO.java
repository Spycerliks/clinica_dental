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
import modelo.Dentista;

/**
 *
 * @author matias
 */
public class DentistaDAO {
    //Listar Dentista
    public ArrayList<Dentista> listarDentista() throws SQLException, NamingException{
        String sql = "SELECT * FROM dentista";
        ResultSet rs = Conexion.consulta(sql);
        return rsToArrL(rs);
    }
    
    public Dentista findById(int id) throws SQLException, NamingException{
        String sql = "SELECT * FROM dentista WHERE id_dentista=?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, id);
        ResultSet rs = Conexion.consulta(sql,params);
        if(rs.next())
            return rstoEsp(rs);
        return null;
    }
    
    private ArrayList<Dentista> rsToArrL(ResultSet rs) throws SQLException, NamingException{
        EspecialidadDAO eDAO = new EspecialidadDAO();
        ArrayList<Dentista> dentistas = new ArrayList();
        Dentista aux;
        while(rs.next())
            dentistas.add(rstoEsp(rs));
        return dentistas;
    }
    
    private Dentista rstoEsp(ResultSet rs) throws SQLException, NamingException{
        int especialidad;
        Dentista aux;
        EspecialidadDAO eDAO = new EspecialidadDAO();
        aux = new Dentista();
        aux.setId_dentista(rs.getInt("id_dentista"));
        aux.setNombre(rs.getString("nombre"));
        aux.setApellido(rs.getString("apellido"));
        especialidad = rs.getInt("especialidad");
        aux.setEspecialidad(eDAO.findById(especialidad));
        return aux;
    }
    
    //Insertar dentista
    public int insertar(Dentista d) throws SQLException, NamingException{
        String sql = "INSERT INTO dentista (id_dentista, nombre, apellido, especialidad) ";
        sql+=" VALUES (?,?,?,?)";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, d.getId_dentista());
        params.put(2, d.getNombre());
        params.put(3, d.getApellido());
        params.put(4, d.getEspecialidad().getId_especialidad());
        return Conexion.insertar(sql, params);
    }
    
    //Eliminar dentista
    public void eliminar(int id) throws SQLException, NamingException {
        String sql = "DELETE FROM dentista WHERE id_dentista=?";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, id);
        Conexion.eliminar(sql, parametros);
    }
}
