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
public class RegDatabase extends HttpServlet {
	
	private AccountDao mDao;
	public RegDatabase() {
		mDao = new AccountDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RegDatabase");

		if (mDao.getConnection() != null) {
			System.out.println("数据库注册连接上了！");
		}

		String name = request.getParameter("Name");
		String pwd = request.getParameter("Pwd");
		System.out.println("Name="+name+",Pwd="+pwd);
		String email = request.getParameter("Email");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (mDao.executeInsert(name, pwd, email)) {
			out.print(Constant.TEST_OK);
		} else {
			out.print(Constant.TEST_FAIL);
		}
		mDao.closeAll();
		out.flush();
		out.close();
	}

}
