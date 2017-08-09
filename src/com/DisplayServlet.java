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

public class DisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		EmployeeDao ed1 = new EmployeeDao();
		int id = Integer.parseInt(request.getParameter("id"));
		if (ed1.isPresent(id)) {
			Employee e = ed1.getDetails(id);
			pw.println("<html><body>");
			pw.println("<br><h1 align=\"center\">Employee Found</h1>");
			pw.println("<table align=\"center\" border=\"1px\" padding=\"10px\">" + "        <tr>"
					+ "            <th>Emp ID</th>" + "            <th>Name</th>" + "            <th>Join</th>"
					+ "            <th>Desig</th>" + "            <th>Dept</th>" + "            <th>Salary</th>"
					+ "            <th>DOB</th>" + "            <th>Qual</th>" + "            <th>Address Line 1</th>"
					+ "            <th>Line 2</th>" + "            <th>City</th>" + "            <th>Pin</th>"
					+ "            <th>Phone</th>" + "           </tr>");

			pw.println("        <tr>" + "            <td>" + id + "</td>" + "            <td>" + e.getFname() + "  "
					+ e.getLname() + "</td>" + "            <td>" + e.getJoin() + "</td>" + "            <td>"
					+ e.getDesig() + "</td>" + "            <td>" + e.getDept() + "</td>" + "            <td>"
					+ e.getSal() + "</td>" + "            <td>" + e.getDob() + "</td>" + "            <td>"
					+ e.getQual() + "</td>" + "            <td>" + e.getAdd1() + "</td>" + "            <td>"
					+ e.getAdd2() + "</td>" + "            <td>" + e.getCity() + "</td>" + "            <td>"
					+ e.getPin() + "</td>" + "            <td>" + e.getPhn() + "</td>" + "           </tr>");
			pw.println("</table></body></html>");

		}

	}
}
