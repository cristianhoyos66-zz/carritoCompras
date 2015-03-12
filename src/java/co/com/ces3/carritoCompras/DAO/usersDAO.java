/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ces3.carritoCompras.DAO;

import co.com.ces3.carritoCompras.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class usersDAO {
    private Connection con;
    
    public usersDAO(){
        conexion c = new conexion();
        con = c.getConnection();
    }
    
    public boolean consultarUsuario(String email, String pass){
        boolean flag = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
               if(rs.getString("email").equals(email) && rs.getString("password").equals(pass)){
                   flag = true;
               }
            };
        } catch (SQLException ex) {
            Logger.getLogger(usersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
}
