package com.util;
//通用数据操作方法
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//增删改
public class jdbcUtil {
	public static boolean executeUpdate(String sql, Object[] params){
		PreparedStatement pstmt = null;
		Connection connection = null;
		int count = 0;
		String urlName = "waste";
		String name = "root";
		String code  = "789258";
		String url1 = "jdbc:mysql://localhost:3306/";
		String url2 = "?characterEncoding=utf-8";
		String url = url1+urlName+url2;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,name,code);
			pstmt = connection.prepareStatement(sql);
			for(int i = 0; i <params.length ; i++) {
				pstmt.setObject(i+1,params[i]);
			}
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			if(count>0) {
				return true;
			}else {
				return false;
			}		
	}
	
	//查
	public static ResultSet query(String sql, Object[] params){
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String urlName = "waste";
		String name = "root";
		String code  = "789258";
		String url1 = "jdbc:mysql://localhost:3306/";
		String url2 = "?characterEncoding=utf-8";
		String url = url1+urlName+url2;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,name,code);
			pstmt = connection.prepareStatement(sql);
			for(int i = 0; i <params.length ; i++) {
				pstmt.setObject(i+1,params[i]);
			}		
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;	
	
	}
}
