/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Category;
import entity.Food;
import entity.Table;
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
                Food f = new Food(rs.getInt("id"), rs.getString("name"),rs.getInt("idCategory"),rs.getInt("price"));
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
                c = new Food(rs.getInt("id"), rs.getString("name"),rs.getInt("idCategory"),rs.getInt("price"));
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
                c = new Food(rs.getInt("id"), rs.getString("name"),rs.getInt("idCategory"),rs.getInt("price"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
}
