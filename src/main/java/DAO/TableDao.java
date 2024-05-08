/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Category;
import DTO.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.TableRepository;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class TableDao implements TableRepository {

    Connection conn = DbUtil.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<Table> findAll() {
        List<Table> list = new ArrayList<>();
        try {
            String sql = "select * from tableFood";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Table t = new Table(rs.getInt("id"), rs.getString("name"), rs.getString("status"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Table findByName(String name) {
        Table c = null;
        try {
            String sql = "select * from tableFood where name = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Table(rs.getInt("id"), rs.getString("name"), rs.getString("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void update(Table table) {
        try {
            String sql = "update tableFood set name = ?, status = ? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(2, table.getStatus());
            ps.setString(1, table.getName());
            ps.setInt(3, table.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Table findById(int id) {
        Table c = null;
        try {
            String sql = "select * from tableFood where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                c = new Table(rs.getInt("id"), rs.getString("name"), rs.getString("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public void create(Table table) {
        try {
            String sql = "insert into tableFood values(?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, table.getName());
            ps.setString(2, "Trống");

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Table table) {
        try {
            String sql = "delete from tableFood where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, table.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int count() {
        int n = 0;
        try {
            String sql = "select count(*) as count from tableFood";
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
