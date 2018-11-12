package com.revature.delegate;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.cookiehelper.CookieHelper;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.user.Employee;
import com.revature.user.Reimbursement;

public class EmployeeDelegate {

	private EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
	private ReimbursementDAOImpl reimbursementDAO;
	private CookieHelper cooks = new CookieHelper();
	private Employee employee;
	private Reimbursement reimbursement;

	public void retrieveEmpInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie email = cooks.getCookie("email", req);
		System.out.println(email.getValue());
		employee = employeeDAO.getEmployee(email.getValue());
		if (employee == null)
			System.out.println("Failure!");
		else {
			System.out.println("Retrieve");
			System.out.println(employee.toString());

			HttpSession session = req.getSession();
			session.setAttribute(employee.getUsername(), employee);
			session.setAttribute(employee.getPassword(), employee);
			ObjectMapper mapper = new ObjectMapper();
			resp.setStatus(201);
			resp.setHeader("Content-Type", "application/json");
			// resp.setHeader("Access-Control-Allow-Origin",
			// "http://localhost:6016/ProjectV1/api");
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setHeader("Access-Control-Allow-Credentials", "true");
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			mapper.writeValue(resp.getOutputStream(), employee);
		}
	}

	public void addReimbursement(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie email = cooks.getCookie("email", req);
		employee = employeeDAO.getEmployee(email.getValue());
		System.out.println(employee.toString());
		String data = getBody(req);
		System.out.println(data);
		reimbursement = new ObjectMapper().readValue(data, Reimbursement.class);
		reimbursement.setId(employee.getE_ID());
		System.out.println(reimbursement);
		reimbursementDAO = reimbursementDAO.getRDAO();
		reimbursementDAO.insertReimbursements(reimbursement);

	}

	public void getReimbursementList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie email = cooks.getCookie("email", req);
		employee = employeeDAO.getEmployee(email.getValue());
		System.out.println("Oh boy");
		if (employee == null)
			System.out.println("Failure!");
		else {
			reimbursementDAO = reimbursementDAO.getRDAO();
			System.out.println("E_ID: " + employee.getE_ID());
			employee.setReimburseList(reimbursementDAO.getReimbursList(employee.getE_ID()));
			System.out.println(employee.getReimburseList().toString());
			ObjectMapper mapper = new ObjectMapper();
			resp.setStatus(201);
			resp.setHeader("Content-Type", "application/json");
			// resp.setHeader("Access-Control-Allow-Origin",
			// "http://localhost:6016/ProjectV1/api");
			resp.setHeader("Access-Control-Allow-Origin", "*");
			resp.setHeader("Access-Control-Allow-Credentials", "true");
			resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			mapper.writeValue(resp.getOutputStream(), employee.getReimburseList());
			
		}
	}
	
	public void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		Cookie email = cooks.getCookie("email", req);
		Employee temp;
		employee = employeeDAO.getEmployee(email.getValue());
		
		if(employee == null)
			System.out.println("Failure!");
		else {
			String data = getBody(req);
			System.out.println(data);
			temp = new ObjectMapper().readValue(data, Employee.class);
			System.out.println(temp);
			employee.setUsername(temp.getUsername());
			employee.setFirstName(temp.getFirstName());
			employee.setLastName(temp.getLastName());
			employee.setDesc(temp.getDesc());
			System.out.println(employee.toString());
			employeeDAO.updateEmployee(employee);
			resp.setStatus(201);
			return;
		}
	}

	private String getBody(HttpServletRequest req) throws ServletException, IOException {
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader;
		try {
			reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			} // while
			String data = buffer.toString();
			return data;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch
		return null;

	}// getBody

}
