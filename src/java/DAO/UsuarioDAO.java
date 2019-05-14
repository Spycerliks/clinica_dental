/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import modelo.Usuario;
import conexion.Conexion;

/**
 *
 * @author matias
 */
public class UsuarioDAO {
    public Usuario login(String usuario, String contraseña) throws SQLException, NamingException {
        Usuario u = null;
        String sql = "SELECT * FROM usuario WHERE usuario=? AND contraseña=?";
        HashMap<Integer, Object> parametros = new HashMap();
        parametros.put(1, usuario);
        parametros.put(2, contraseña);
        ResultSet rs = Conexion.consulta(sql, parametros);

        if (rs.next()) {
            u = new Usuario();
            u.setId_usuario(rs.getInt("id_usuario"));
            u.setNombre(rs.getString("nombre"));
            u.setUsuario(rs.getString("usuario"));
            u.setContraseña(rs.getString("contraseña"));
        }
        return u;
    }
}
