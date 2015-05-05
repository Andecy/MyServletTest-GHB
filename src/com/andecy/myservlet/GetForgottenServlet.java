package com.andecy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andecy.bean.Constant;
import com.andecy.mysql.AccountDao;

@SuppressWarnings("serial")
public class GetForgottenServlet extends HttpServlet {

	private boolean isCheck = false;
	private AccountDao mDao;
	ResultSet resultSet = null;

	public GetForgottenServlet() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("GetForgottenServlet");
		
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");
		}
		String name = request.getParameter("Name");
		String email = request.getParameter("Email");

		int code = new Random().nextInt(9000) + 1000;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("手机连接上了！");
		System.out.println("Forgotten--->Email=" + email + ",Name=" + name);
		resultSet = mDao.executeQuery(
				"select * from accountlist where name=? and email=?", name,
				email);
		try {
			isCheck = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isCheck) {
			out.print(Constant.TEST_OK + ":" + name + ":" + email + ":" + code);
			Constant.sendForgottenEMail(code, email, name);
		} else {
			out.print(Constant.TEST_FAIL + ":" + name + ":" + email);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
