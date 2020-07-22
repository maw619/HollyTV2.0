package com.wolff.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dbhelper extends Conexion{
	
	public void editChannel(String c,int id) {
		this.getConn();
		String sql = "UPDATE FROM tvlist SET url = ? WHERE is = ?";
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setString(1, c);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("updated");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getId(int id) {
		this.getConn();
		String sql = "SELECT id FROM tvlist WHERE url = ?";
		int x = 0;
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				x = rs.getInt("url");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public String updateUrl(String url, int id) {
		this.getConn();
		String sql = "UPDATE tvlist SET url = ? WHERE id = "+id;
		String x = "";
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ps.setString(1, url);
			ps.executeUpdate();
			if(ps.getFetchSize() < 1) {
				System.out.println("updated");
			}
		}catch(Exception e) {
			System.out.println("nope");
			e.printStackTrace();
		}
		return x;
	}

}
