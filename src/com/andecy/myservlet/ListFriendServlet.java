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
public class ListFriendServlet extends HttpServlet {

	private AccountDao mDao;
	ResultSet resultSet = null;

	public ListFriendServlet() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ListFriendServlet");
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");
		}

		String name = request.getParameter("Name");
		String cname = null;
		resultSet = mDao.executeQuery("select cname from relatelist where name=?",
				name);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Name=" + name);
		try {
			if (resultSet.next()) {
				out.print(Constant.TEST_OK);
				do {
					cname = resultSet.getString("cname");
					System.out.println("Cname=" + cname);
					out.print(":" + cname);
				} while (resultSet.next());
			} else {
				out.print(Constant.TEST_FAIL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
