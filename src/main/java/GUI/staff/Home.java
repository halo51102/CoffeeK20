/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.staff;

import DAO.BillDao;
import DAO.CategoryDao;
import DAO.FoodDao;
import DAO.TableDao;
import DTO.Account;
import GUI.staff.JPanelFood.Callback;
import DTO.Bill;
import DTO.BillInfo;
import DTO.Category;
import DTO.Food;
import DTO.Table;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Home extends javax.swing.JFrame implements JPanelFood.Callback, JPanelTable.Callback, JDialogBill.Callback {

    CategoryDao categoryDao;
    Category category;
    List<Category> categoryList;

    TableDao tableDao;
    Table table;
    List<Table> tableList;

    FoodDao foodDao;
    Food food;
    List<Food> foodList;

    Bill bill;
    BillInfo billInfo;
    BillDao billDao;
    List<BillInfo> billInfoList;

    Account account;
    JFrame parent;

    /**
     * Creates new form Home
     *
     * @param parent
     * @param account
     */
    public Home(JFrame parent, Account account) {
        initComponents();
        this.categoryDao = new CategoryDao();
        this.tableDao = new TableDao();
        this.foodDao = new FoodDao();
        this.billDao = new BillDao();
        this.categoryList = categoryDao.getAll();
        this.account = account;
        this.parent = parent;
        this.setTitle("CoffeeK20 - " + account.getDisplayName());

        loading();
    }

    private void caculateTotal() {
        int tempTotal = billDao.caculateBill(bill.getId());
        jLabelTempTotal.setText(String.valueOf(tempTotal));
        int finalTotal = tempTotal - tempTotal * jSlider1.getValue() / 100;
        jLabelTotal.setText(String.valueOf(finalTotal));

//        bill.setDiscount(jSlider1.getValue());
//        bill.setTotal(Integer.parseInt(jLabelTotal.getText()));
//        billDao.updateBill(bill);
    }

    @Override
    public void actionClickCheckout() {
        bill.setStatus(1);
        bill.setDiscount(jSlider1.getValue());
        bill.setTotal(Integer.parseInt(jLabelTotal.getText()));
        billDao.updateBill(bill);

        Bill newBill = new Bill();
        newBill.setId_table(table.getId());
        newBill.setStatus(0);
        newBill.setCheckin_date(Date.valueOf(LocalDate.now()));
        billDao.createBill(newBill);
        bill = newBill;
        loadingOrder(newBill);
        loading();
        jScrollPaneFood.setVisible(false);
        jListCategory.setVisible(false);
        jSlider1.setValue(0);
    }

    public interface CallbackTable {

        public void callbackTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButtonAccountProfile = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jScrollPaneTable = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListCategory = new javax.swing.JList<>();
        jScrollPaneFood = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelTempTotal = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButtonCheckOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableOrder = new javax.swing.JTable();
        jLabelTableName = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonReOrder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAccountProfile.setText("THÔNG TIN CÁ NHÂN");
        jButtonAccountProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAccountProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccountProfileActionPerformed(evt);
            }
        });

        jButtonLogout.setText("ĐĂNG XUẤT");
        jButtonLogout.setToolTipText("");
        jButtonLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAccountProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButtonAccountProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPaneTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneTableMouseClicked(evt);
            }
        });

        jListCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jListCategory.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jListCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCategoryMouseClicked(evt);
            }
        });
        jListCategory.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListCategoryValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jListCategory);

        jLabel3.setText("Giảm giá");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền");

        jLabel6.setText("VNĐ");

        jLabelTotal.setText("x");

        jLabel4.setText("Tổng order");

        jLabel7.setText("VNĐ");

        jLabelTempTotal.setText("x");

        jSlider1.setMajorTickSpacing(20);
        jSlider1.setMinorTickSpacing(10);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButtonCheckOut.setText("THANH TOÁN");
        jButtonCheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCheckOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabelTempTotal)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButtonCheckOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabelTempTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("ORDER");

        jLabel2.setText("MENU");

        jTableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(jTableOrder);

        jLabelTableName.setBackground(new java.awt.Color(102, 102, 255));
        jLabelTableName.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabelTableName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTableName.setText("BÀN ...");
        jLabelTableName.setOpaque(true);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButtonReOrder.setText("Re-order");
        jButtonReOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTableName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonReOrder)
                                .addGap(323, 323, 323))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneFood, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPaneFood)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelTableName)
                            .addComponent(jButtonReOrder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addComponent(jSeparator2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListCategoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListCategoryValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jListCategoryValueChanged

    private void jScrollPaneTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPaneTableMouseClicked

    private void jButtonCheckOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCheckOutMouseClicked
        // TODO add your handling code here:
        bill.setDiscount(jSlider1.getValue());
        bill.setTotal(Integer.parseInt(jLabelTotal.getText()));
        billDao.updateBill(bill);
        JDialogBill a = new JDialogBill(this, true, bill, account, this);
        a.setVisible(true);

    }//GEN-LAST:event_jButtonCheckOutMouseClicked

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        caculateTotal();
    }//GEN-LAST:event_jSlider1StateChanged

    private void jListCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCategoryMouseClicked
        // TODO add your handling code here:
        category = categoryDao.findByName(jListCategory.getSelectedValue());
        foodList = foodDao.findByCategory(category.getId());
        JPanel panelFood = new JPanel();
        panelFood.setLayout(new GridLayout(foodList.size() / 6, 6));
        foodList.forEach(obj -> {
            panelFood.add(new JPanelFood(obj.getName(), obj.getPrice(), this, this));
        });
        panelFood.revalidate();
        panelFood.repaint();
        jScrollPaneFood.setViewportView(panelFood);
    }//GEN-LAST:event_jListCategoryMouseClicked

    private void jButtonReOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReOrderActionPerformed
        // TODO add your handling code here:
        for (BillInfo item : billInfoList) {
            billDao.deleteBillInfo(item.getId());
        }
        loadingOrder(bill);
        loading();
    }//GEN-LAST:event_jButtonReOrderActionPerformed

    private void jButtonAccountProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccountProfileActionPerformed
        // TODO add your handling code here:
        JDialogAccountProfile d = new JDialogAccountProfile(this, true, account);
        d.setVisible(true);
    }//GEN-LAST:event_jButtonAccountProfileActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccountProfile;
    private javax.swing.JButton jButtonCheckOut;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonReOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTableName;
    private javax.swing.JLabel jLabelTempTotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JList<String> jListCategory;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneFood;
    private javax.swing.JScrollPane jScrollPaneTable;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTableOrder;
    // End of variables declaration//GEN-END:variables

    private void loading() {
        loadingCategory();
        loadingTable();
        jButtonCheckOut.setEnabled(false);
        jSlider1.setEnabled(false);
        jButtonReOrder.setEnabled(false);

//        loadingFood();
    }

    private void loadingOrder(Bill bill) {

        jTableOrder.removeAll();
        try {
            billInfoList = billDao.getBillInfo(bill.getId());
        } catch (Exception e) {

        }

        String columns[] = {"STT", "TÊN MÓN", "SỐ LƯỢNG", "TIỀN MÓN"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
        if (billInfoList != null) {
            if (!billInfoList.isEmpty()) {
                billInfoList.forEach(obj -> {
                    dtm.addRow(new Object[]{"STT",
                        foodDao.findById(obj.getId_food()).getName(),
                        obj.getCount(),
                        foodDao.findById(obj.getId_food()).getPrice() * obj.getCount()});
                });
                for (int i = 0; i < dtm.getRowCount(); i++) {
                    dtm.setValueAt(i + 1, i, 0);
                }

                jTableOrder.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
                    int position = jTableOrder.getSelectedRow();
                    if (position >= 0) {
                        billInfo = billInfoList.get(position);
                    }

                });

                jTableOrder.changeSelection(0, 0, false, false);
                jButtonCheckOut.setEnabled(true);
                jSlider1.setEnabled(true);
                jButtonReOrder.setEnabled(true);
                caculateTotal();
            } else {
                jButtonCheckOut.setEnabled(false);
                jSlider1.setEnabled(false);
                jLabelTempTotal.setText("0");
                jLabelTotal.setText("0");
                jButtonReOrder.setEnabled(false);
            }
        }
        jTableOrder.setModel(dtm);

        //Caculate total money
    }

    @Override
    public void actionClickFood(String name) {
        food = foodDao.findByName(name);

        try {
            int check = 0;

            for (BillInfo b : billInfoList) {
                if (b.getId_food() == food.getId()) {
                    b.setCount(b.getCount() + 1);
                    billDao.updateBillInfo(b);
                    check = 1;
                    break;
                }
            }

            if (check == 0) {
                BillInfo b = new BillInfo();
                b.setId_bill(bill.getId());
                b.setId_food(food.getId());
                b.setCount(1);
                billDao.createBillInfo(b);
            }

            if (bill == null) {
                bill = new Bill();
                bill.setId_table(table.getId());
                bill.setStatus(0);
                bill.setCheckin_date(Date.valueOf(LocalDate.now()));
                billDao.createBill(bill);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn");
        }

        loadingOrder(bill);
        loadingTable();
    }

    @Override
    public void actionClickTable(String name) {
        loadingCategory();
        loadingFood();

        table = tableDao.findByName(name);
        jLabelTableName.setText(name);
        bill = billDao.findByIdTale(table.getId());
        if (bill == null) {
            bill = new Bill();
            bill.setId_table(table.getId());
            bill.setStatus(0);
            bill.setCheckin_date(Date.valueOf(LocalDate.now()));
            billDao.createBill(bill);
        }
        loadingOrder(bill);
    }

    private void loadingTable() {
        tableList = tableDao.getAll();
        JPanel panelTable = new JPanel();
        panelTable.setLayout(new GridLayout(0, 1));
        tableList.forEach(obj -> {
            if (!billDao.getBillInfo(billDao.findByIdTale(obj.getId()).getId()).isEmpty()) {
                obj.setStatus("Có người");
                tableDao.update(obj);
            }

            panelTable.add(new JPanelTable(obj.getName(), obj.getStatus(), this, this));
        });
        panelTable.revalidate();
        panelTable.repaint();
        jScrollPaneTable.setViewportView(panelTable);
    }

    private void loadingCategory() {
        category = categoryDao.findByName(jListCategory.getSelectedValue());
        jListCategory.removeAll();
        DefaultListModel<String> dlm = new DefaultListModel<>();
        categoryList.forEach(obj -> {
            dlm.addElement(obj.getName());
        });
        jListCategory.setModel(dlm);
        jListCategory.setVisible(true);
    }

    private void loadingFood() {
        foodList = foodDao.findByCategory(1);
        JPanel panelFood = new JPanel();
        panelFood.setLayout(new GridLayout(foodList.size() / 6, 5));
        foodList.forEach(obj -> {
            panelFood.add(new JPanelFood(obj.getName(), obj.getPrice(), this, this));
        });
        panelFood.revalidate();
        panelFood.repaint();
        jScrollPaneFood.setViewportView(panelFood);
        jScrollPaneFood.setVisible(true);
    }

}
