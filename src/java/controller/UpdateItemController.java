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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.product.Item;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author hieule
 */
@MultipartConfig(location="/tmp", fileSizeThreshold=1048576, maxFileSize=20848820, maxRequestSize=418018841)
@WebServlet(name = "UpdateItemController", urlPatterns = {"/update"})
public class UpdateItemController extends HttpServlet {

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
        System.out.println(request.getParameter("item-name")+" "+request.getParameter("item-price"));
        String str_id = request.getParameter("item-id");
        System.out.println(request.getSession().getAttribute("item"));
        System.out.println("********************************************");
        System.out.println(str_id);
        int id = -1;
        if(str_id != null && !"".equals(str_id)) 
            id = Integer.parseInt(str_id);
        
        if (id == -1) {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Updated/Deleted item fail');");
            out.println("location='home.jsp';");
            out.println("</script>");
        }
        
        DAO dao = new ItemDAO();
        Item item = (Item) dao.get(id);
        
        String act = request.getParameter("act");
        if(null == act) {
            //nothing choose
            return;
        } else 
            switch (act) {
            case "Delete":
                HttpSession session=request.getSession();
                session.setAttribute("item", item);
                response.sendRedirect(request.getContextPath()+"/confirm-delete-item.jsp");
                return;
            case "Update":
                break;
            default:
                return;
        }

        String name = request.getParameter("item-name");
        if(name != null && !"".equals(name))
            item.setName(name);
        
        String str_price = request.getParameter("item-price");
        float price = -1;
        if(str_price != null && !"".equals(str_price)) {
            price = Float.parseFloat(str_price);
            item.setPrice(price);
        }
        
        String str_quantity = request.getParameter("item-quantity");
        int quantity = -1;
        if(str_quantity != null && !"".equals(str_quantity)){
            quantity = Integer.parseInt(str_quantity);
            item.setQuantity(quantity);
        }
        
        String description = request.getParameter("item-description");
        if(description != null && !"".equals(description))
            item.setDescription(description);
        
        Part filePart=request.getPart("item-image"); 
        if(filePart != null) {
            String filePath = filePart.getSubmittedFileName();
            Path p = Paths.get(filePath);
            String fileName = p.getFileName().toString();
            System.out.println(fileName+"---------------------------------");
            if(fileName != null && !"".equals(fileName))
                try (InputStream fileContent = filePart.getInputStream(); OutputStream os = new FileOutputStream(getServletContext().getRealPath("/")+"imgs/"+fileName)) {
                    byte[] data = new byte[1024];
                    while(fileContent.read(data)>0) {
                        os.write(data);
                    }
                    item.setImagePath("imgs/"+fileName);
                }   
        }

        dao.update(item);
        
        HttpSession session=request.getSession();
        dao = new ItemDAO();
        Item[] items = (Item[]) dao.getAll();
        session.setAttribute("item", null);
        session.setAttribute("items", items);
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Updated item successfully');");
        out.println("location='item-management.jsp';");
        out.println("</script>");
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
