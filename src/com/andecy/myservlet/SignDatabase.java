package com.andecy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andecy.bean.Constant;
import com.andecy.mysql.AccountDao;

@SuppressWarnings("serial")
public class SignDatabase extends HttpServlet {

	private AccountDao mDao;

	public SignDatabase() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SignDatabase");

		if (mDao.getConnection() != null) {
			System.out.println("数据库注册连接上了！");
		}

		String name = request.getParameter("Name");
		String sign = request.getParameter("Sign");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (mDao.executeUpdate("update accountlist set sign=? where name=?",
				sign, name)) {
			System.out.println("Name=" + name + ",Sign=" + sign);
			out.print(Constant.TEST_OK);
		} else {
			out.print(Constant.TEST_FAIL);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
