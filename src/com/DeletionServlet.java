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

public class DeletionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		EmployeeDao ed = new EmployeeDao();
		pw.println("<html><body>");
		pw.println("<h1>Deletion</h1>");

		if (ed.isPresent(id)) {
			EmployeeDao ed1 = new EmployeeDao();
			boolean cond = ed1.deleteEmployee(id);
			pw.println(cond);
			if (!ed1.isPresent(id)) {
				pw.println("<h3>Employee ID:" + id + " has been Deleted</h3>");
			} else {
				pw.println("<h3>Employee ID:" + id + " Deletion Unsuccessful</h3>");
			}
		} else {
			pw.println("Invalid ID!!");
		}

		pw.println("</body></html>");

	}
}
