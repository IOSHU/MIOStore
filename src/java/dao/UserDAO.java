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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;
import model.Role;

/**
 *
 * @author hieule
 */
public class UserDAO implements DAO<Person>{
    @Override
    public Person get(String username) {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM person WHERE username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {                
                String str_role = rs.getString("_role");
                Role role = Role.CUSTOMER;
                for (Role r : Role.values()) {
                    if(str_role.equals(r.name())) {
                        role = r;
                        break;
                    }
                }
                Person person = new Person(
                        rs.getInt("id"), 
                        rs.getString("_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("address"), 
                        rs.getString("phone"),
                        rs.getString("email"),
                        role
                );
                return person;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return null;
    }

    @Override
    public Person get(int id) {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql = "SELECT * FROM person WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {                
                String str_role = rs.getString("_role");
                Role role = Role.CUSTOMER;
                for (Role r : Role.values()) {
                    if(str_role.equals(r.name())) {
                        role = r;
                        break;
                    }
                }
                Person person = new Person(
                        rs.getInt("id"), 
                        rs.getString("_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("address"), 
                        rs.getString("phone"),
                        rs.getString("email"),
                        role
                );
                return person;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return null;
    }

    @Override
    public void add(Person person) {
        String sql = "INSERT INTO person(_name, username, password, address, phone, email, _role)"+
                " VALUES(?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getUsername());
            ps.setString(3, person.getPassword());
            ps.setString(4, person.getAddress());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getEmail());
            ps.setString(7, person.getRole().name());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public void update(Person person) {
        String sql = "Update person"+
                " SET _name = ?, username = ?, password = ?, address = ?, phone = ?, email = ?, _role = ?"+
                " WHERE id = ?";
        
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getUsername());
            ps.setString(3, person.getPassword());
            ps.setString(4, person.getAddress());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getEmail());
            ps.setString(7, person.getRole().name());
            ps.setInt(8, person.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public void remove(Person person) {
        String sql = "DELETE FROM person"+
                " WHERE id = ?";
        Connection conn = DbConnection.getInstance().getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, person.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
    }

    @Override
    public boolean contain(Person person) {
        return false;
    }
 
//    public static void main(String[] args) {
//        for(Role role : Role.values()) {
//            System.out.println(role.name());
//        }
//        
//        Person person = new Person("Le Cong Hieu", "hieulc", "123", "123 Dia city", "123123123", "hieulc@gmail.com", Role.SALESREP);
//        DAO dao = new UserDAO();
//        dao.add(person);
//    }

    @Override
    public Person[] getAll() {
        return null;
    }

    @Override
    public Person[] getAllNameLike(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
