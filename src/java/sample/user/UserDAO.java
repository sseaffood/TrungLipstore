/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DButils;
import sample.user.UserDTO;
/**
 *
 * @author hd
 */
public class UserDAO {
    private static final String LOGIN = "SELECT fullName, roleID, phone, address FROM tblUsers WHERE userID = ? AND password = ?";
    private static final String SEARCH="SELECT userID, fullName, roleID, phone, address FROM tblUsers WHERE fullName like ?";
    private static final String UPDATE="UPDATE tblUsers SET fullName=?, roleID=?, phone=?, address=? WHERE userID=?";
    private static final String DELETE="DELETE FROM tblUsers WHERE userID=?";
    private static final String DUPLICATE="SELECT userID FROM tblUsers WHERE userID=?";
    private static final String INSERT = "INSERT INTO tblUsers(userID, fullName, password, roleID, phone, address, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String CHECK="Select fullName, roleID from tblUsers where userId='admin'";
    
    public UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user= null;
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DButils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs= ptm.executeQuery();
                if(rs.next()){
                     String fullName = rs.getString("fullName");
                String roleID = rs.getString("roleID");
                user = new UserDTO(null, fullName, roleID, null, null, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> listUser= new ArrayList<>();
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
            conn= DButils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs= ptm.executeQuery();
                while(rs.next()){
                    String userID= rs.getString("userID");
                    String fullName= rs.getString("fullName");
                    String roleID= rs.getString("roleID");
                    String password= "***";
                    String phone= rs.getString("phone");
                    String address= rs.getString("address");
                    listUser.add(new UserDTO(userID, fullName, roleID, password, phone, address));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return listUser;
    }

    public boolean update(UserDTO user) throws SQLException {
        boolean check= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DButils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getPhone());
                ptm.setString(4, user.getAddress());
                ptm.setString(5, user.getUserID());
                check= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return check;
    }
    public boolean delete(String userID) throws SQLException {
        boolean check= false;
        Connection conn= null;
        PreparedStatement ptm= null;
        try {
            conn= DButils.getConnection();
            if(conn!= null){
                ptm= conn.prepareStatement(DELETE);
                ptm.setString(1, userID );
                check= ptm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return check;
    }
    public boolean checkDuplicate(String userID) throws SQLException {
    boolean check = false;
    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;

    try {
        conn = DButils.getConnection();
        if (conn != null) {
            ptm = conn.prepareStatement(DUPLICATE);
            ptm.setString(1, userID);
            rs = ptm.executeQuery();
            if (rs.next()) {
                check = true;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) rs.close();
        if (ptm != null) ptm.close();
        if (conn != null) conn.close();
    }

    return check;
}
    public boolean insert(UserDTO user) throws SQLException {
    boolean check = false;
    Connection conn = null;
    PreparedStatement ptm = null;
    try {
        conn = DButils.getConnection();
        if (conn != null) {
            ptm = conn.prepareStatement(INSERT);
            ptm.setString(1, user.getUserID());
            ptm.setString(2, user.getFullName());
            ptm.setString(3, user.getPassword());
            ptm.setString(4, user.getRoleID());   
            ptm.setString(5, user.getPhone());
            ptm.setString(6, user.getAddress());
            ptm.setInt(7, 1); 

            check = ptm.executeUpdate() > 0 ? true : false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (ptm != null) ptm.close();
        if (conn != null) conn.close();
    }
    return check;
}
    public UserDTO getUser() throws SQLException {
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        UserDTO user = null;
        try {
            conn= DButils.getConnection();
            if(conn!= null){
                ptm = conn.prepareStatement(CHECK);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("fullName");
                String roleID = rs.getString("roleID");
                user = new UserDTO(null, fullName, roleID, null, null, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return user;
    }
}
