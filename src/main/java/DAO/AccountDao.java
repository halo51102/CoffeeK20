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
import java.util.ArrayList;
import java.util.List;
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
                a = new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"), rs.getInt("status"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void changePassword(Account account, String newPass) {
        try {
            String sql = "update Account set PassWord = ? where UserName = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, newPass);
            ps.setString(2, account.getUsername());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Account account) {
        try {
            String sql = "update Account set DisplayName = ?,Password = ?, status = ? where UserName = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getDisplayName());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getStatus());
            ps.setString(4, account.getUsername());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Account> findByWord(String word) {
        List<Account> a = new ArrayList();
        try {
            String sql = "select * from Account where UserName like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + word + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"), rs.getInt("status")));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
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
                a = new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"), rs.getInt("status"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public List<Account> findAll() {
        List<Account> a = new ArrayList();
        try {
            String sql = "select * from Account";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Account(rs.getString("UserName"), rs.getString("PassWord"), rs.getString("DisplayName"), rs.getInt("Type"), rs.getInt("status")));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void create(Account account) {
        try {
            String sql = "insert into Account(UserName,DisplayName, PassWord, Type, status) values(?,?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getDisplayName());
            ps.setString(3, account.getPassword());
            ps.setInt(4, account.getType());
            ps.setInt(5, account.getStatus());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int count() {
        int n = 0;
        try {
            String sql = "select count(*) as count from Account";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getInt("count");
            }
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

}
