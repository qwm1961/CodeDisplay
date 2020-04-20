package cn.tedu.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBTools {
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/yuanzang?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
	private static final String USER="root";
	private static final String PASS="123456789";
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int update(String sql,Object...obj) {
		int n=0;
		Connection con=getCon();
		PreparedStatement pstmt = null;
		try {
			// sql预处理对象
			pstmt = con.prepareStatement(sql);
			// 替换sql语句中的?占位符
			if(obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i + 1, obj[i]);
				}
			}
			// 执行sql得到执行结果
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		return n;
	}
	public static <T> List <T> query(String sql,Class<T>c,Object...obj){
		List<T> list=new ArrayList<T>();
		Connection con=getCon();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			pstmt=con.prepareStatement(sql);
			if(obj!=null) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i+1, obj[i]);
				}
			}
			rs=pstmt.executeQuery();
			ResultSetMetaData metaData=rs.getMetaData();
			int columnCount=metaData.getColumnCount();
			String columnName;
			Object columnValue;
			while (rs.next()) {
				T entity=c.newInstance();
				for (int i = 1; i < columnCount+1; i++) {
					columnName=metaData.getColumnLabel(i);
					columnValue=rs.getObject(columnName);
					Field f=c.getDeclaredField(columnName);
					f.setAccessible(true);
					f.set(entity, columnValue);
				}
				list.add(entity);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(con);
			
		}
		return list;
	}
	
	public static void close(Connection c) {
		if(c != null) { 
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(PreparedStatement s) {
		if(s != null) { 
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//
	public static void close(ResultSet s) {
		if(s != null) { 
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

