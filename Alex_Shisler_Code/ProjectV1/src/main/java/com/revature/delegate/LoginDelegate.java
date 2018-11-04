package com.revature.delegate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Login;
import com.revature.dao.LoginDao;
import com.revature.dao.LoginOracle;


/*
 * Programmer: Alex Shisler
 * LoginDelegate
 */
public class LoginDelegate {
	public LoginDao ld = new LoginOracle();
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String username = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(req.getContextPath());
		Login login = ld.login(username, password);
		if(login == null) {
			System.out.println("Failure!");	
			resp.sendRedirect("EmployeeLoginPage.html");
		} else {
			System.out.println("Success!");
			resp.sendRedirect("EmployeePage.html");
			System.out.println(req.getContextPath());
			HttpSession session = req.getSession();
			session.setAttribute("user", login);
		}
	}
	
	public void getPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("user")==null) {
			req.getRequestDispatcher("EmployeeLoginPage.html").forward(req,resp);
		} else {
			resp.sendRedirect("EmployeePage.html");
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		resp.sendRedirect("EmployeeLoginPage.html");
	}
}