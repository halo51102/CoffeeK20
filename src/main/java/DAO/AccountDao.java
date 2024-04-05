/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.AccountRepository;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class AccountDao implements AccountRepository {

    Connection conn = DbUtil.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public Account login(String username, String password) {
        Account a = null;
        try {
            String sql = "select * from Account where UserName = ? and PassWord = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account findByUsername(String username) {
        Account a = null;
        try {
            String sql = "select * from Account where UserName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                a = new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

}
