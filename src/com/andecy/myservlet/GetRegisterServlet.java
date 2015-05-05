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
public class GetRegisterServlet extends HttpServlet {
	private boolean isEmail = false;
	private boolean isName = false;
	private AccountDao mDao;
	ResultSet resultSet = null;

	public GetRegisterServlet() {
		mDao = new AccountDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("GetRegisterServlet");
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");
		}

		String name = req.getParameter("Name");
		String pwd = req.getParameter("Pwd");
		String email = req.getParameter("Email");
		System.out.println("Name="+name+",Pwd="+pwd+",Email="+email);
		int code = new Random().nextInt(9000) + 1000;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("手机连接上了！");
		resultSet = mDao.executeQuery(
				"select * from accountlist where email=?", email);
		
		try {
			isEmail = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultSet = mDao.executeQuery("select * from accountlist where name=?",
				name);
		try {
			
			isName = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!isEmail) {
			if (!isName) {
				out.print(Constant.TEST_OK + ":" + name + ":" + pwd + ":"
						+ email + ":" + code);
				Constant.sendRegEMail(code, email, name);
			} else {
				out.print(Constant.TEST_ERROR_NAMES + ":" + name + ":" + pwd
						+ ":" + email);
			}
		} else {
			out.print(Constant.TEST_ERROR_EMAILS + ":" + name + ":" + pwd + ":"
					+ email);
		}
		System.out.println("                            ");
		System.out.println("============================");
		System.out.println("                            ");
		out.flush();
		mDao.closeAll();
		out.close();
	}
}
