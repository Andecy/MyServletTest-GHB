package com.andecy.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AccountDao {
	public static final String DRIVER = "com.mysql.jdbc.Driver";

	// 京东云擎
	public static final String URL = "jdbc:mysql://10.0.16.16:4066/_mysql_8910mq3q";
	public static final String USERNAME = "U6flgyN3";
	public static final String PASSWORD = "X8902E19ni90";

	// 本地服务器
	// public static final String URL = "jdbc:mysql://localhost/gtalk";
	// public static final String USERNAME = "root";
	// public static final String PASSWORD = "233";

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public Connection getConnection() {
		try {
			Class.forName(DRIVER);
			connection = (Connection) DriverManager.getConnection(URL,
					USERNAME, PASSWORD);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}

	public ResultSet executeQuery(String sql, String st) {

		try {
			connection = this.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, st);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet executeQuery(String sql, String st1, String st2) {

		try {
			connection = this.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, st1);
			preparedStatement.setString(2, st2);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet executeQuery(String sql, String st1, int st2) {

		try {
			connection = this.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, st1);
			preparedStatement.setInt(2, st2);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}

	public ResultSet executeQuery(String sql, String st1, String st2, int st3) {

		try {
			connection = this.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, st1);
			preparedStatement.setString(2, st2);
			preparedStatement.setInt(3, st3);
			resultSet = preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultSet;
	}

	public Boolean executeInsert(String name, String cname) {
		connection = this.getConnection();
		String sqlInsert = "insert into relatelist values(?,?,?)";
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sqlInsert);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, cname);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean executeInsert(String name, String pwd, String email) {
		connection = this.getConnection();

		String sqlQuery = "insert into accountlist values(?,?,?,?,?,?)";
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sqlQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pwd);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, 1);
			preparedStatement.setString(5, null);
			preparedStatement.setString(6, null);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean chatInsert(String name, String cname, String content) {
		connection = this.getConnection();

		String sqlQuery = "insert into chatlist values(?,?,?,?,?)";
		try {
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sqlQuery);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, cname);
			preparedStatement.setString(4, content);
			preparedStatement.setInt(5, 0);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//改密码
	public Boolean executeUpdate(String sql, String st1, String st2) {
		try {

			connection = this.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql);
			preparedStatement.setString(1, st1);
			preparedStatement.setString(2, st2);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public void closeAll() {
		try {
			if (null != resultSet) {
				resultSet.close();
			}
			if (null != preparedStatement) {
				preparedStatement.close();
			}
			if (null != connection) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
