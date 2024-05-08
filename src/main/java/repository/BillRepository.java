/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import DTO.Bill;
import DTO.BillInfo;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BillRepository {

    List<BillInfo> getBillInfo(int id_bill);

    Bill findByIdTale(int id_table);

    void createBillInfo(BillInfo bi);

    void deleteBillInfo(int id);

    void updateBillInfo(BillInfo bi);

    void createBill(Bill bill);

    void updateBill(Bill bill);

    int caculateBill(int id_bill);

    List<Bill> findAllBill();

    void deleteBill(Bill bill);

    int count();
}
