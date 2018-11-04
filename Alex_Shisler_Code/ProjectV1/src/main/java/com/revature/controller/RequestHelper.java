package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.Login;
import com.revature.delegate.HomeDelegate;
import com.revature.delegate.LoginDelegate;

public class RequestHelper {
	private HomeDelegate hd = new HomeDelegate();
	private LoginDelegate ld = new LoginDelegate();

	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String switchString = req.getContextPath();
		System.out.println("Test" + switchString);
		if (switchString.equals("/ProjectV1") || switchString.equals("EmployeeLoginPage.html")) {
			System.out.println("Attempting to login.");
			ld.login(req, resp);
			System.out.println("Feels good man.jpg");
		} // login page
		else {
			System.out.println("Login failed");
			resp.sendRedirect("EmployeePage.html");
		}
	}
}
