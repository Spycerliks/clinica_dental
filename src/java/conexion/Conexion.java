/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author matiasbarrenechea
 */
public class Conexion {
    private final static String NOMBRE_DS = "__ClinicaDental";
    private static PreparedStatement pStatement;

    private Conexion() {

    }

    //Insertar
    public static Integer insertar(String insertQuery, HashMap<Integer, Object> parametros) throws SQLException, NamingException {
        return (Integer) query(insertQuery, parametros, true);
    }

    public static Integer insertar(String insertQuery) throws SQLException, NamingException {
        return insertar(insertQuery, null);
    }

    //Consultar
    public static ResultSet consulta(String insertQuery, HashMap<Integer, Object> parametros) throws SQLException, NamingException {
        return (ResultSet) query(insertQuery, parametros, false);
    }

    public static ResultSet consulta(String insertQuery) throws SQLException, NamingException {
        return consulta(insertQuery, null);
    }
    
    //Eliminar
    public static Integer eliminar(String insertQuery, HashMap<Integer, Object> parametros) throws SQLException, NamingException {
        return (Integer) query(insertQuery, parametros, true);
    }
    
    public static Integer eliminar(String insertQuery) throws SQLException, NamingException {
        return eliminar(insertQuery, null);
    }
    
    //Actualizar
    public static Integer actualizar(String insertQuery, HashMap<Integer, Object> parametros) throws SQLException, NamingException {
        return (Integer) query(insertQuery, parametros, true);
    }

    public static Integer actualizar(String insertQuery) throws SQLException, NamingException {
        return actualizar(insertQuery, null);
    }

    //Seteador
    private static PreparedStatement seteador(PreparedStatement sentencia, HashMap<Integer, Object> parametros) throws SQLException {
        for (Map.Entry<Integer, Object> parametro : parametros.entrySet()) {
            if (parametro.getValue() instanceof String) {
                sentencia.setString(parametro.getKey(), parametro.getValue().toString());
            }
            if (parametro.getValue() instanceof Integer) {
                sentencia.setInt(parametro.getKey(), (Integer) parametro.getValue());
            }
            if (parametro.getValue() instanceof Float) {
                sentencia.setFloat(parametro.getKey(), (Float) parametro.getValue());
            }
            if (parametro.getValue() instanceof Date) {
                sentencia.setDate(parametro.getKey(), new java.sql.Date(((Date) (parametro.getValue())).getTime()));
            }
        }
        return sentencia;
    }

    //Conexión
    private static Object query(String query, HashMap<Integer, Object> parametros, boolean insertar) throws SQLException, NamingException {
        Context initContext = new InitialContext();
        DataSource ds = (DataSource) initContext.lookup(NOMBRE_DS);
        try (Connection conn = ds.getConnection()) {
            pStatement = conn.prepareStatement(query);
            if (parametros != null) {
                seteador(pStatement, parametros);
            }
            if (insertar) {
                return pStatement.executeUpdate();
            } else {
                return pStatement.executeQuery();
            }
        } catch (Exception e) {

        }
        return null;
    }
}
