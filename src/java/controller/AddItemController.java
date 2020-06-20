/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAO;
import dao.ItemDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.product.Item;

/**
 *
 * @author hieule
 */
@MultipartConfig(location="/tmp", fileSizeThreshold=1048576, maxFileSize=20848820, maxRequestSize=418018841)
@WebServlet(name = "AddItemController", urlPatterns = {"/add"})
public class AddItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("item-name");
        float price = Float.parseFloat(request.getParameter("item-price"));
        int quantity = Integer.parseInt(request.getParameter("item-quantity"));
        String description = request.getParameter("item-description");
        
        Part filePart=request.getPart("item-image");
        String filePath = filePart.getSubmittedFileName();
        Path p = Paths.get(filePath);
        String fileName = p.getFileName().toString();
        
        try (InputStream fileContent = filePart.getInputStream()) {
            OutputStream os = new FileOutputStream(getServletContext().getRealPath("/")+"imgs/"+fileName);
            byte[] data = new byte[1024];
            while(fileContent.read(data)>0) {
                os.write(data);
            }
            os.close();
        }
        Item item = new Item(name, price, quantity, "imgs/"+fileName, description);
        DAO dao = new ItemDAO();
        dao.add(item);
        
        HttpSession session=request.getSession();
        dao = new ItemDAO();
        Item[] items = (Item[]) dao.getAll();
        session.setAttribute("item", null);
        session.setAttribute("items", items);
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Added new item successfully');");
        out.println("location='item-management.jsp';");
        out.println("</script>");
//        response.sendRedirect(request.getContextPath()+"/item-management.jsp");
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
        processRequest(request, response);
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
