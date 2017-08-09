<%@ page import="dao.EmployeeDao"%>
<%@ page import="java.sql.ResultSet"%><%--
  Created by IntelliJ IDEA.
  User: Anurag
  Date: 08/08/17
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Employees Details</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container-fluid {
	padding-top: 30px;
	padding-bottom: 70px;
}

table {
	display: table;
	border-collapse: separate;
	border-spacing: 10px;
	border-color: gray;
	font-size: medium;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<h1 class="text-center">Employee Details</h1>
		<hr>
		<table align="center">
			<tr>
				<th>Emp ID</th>
				<th>Name</th>
				<th>Join</th>
				<th>Desig</th>
				<th>Dept</th>
				<th>Salary</th>
				<th>DOB</th>
				<th>Qual</th>
				<th>Address Line 1</th>
				<th>Line 2</th>
				<th>City</th>
				<th>Pin</th>
				<th>Phone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<% EmployeeDao ed= new EmployeeDao();
            ResultSet rs1=ed.returnAllEmpDetails();
            ResultSet rs2=ed.returnAllPersonalEmpDetails();
            while(rs1.next()&&rs2.next()) {
                out.write("<tr>");
                out.write("<td>"+rs1.getString(1)+"</td>");
                out.write("<td>"+rs1.getString(3)+" "+rs1.getString(2)+"</td>");
                out.write("<td>"+rs1.getString(4)+"</td>");
                out.write("<td>"+rs1.getString(5)+"</td>");
                out.write("<td>"+rs1.getString(6)+"</td>");
                out.write("<td>"+rs1.getString(7)+"</td>");
                out.write("<td>"+rs2.getString(2)+"</td>");
                out.write("<td>"+rs2.getString(3)+"</td>");
                out.write("<td>"+rs2.getString(4)+"</td>");
                out.write("<td>"+rs2.getString(5)+"</td>");
                out.write("<td>"+rs2.getString(6)+"</td>");
                out.write("<td>"+rs2.getString(7)+"</td>");
                out.write("<td>"+rs2.getString(8)+"</td>");
                out.write("<td><form action=\"Servlet2\">");
                out.write("<input type=\"hidden\" value=\""+Integer.parseInt(rs1.getString(1))+"\" name=\"id\" >");
                out.write("<input type=\"submit\" value=\"Edit\" > </form></td>");

                out.write("<td><form action=\"DeletionServlet\">");
                out.write("<input type=\"hidden\" value=\""+Integer.parseInt(rs1.getString(1))+"\" name=\"id\" >");
                out.write("<input type=\"submit\" value=\"Delete\" > </form></td>");
                out.write("</tr>");
            }
        %>

		</table>
	</div>
</body>
</html>
