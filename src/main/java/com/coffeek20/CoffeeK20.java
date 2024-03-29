/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.coffeek20;

import GUI.Home;
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
            Home home = new Home();
            home.setVisible(true);
        }

    }
}
