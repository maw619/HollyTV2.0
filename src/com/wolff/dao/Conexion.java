//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wolff.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection conn;

    public Conexion() {
    }

    public void getConn() {
        String url = "jdbc:mysql://localhost:3306/holly";
        String user = "root";
        String pass = "";

        try {
            this.conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
        } catch (Exception var5) {
            var5.printStackTrace();
        }

    }
}
