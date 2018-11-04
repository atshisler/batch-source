package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.Login;
import com.revature.user.Employee;

public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963624447234248456L;
	//private RequestHelper rh = new RequestHelper();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String switchString = req.getContextPath();
		System.out.println("GET " + switchString);
		if (switchString.equals("/ProjectV1") || switchString.equals("EmployeeLoginPage.html")) {

			System.out.println("Shrug");
			new RequestHelper().process(req, res);
		} else {
			System.out.println("Success");
			super.doGet(req, res);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String switchString = req.getContextPath();
		System.out.println("Post " + switchString);
		doGet(req, res);
		/*
		 * if (req.getContextPath().equals("//ProjectV1") ||
		 * req.getContextPath().equals("EmployeeLoginPage.html")) {
		 * 
		 * 
		 * user = new Login(); HttpSession session = req.getSession();
		 * session.setAttribute("user", user);
		 * 
		 * if (session.getAttribute("user") == null) { System.out.println("empty");
		 * req.getRequestDispatcher("EmployeeLoginPage.html").forward(req, res); } else
		 * { System.out.println("Success"); res.sendRedirect("EmployeePage.html"); }
		 * res.setHeader("Content-Type", "application/json");
		 * 
		 * }//login page else { res.sendRedirect("EmployeePage.html"); }
		 */
		// Todo newTodo = new ObjectMapper().readValue(req.getReader(), Todo.class);
		// System.out.println(newTodo);

	}

}
