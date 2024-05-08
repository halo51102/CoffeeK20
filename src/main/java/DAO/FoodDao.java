/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Food;
import DTO.Food;
import DTO.Category;
import DTO.Food;
import DTO.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.FoodRepository;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class FoodDao implements FoodRepository {

    Connection conn = DbUtil.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Food> findByCategory(int cId) {
        List<Food> list = new ArrayList<>();
        try {
            String sql = "select * from Food where idCategory = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, cId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Food f = new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("price"), rs.getString("image"));
                list.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Food findByName(String name) {
        Food c = null;
        try {
            String sql = "select * from Food where name = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("price"), rs.getString("image"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public Food findById(int id) {
        Food c = null;
        try {
            String sql = "select * from Food where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("price"), rs.getString("image"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public List<Food> findAll() {
        List<Food> a = new ArrayList();
        try {
            String sql = "select * from Food";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("price"), rs.getString("image")));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void create(Food food) {
        try {
            String sql = "insert into Food(name,idCategory,price) values(?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, food.getName());
            ps.setInt(2, food.getId_category());
            ps.setFloat(3, food.getPrice());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Food food) {
        try {
            String sql = "update Food set name = ?,idCategory = ?, price = ? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, food.getName());
            ps.setInt(2, food.getId_category());
            ps.setFloat(3, food.getPrice());
            ps.setInt(4, food.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Food food) {
        try {
            String sql = "delete from Food where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, food.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Food> findByWord(String word) {
        List<Food> a = new ArrayList();
        try {
            String sql = "select * from Food where name like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + word + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                a.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getInt("idCategory"), rs.getInt("price"), rs.getString("image")));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(FoodDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public int count() {
        int n = 0;
        try {
            String sql = "select count(*) as count from Food";
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

    @Override
    public Food bestSeller() {
        Food food = null;
        try {
            String sql = "select top 1 idFood,count(idFood) as count  from BillInfo group by idFood ORDER BY count DESC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idFood");
                food = findById(id);
            }
            return food;
        } catch (SQLException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return food;
    }
}
