/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.ces3.carritoCompras.controller;

import co.com.ces3.carritoCompras.DAO.cartsDAO;
import co.com.ces3.carritoCompras.DAO.productsDAO;
import co.com.ces3.carritoCompras.model.carts;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cristian
 */
public class cartsController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    protected void metGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String accion = request.getParameter("accion");
        if(accion.equals("listarCarrito")){
            cartsDAO dao = new cartsDAO();
            request.setAttribute("carritos", dao.consultarProductos(email));
            request.getRequestDispatcher("listaCarrito.jsp").forward(request, response);
        }else if(accion.equals("editarCarrito")){
            int id_cart = Integer.parseInt(request.getParameter("id_cart"));
            carts cart = new carts();
            cart.setId_cart(id_cart);
            cartsDAO dao = new cartsDAO();
            dao.modificarCarrito(cart);
            request.setAttribute("carritos", dao.consultarProductos(email));
            request.getRequestDispatcher("listaCarrito.jsp").forward(request, response);
        }else if(accion.equals("guardarCarrito")){
            carts cart = new carts();
            int id_product = Integer.parseInt(request.getParameter("id_product"));
            int price = Integer.parseInt(request.getParameter("price"));
            int total = Integer.parseInt(request.getParameter("total"));
            cart.setUser_email(email);
            cart.setId_product(id_product);
            cart.setPrice(price);
            cart.setTotal(total);
            
            cartsDAO dao = new cartsDAO();
            
            dao.crearCarrito(cart);
            
            productsDAO daoP = new productsDAO();
            request.setAttribute("productos", daoP.consultarProductos());
            request.getRequestDispatcher("listaProductos.jsp").forward(request, response);            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        metGet(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
