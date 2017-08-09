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

public class Servlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String s = request.getParameter("id");
		int id = Integer.parseInt(s);
		EmployeeDao ed = new EmployeeDao();
		pw.println("<html><body>");
		pw.println("<h1>Modification</h1>");

		if (ed.isPresent(id)) {
			EmployeeDao ed1 = new EmployeeDao();
			Employee emp = ed1.getDetails(id);
			request.setAttribute("employee", emp);
			request.setAttribute("id", id);
			request.getRequestDispatcher("ModifyEmp.jsp").forward(request, response);

		} else {
			pw.println("Invalid ID!!");
		}
		pw.println("</body></html>");
	}
}
