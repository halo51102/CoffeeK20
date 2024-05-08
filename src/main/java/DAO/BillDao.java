/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Bill;
import DTO.BillInfo;
import DTO.Category;
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
    FoodDao foodDao = new FoodDao();

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
                b = new Bill(rs.getInt("id"), rs.getInt("idTable"), rs.getInt("totalPrice"), rs.getInt("status"), rs.getInt("discount"), rs.getDate("DateCheckIn"), rs.getDate("DateCheckOut"), rs.getString("staff"));
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
            String sql = "insert into Bill(idTable,status,DateCheckIn) values (?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getId_table());
            ps.setInt(2, bill.getStatus());
            ps.setDate(3, bill.getCheckin_date());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBill(Bill bill) {
        try {
            String sql = "update Bill set status = ?,discount=?,totalPrice=?,DateCheckIn=?,DateCheckOut=?,staff=? where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getStatus());
            ps.setInt(2, bill.getDiscount());
            ps.setInt(3, bill.getTotal());
            ps.setDate(4, bill.getCheckin_date());
            ps.setDate(5, bill.getCheckout_date());
            ps.setString(6, bill.getStaff());
            ps.setInt(7, bill.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int caculateBill(int id_bill) {
        int result = 0;
        List<BillInfo> list = this.getBillInfo(id_bill);
        for (BillInfo item : list) {
            result += item.getCount() * foodDao.findById(item.getId_food()).getPrice();
        }
        return result;
    }

    @Override
    public List<Bill> findAllBill() {
        List<Bill> list = new ArrayList();
        try {
            String sql = "select * from Bill";

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Bill(rs.getInt("id"), rs.getInt("idTable"), rs.getInt("totalPrice"), rs.getInt("status"), rs.getInt("discount"), rs.getDate("DateCheckIn"), rs.getDate("DateCheckOut"), rs.getString("staff")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void deleteBill(Bill bill) {
        try {
            String sql = "delete from Bill where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, bill.getId());

            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int count() {
        int n = 0;
        try {
            String sql = "select count(*) as count from Bill";
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
