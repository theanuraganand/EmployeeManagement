<%@page import="dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify Employee</title>
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
	padding-top: 70px;
	padding-bottom: 70px;
}

#d1 {
	margin-left: 570px;
}
</style>
</head>
<body>
	<div class="container-fluid" id="d1">
		<form method="get" action="StoreEditedServlet">
			<h3>ID:${id}</h3>
			<input type="hidden" name="id" value="${id}"> First Name: <input
				type="text" name="fname" value="${employee.fname}"> <br>


			Last Name: <input type="text" name="lname" value="${employee.lname}">
			<br> Join Date: <input type="text" name="join"
				value="${employee.join}"> <br> Date of
			Birth(dd/mm/yyyy): <input type="text" name="dob"
				value="${employee.dob}"> <br> Department: <input
				type="text" name="dept" value="${employee.dept}"> <br>
			Designation: <input type="text" name="desig"
				value="${employee.desig}"> <br> Basic Salary: <input
				type="text" name="sal" value="${employee.sal}"> <br>
			Educational Qualification: <input type="text" name="qual"
				value="${employee.qual}"> <br> Address Line 1: <input
				type="text" name="add1" value="${employee.add1}"> <br>
			Address Line 2: <input type="text" name="add2"
				value="${employee.add2}"> <br> City: <input type="text"
				name="city" value="${employee.city}"> <br> Pin: <input
				type="text" name="pin" value="${employee.pin}"> <br>
			Phone: <input type="text" name="phn" value="${employee.phn}">
			<br> <input type="submit" name="submit" value="Update Details">
		</form>

	</div>
</body>
</html>