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
import modelo.Atencion;

/**
 *
 * @author matias
 */
public class AtencionDAO {
    //Listar Atención
    public ArrayList<Atencion> listarAtencion() throws SQLException, NamingException{
        String sql = "SELECT * FROM atencion";
        ResultSet rs = Conexion.consulta(sql);
        return rsToArrL(rs);
    }
    
    public Atencion findById(int id) throws SQLException, NamingException{
        String sql = "SELECT * FROM atencion WHERE id_atencion=?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, id);
        ResultSet rs = Conexion.consulta(sql,params);
        if(rs.next())
            return rstoAte(rs);
        return null;
    }
    
    private ArrayList<Atencion> rsToArrL(ResultSet rs) throws SQLException, NamingException{
        PacienteDAO pDAO = new PacienteDAO();
        DentistaDAO dDAO = new DentistaDAO();
        TratamientoDAO tDAO = new TratamientoDAO();
        ArrayList<Atencion> atenciones = new ArrayList();
        Atencion aux;
        while(rs.next())
            atenciones.add(rstoAte(rs));
        return atenciones;
    }
    
    private Atencion rstoAte(ResultSet rs) throws SQLException, NamingException{
        int paciente, dentista, tratamiento;
        Atencion aux;
        PacienteDAO pDAO = new PacienteDAO();
        DentistaDAO dDAO = new DentistaDAO();
        TratamientoDAO tDAO = new TratamientoDAO();
        
        aux = new Atencion();
        aux.setId_atencion(rs.getInt("id_atencion"));
        aux.setFecha_registro(rs.getTimestamp("fecha_registro"));
        aux.setDia(rs.getInt("dia"));
        aux.setMes(rs.getInt("mes"));
        aux.setAnio(rs.getInt("anio"));
        paciente = rs.getInt("paciente");
        aux.setPaciente(pDAO.findById(paciente));
        dentista = rs.getInt("dentista");
        aux.setDentista(dDAO.findById(dentista));
        tratamiento = rs.getInt("tratamiento");
        aux.setTratamiento(tDAO.findById(tratamiento));
        aux.setDescripcion(rs.getString("descripcion"));
        return aux;
    }
    
    //Insertar Atención
    public void insertar(Atencion a) throws SQLException, NamingException {
        String sql = "INSERT INTO atencion (id_atencion, dia, mes, anio, paciente, dentista, tratamiento, descripcion)";
        sql += "VALUES (?,?,?,?,?,?,?,?)";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, a.getId_atencion());
        parametros.put(2, a.getDia());
        parametros.put(3, a.getMes());
        parametros.put(4, a.getAnio());
        parametros.put(5, a.getPaciente().getId_paciente());
        parametros.put(6, a.getDentista().getId_dentista());
        parametros.put(7, a.getTratamiento().getId_tratamiento());
        parametros.put(8, a.getDescripcion());
        Conexion.insertar(sql, parametros);
    }
    
    //Actualizar Atención
    public int actualizar(Atencion a) throws SQLException, NamingException{
        String sql = "UPDATE atencion SET dia=?, mes=?, anio=?, paciente=?, dentista=?, tratamiento=?, descripcion=? WHERE id_atencion=?";
        HashMap<Integer,Object> params = new HashMap();
        params.put(1, a.getDia());
        params.put(2, a.getMes());
        params.put(3, a.getAnio());
        params.put(4, a.getPaciente().getId_paciente());
        params.put(5, a.getDentista().getId_dentista());
        params.put(6, a.getTratamiento().getId_tratamiento());
        params.put(7, a.getDescripcion());
        params.put(8, a.getId_atencion());
        return Conexion.actualizar(sql, params);
    }
    
    //Eliminar Atención
    public void eliminar(int id) throws SQLException, NamingException {
        String sql = "DELETE FROM atencion WHERE id_atencion=?";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, id);
        Conexion.eliminar(sql, parametros);
    }
}
