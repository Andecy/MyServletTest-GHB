package com.andecy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andecy.bean.Constant;
import com.andecy.mysql.AccountDao;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	private AccountDao mDao;
	ResultSet resultSet = null;
	private boolean isCheck = false;

	public LoginServlet() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginServlet");
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("Name");
		String pwd = request.getParameter("Pwd");
		System.out.println("Name="+name+",Pwd="+pwd);
		String sign = null;
		int level = 0;
		resultSet = mDao.executeQuery(
				"select * from accountlist where name=? and pwd=?", name, pwd);
		try {
			isCheck = resultSet.next();
			sign = resultSet.getString("sign");
			level = resultSet.getInt("level");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isCheck) {
			out.print(Constant.TEST_OK + ":" + name + ":" + pwd + ":" + sign
					+ ":" + level);
		} else {
			out.print(Constant.TEST_FAIL);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
