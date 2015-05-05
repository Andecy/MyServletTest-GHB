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
public class AddServlet extends HttpServlet {
	private AccountDao mDao;
	ResultSet resultSet = null;
	private boolean isCheck = false;

	public AddServlet() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AddServlet");
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");

		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Name");
		String cname = request.getParameter("Cname");
		System.out.println("Name=" + name + ",Cname=" + cname);

		resultSet = mDao.executeQuery(
				"select * from relatelist where name=? and cname=?", name,
				cname);
		try {
			isCheck = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("isCheck--->" +isCheck);
		if (!isCheck) {
			if (mDao.executeInsert(name, cname)
					&& mDao.executeInsert(cname, name)) {
				out.print(Constant.TEST_OK);
			} else {
				out.print(Constant.TEST_FAIL);
			}

		} else {
			out.print(Constant.TEST_REPEAT);
		}

		mDao.closeAll();
		out.flush();
		out.close();
	}

}
