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
import model.employee.Employee;
import model.Role;
import model.employee.Account;
import model.employee.FullName;

/**
 *
 * @author hieule
 */
public class EmployeeDAO implements DAO<Employee>{
    @Override
    public Employee get(String username) {
        Connection conn = DbConnection.getInstance().getConnection();
        String sql1 = "SELECT * FROM person WHERE username = ?";
        String sql = "SELECT account.Username as username, account.Password as password, employee.Role, fullname.firstname as firstname, fullname.middlename as middlename, fullname.lastname as lastname"+
                " FROM ((employee INNER JOIN account ON employee.AccountID = account.ID)"+
                " INNER JOIN fullname ON employee.FullNameID = fullname.ID)"+
                " WHERE account.username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {                
                int int_role = rs.getInt("Role");
                Role role = Role.CUSTOMER;
                for (Role r : Role.values()) {
                    if(r.getValue() == int_role) {
                        role = r;
                        break;
                    }
                }
                Account account = new Account(rs.getString("username"), rs.getString("password"));
                FullName fullName = new FullName(rs.getString("firstname"), rs.getString("middlename"), rs.getString("lastname"));
                Employee person = new Employee(account, fullName, null, role);
                return person;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        DbConnection.getInstance().closeConnection(conn);
        return null;
    }
    
    public static void main(String[] args) {
        DAO dao = new EmployeeDAO();
        Employee employee = (Employee) dao.get("hieulc");
        System.out.println(employee);
        System.out.println(employee.getRole()==Role.STAFF);
        System.out.println(employee.getFullName());
        System.out.println(employee.getAccount().getPassword());
    }

//    @Override
//    public Employee get(int id) {
//        Connection conn = DbConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM person WHERE id = ?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            
//            if(rs.next()) {                
//                String str_role = rs.getString("_role");
//                Role role = Role.CUSTOMER;
//                for (Role r : Role.values()) {
//                    if(str_role.equals(r.name())) {
//                        role = r;
//                        break;
//                    }
//                }
//                Employee person = new Employee(
//                        rs.getInt("id"), 
//                        rs.getString("_name"),
//                        rs.getString("username"),
//                        rs.getString("password"),
//                        rs.getString("address"), 
//                        rs.getString("phone"),
//                        rs.getString("email"),
//                        role
//                );
//                return person;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DbConnection.getInstance().closeConnection(conn);
//        return null;
//    }
//
//    @Override
//    public void add(Employee person) {
//        String sql = "INSERT INTO person(_name, username, password, address, phone, email, _role)"+
//                " VALUES(?, ?, ?, ?, ?, ?, ?)";
//        Connection conn = DbConnection.getInstance().getConnection();
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, person.getName());
//            ps.setString(2, person.getUsername());
//            ps.setString(3, person.getPassword());
//            ps.setString(4, person.getAddress());
//            ps.setString(5, person.getPhone());
//            ps.setString(6, person.getEmail());
//            ps.setString(7, person.getRole().name());
//            
//            ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DbConnection.getInstance().closeConnection(conn);
//    }
//
//    @Override
//    public void update(Employee person) {
//        String sql = "Update person"+
//                " SET _name = ?, username = ?, password = ?, address = ?, phone = ?, email = ?, _role = ?"+
//                " WHERE id = ?";
//        
//        Connection conn = DbConnection.getInstance().getConnection();
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, person.getName());
//            ps.setString(2, person.getUsername());
//            ps.setString(3, person.getPassword());
//            ps.setString(4, person.getAddress());
//            ps.setString(5, person.getPhone());
//            ps.setString(6, person.getEmail());
//            ps.setString(7, person.getRole().name());
//            ps.setInt(8, person.getId());
//            
//            ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DbConnection.getInstance().closeConnection(conn);
//    }
//
//    @Override
//    public void remove(Employee person) {
//        String sql = "DELETE FROM person"+
//                " WHERE id = ?";
//        Connection conn = DbConnection.getInstance().getConnection();
//        
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, person.getId());
//            
//            ps.execute();
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        DbConnection.getInstance().closeConnection(conn);
//    }
//
//    @Override
//    public boolean contain(Employee person) {
//        return false;
//    }
// 
////    public static void main(String[] args) {
////        for(Role role : Role.values()) {
////            System.out.println(role.name());
////        }
////        
////        Person person = new Person("Le Cong Hieu", "hieulc", "123", "123 Dia city", "123123123", "hieulc@gmail.com", Role.SALESREP);
////        DAO dao = new UserDAO();
////        dao.add(person);
////    }
//
//    @Override
//    public Employee[] getAll() {
//        return null;
//    }
//
//    @Override
//    public Employee[] getAllNameLike(String name) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Employee[] getAllNameLike(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee[] getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contain(Employee t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
