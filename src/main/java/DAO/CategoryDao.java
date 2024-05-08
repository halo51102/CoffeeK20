/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import DTO.Category;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.CategoryRepository;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class CategoryDao implements CategoryRepository {

    Connection conn = DbUtil.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public Category findByName(String name) {
        Category c = null;
        try {
            String sql = "select * from FoodCategory where name = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "select * from FoodCategory";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Category c = new Category(rs.getInt("id"), rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Category> findByWord(String word) {
        List<Category> a = new ArrayList();
        try {
            String sql = "select * from FoodCategory where name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + word + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void create(Category c) {
        try {
            String sql = "insert into FoodCategory values(?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Category c) {
        try {
            String sql = "update FoodCategory set name = ? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Category c) {
        try {
            String sql = "delete from FoodCategory where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Category findById(int id) {
        Category c = null;
        try {
            String sql = "select * from FoodCategory where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public int count() {
        int n = 0;
        try {
            String sql = "select count(*) as count from FoodCategory";
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
