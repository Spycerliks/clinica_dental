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
import modelo.Paciente;

/**
 *
 * @author matias
 */
public class PacienteDAO {
    //Listar Paciente
    public ArrayList<Paciente> listarPaciente() throws SQLException, NamingException {
        ArrayList<Paciente> pacientes;
        String sql = "SELECT * FROM paciente";
        ResultSet rs = Conexion.consulta(sql);
        pacientes = this.rsToArrListPaciente(rs);
        return pacientes;
    }
    
    private ArrayList<Paciente> rsToArrListPaciente(ResultSet rs) throws SQLException {
        ArrayList<Paciente> pacientes = new ArrayList();
        Paciente aux;
        while (rs.next()) {
            aux = new Paciente();
            aux.setId_paciente(rs.getInt("id_paciente"));
            aux.setRut(rs.getString("rut"));
            aux.setNombre(rs.getString("nombre"));
            aux.setApellido(rs.getString("apellido"));
            aux.setDireccion(rs.getString("direccion"));
            aux.setTelefono(rs.getInt("telefono"));
            aux.setEmail(rs.getString("email"));
            pacientes.add(aux);
        }
        return pacientes;
    }
    
    public Paciente findById(int id) throws SQLException, NamingException{
        String sql = "SELECT * FROM paciente WHERE id_paciente=?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, id);
        ResultSet rs = Conexion.consulta(sql,params);
        if(rs.next())
            return rstoPac(rs);
        return null;
    }
    
    private ArrayList<Paciente> rsToArrL(ResultSet rs) throws SQLException, NamingException{
        EspecialidadDAO eDAO = new EspecialidadDAO();
        ArrayList<Paciente> dentistas = new ArrayList();
        Paciente aux;
        while(rs.next())
            dentistas.add(rstoPac(rs));
        return dentistas;
    }
    
    private Paciente rstoPac(ResultSet rs) throws SQLException, NamingException{
        Paciente aux;
        aux = new Paciente();
        aux.setId_paciente(rs.getInt("id_paciente"));
        aux.setRut(rs.getString("rut"));
        aux.setNombre(rs.getString("nombre"));
        aux.setApellido(rs.getString("apellido"));
        aux.setDireccion(rs.getString("direccion"));
        aux.setTelefono(rs.getInt("telefono"));
        aux.setEmail(rs.getString("email"));
        return aux;
    }
    
    //Insertar Paciente
    public void insertar(Paciente p) throws SQLException, NamingException {
        String sql = "INSERT INTO paciente (id_paciente, rut, nombre, apellido, direccion, telefono, email)";
        sql += "VALUES (?,?,?,?,?,?,?)";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, p.getId_paciente());
        parametros.put(2, p.getRut());
        parametros.put(3, p.getNombre());
        parametros.put(4, p.getApellido());
        parametros.put(5, p.getDireccion());
        parametros.put(6, p.getTelefono());
        parametros.put(7, p.getEmail());
        Conexion.insertar(sql, parametros);
    }
    
    //Actualizar Paciente
    public int actualizar(Paciente p) throws SQLException, NamingException {
        String sql = "UPDATE paciente SET rut=?, nombre=?, apellido=?, direccion=?, telefono=?, email=? WHERE id_paciente=?";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, p.getRut());
        parametros.put(2, p.getNombre());
        parametros.put(3, p.getApellido());
        parametros.put(4, p.getDireccion());
        parametros.put(5, p.getTelefono());
        parametros.put(6, p.getEmail());
        parametros.put(7, p.getId_paciente());
        return Conexion.actualizar(sql, parametros);
    }
    
    //Eliminar Paciente
    public void eliminar(int id) throws SQLException, NamingException {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, id);
        Conexion.eliminar(sql, parametros);
    }
}
