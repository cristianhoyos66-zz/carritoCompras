/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ces3.carritoCompras.DAO;

import co.com.ces3.carritoCompras.model.productos;
import co.com.ces3.carritoCompras.util.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class productsDAO {
    private Connection con;
    public productsDAO(){
        conexion c = new conexion();
        con = c.getConnection();
    }
    
     public List<productos> consultarProductos(){
        List<productos> productos = new ArrayList<productos>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement("SELECT * FROM products");
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                productos Productos = new productos();
                Productos.setProduct_id(rs.getInt("product_id"));
                Productos.setProduct_code(rs.getString("product_code"));
                Productos.setProduct_name(rs.getString("product_name"));
                Productos.setPrice(rs.getInt("price"));
                productos.add(Productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(productsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return productos;
    } 
    
}
