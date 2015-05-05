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
public class SearchServlet extends HttpServlet {

	private AccountDao mDao;
	ResultSet resultSet = null;

	public SearchServlet() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SearchServlet");
		if (mDao.getConnection() != null) {
			System.out.println("数据库连接上了！");
		}

		String name = request.getParameter("Name");
		int level = 0;
		String email = null;
		String sign = null;
		String ip = null;
		resultSet = mDao.executeQuery("select * from accountlist where name=?",
				name);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			if (resultSet.next()) {
				email = resultSet.getString("email");
				sign = resultSet.getString("sign");
				ip = resultSet.getString("ip");
				level = resultSet.getInt("level");
				out.print(Constant.TEST_OK + ":" + name + ":" + ip + ":"
						+ email + ":" + sign + ":" + level);
				System.out.println("Name=" + name + ",sign=" + sign + ",Email="
						+ email + ",ip=" + ip + ",level" + level);
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
