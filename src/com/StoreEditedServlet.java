package com;

import bean.Employee;
import dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class StoreEditedServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String join = request.getParameter("join");
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

		String result = employeeDao.updateEmployee(id, employee); // Passing
																	// Object of
																	// Employee
																	// Bean to
																	// Create in
																	// DB

		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Welcome Page</h1>");
		pw.println("<table border=1>");
		pw.println("<tr><th>Status</th></tr>");
		pw.println("<tr><td>Employee" + result + "</td></tr>");
		pw.println("</table>");
		pw.println("</body></html>");
	}
}
