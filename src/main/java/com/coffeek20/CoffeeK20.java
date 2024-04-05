/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.coffeek20;

import GUI.staff.Login;
import GUI.staff.Home;
import java.sql.Connection;
import javax.swing.JOptionPane;
import util.DbUtil;

/**
 *
 * @author Admin
 */
public class CoffeeK20 {

    public static void main(String[] args) {

        Connection conn = DbUtil.connect();
        if (conn != null) {
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Login().setVisible(true);
                }
            });
        }

    }
}
