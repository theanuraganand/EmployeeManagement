package com;

import bean.Employee;
import dao.EmployeeDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servelet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date = new Date().toString();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String join = "" + date;
		String desig = request.getParameter("desig");
		String dept = request.getParameter("dept");
		String sal = request.getParameter("sal");
		String dob = request.getParameter("dob");
		String qual = request.getParameter("qual");
		String add1 = request.getParameter("add1");
		String add2 = request.getParameter("add2");
		String city = request.getParameter("city");
		String pin = request.getParameter("pin");
		String phn = request.getParameter("phn");

		EmployeeDao employeeDao = new EmployeeDao(); // Employee Dao Object

		Employee employee = new Employee(); // Employee Bean Object

		// Set value to Employee Bean
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setJoin(join);
		employee.setDesig(desig);
		employee.setDept(dept);
		employee.setSal(sal);
		employee.setDob(dob);
		employee.setQual(qual);
		employee.setAdd1(add1);
		employee.setAdd2(add2);
		employee.setCity(city);
		employee.setPin(pin);
		employee.setPhn(phn);

		String result = employeeDao.createEmployee(employee); // Passing Object
																// of Employee
																// Bean to
																// Create in DB

		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Welcome Page</h1>");
		pw.println("<table border=1>");
		pw.println("<tr><th>UserName</th><th>Join</th><th>Qualification</th><th>DOB</th><th>Department</th></tr>");
		pw.println("<tr><td>" + fname + lname + "</td><td>" + join + "</td><td>" + qual + "</td><td>" + dob
				+ "</td><td>" + dept + "</td></tr>");
		pw.println("</table>");
		pw.println("<h3>" + result + "</h3>");
		pw.println("</body></html>");
	}

}
