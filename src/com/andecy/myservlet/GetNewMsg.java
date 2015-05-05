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
public class GetNewMsg extends HttpServlet {
	private AccountDao mDao;
	private boolean isCheck = false;
	ResultSet resultSet = null;

	public GetNewMsg() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GetNewMsg");
		if (mDao.getConnection() != null) {
			System.out.println("数据库注册连接上了！");
		}
		String myName = request.getParameter("MyName");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		resultSet = mDao.executeQuery(
				"select * from chatlist where taname=? and state=?", myName, 0);
		try {
			isCheck = resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isCheck) {
			out.print(Constant.TEST_OK);

		} else {
			out.print(Constant.TEST_FAIL);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
