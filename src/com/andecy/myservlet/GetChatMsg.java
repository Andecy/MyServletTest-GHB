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
public class GetChatMsg extends HttpServlet {
	private AccountDao mDao;
	ResultSet resultSet = null;
	private boolean hasContent = false;

	public GetChatMsg() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GetChatMsg");
		if (mDao.getConnection() != null) {
			System.out.println("数据库注册连接上了！");
		}
		String taName = request.getParameter("TaName");
		String myName = request.getParameter("MyName");
		
		String msg = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		resultSet = mDao.executeQuery(
				"select * from chatlist where taname=? and myname=?",myName, taName);
		try {
			hasContent = resultSet.next();
			msg = resultSet.getString("content");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (hasContent) {
			out.print(Constant.TEST_OK + ":" + msg);
		} else {
			out.print(Constant.TEST_FAIL);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
