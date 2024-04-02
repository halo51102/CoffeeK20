/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Bill;
import entity.BillInfo;
import entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.BillRepository;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class BillDao implements BillRepository {

    Connection conn = DbUtil.connect();
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<BillInfo> getBillInfo(int id_bill) {
        List<BillInfo> list = new ArrayList<>();
        try {
            String sql = "select * from BillInfo where idBill = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_bill);
            rs = ps.executeQuery();

            while (rs.next()) {
                BillInfo c = new BillInfo(rs.getInt("id"), rs.getInt("idBill"), rs.getInt("idFood"), rs.getInt("count"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Bill findByIdTale(int id_table) {
        Bill b = null;
        try {
            String sql = "select * from Bill where idTable = ? and status = 0";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_table);
            rs = ps.executeQuery();

            while (rs.next()) {
                b = new Bill(rs.getInt("id"), rs.getInt("idTable"), rs.getInt("totalPrice"), rs.getInt("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    @Override
    public void createBillInfo(BillInfo bi) {
        try {
            String sql = "insert into BillInfo(idBill,idFood,count) values (?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bi.getId_bill());
            ps.setInt(2, bi.getId_food());
            ps.setInt(3, bi.getCount());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteBillInfo(int id) {
        try {
            String sql = "delete from BillInfo where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBillInfo(BillInfo bi) {
        try {
            String sql = "update BillInfo set count = ? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bi.getCount());
            ps.setInt(2, bi.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createBill(Bill bill) {
        try {
            String sql = "insert into Bill(idTable,status) values (?,?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getId_table());
            ps.setInt(2, bill.getStatus());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
