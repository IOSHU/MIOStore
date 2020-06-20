/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.product.Item;

/**
 *
 * @author hieule
 */
public class ItemDAO implements DAO<Item> {
    @Override
    public Item get(int id) {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Item item = new Item(
                        rs.getInt("id"), 
                        rs.getString("Name"),
                        rs.getFloat("SellingPrice"), 
                        rs.getInt("Quantity"), 
                        rs.getString("image_path"),
                        rs.getString("description")
                );
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return null;
    }

    @Override
    public void add(Item t) {
        String sql = "INSERT INTO item(Name, SellingPrice, Quantity, image_path, description)"+
                " VALUES(?, ?, ?, ?, ?)";
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setFloat(2, t.getPrice());
            ps.setInt(3, t.getQuantity());
            ps.setString(4, t.getImagePath());
            ps.setString(5, t.getDescription());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public void update(Item t) {
        String sql = "Update item"+
                " SET Name = ?, SellingPrice = ?, Quantity = ?, image_path = ?, description = ?"+
                " WHERE id = ?";
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getName());
            ps.setFloat(2, t.getPrice());
            ps.setInt(3, t.getQuantity());
            ps.setString(4, t.getImagePath());
            ps.setString(5, t.getDescription());
            ps.setInt(6, t.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public void remove(Item t) {
        String sql = "DELETE FROM item"+
                " WHERE id = ?";
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public boolean contain(Item t) {
        return false;
    }
    
//    public static void main(String[] args) {
//        DAO dao = new ItemDAO();
////        Item item = (Item) dao.get(12);
////        System.out.println(item);
//        Item[] items = (Item[]) dao.getAll();
//        for(Item item : items)
//            System.out.println(item);
////        for(int i = 0; i < 10; i++) {
////            Item item = new Item("phone"+i, (float)112.2+10*i, i+4, "/hlc/home/img"+i, "not good enough"+i);
////            dao.add(item);
////        }
//    }

    @Override
    public Item get(String name) {
        return null;
    }

    @Override
    public Item[] getAll() {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item";
        List<Item> listItem = new ArrayList<>();
        Item[] items = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"), 
                        rs.getString("Name"),
                        rs.getFloat("SellingPrice"), 
                        rs.getInt("Quantity"), 
                        rs.getString("image_path"),
                        rs.getString("description")
                );
                listItem.add(item);
            }
            items = new Item[listItem.size()];
            int i = 0;
            for(Item item : listItem) {
                items[i] = item;
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return items;
    }

    @Override
    public Item[] getAllNameLike(String name) {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE Name LIKE '%"+name+"%'";
        List<Item> listItem = new ArrayList<>();
        Item[] items = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"), 
                        rs.getString("Name"),
                        rs.getFloat("SellingPrice"), 
                        rs.getInt("Quantity"), 
                        rs.getString("image_path"),
                        rs.getString("description")
                );
                listItem.add(item);
            }
            items = new Item[listItem.size()];
            int i = 0;
            for(Item item : listItem) {
                items[i] = item;
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return items;
    }
}
