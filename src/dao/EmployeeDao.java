package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import bean.Employee;
import config.MyConnection;

public class EmployeeDao {

	Connection connection = MyConnection.getConnection();

	public String createEmployee(Employee e) {
		try {

			PreparedStatement ps1 = connection.prepareStatement(
					"INSERT INTO Employee_table ( Fname, Lname, JoinDate, Designation, Dept, BasicSal)VALUES( ?, ?, ?, ?, ?, ?)");

			ps1.setString(1, e.getFname());
			ps1.setString(2, e.getLname());
			ps1.setString(3, e.getJoin());
			ps1.setString(4, e.getDesig());
			ps1.setString(5, e.getDept());
			ps1.setString(6, e.getSal());
			int a = ps1.executeUpdate();
			ResultSet rs = ps1.executeQuery("SELECT MAX(EmpNo) from Employee_table");
			rs.next();
			int empno = rs.getInt(1);
			PreparedStatement ps2 = connection.prepareStatement(
					"INSERT INTO Employee_Personal_Info (EmpNo, DOB, EduQal, AddLine1, AddLine2, City, Pin, Phone) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps2.setInt(1, empno);
			ps2.setString(2, e.getDob());
			ps2.setString(3, e.getQual());
			ps2.setString(4, e.getAdd1());
			ps2.setString(5, e.getAdd2());
			ps2.setString(6, e.getCity());
			ps2.setString(7, e.getPin());
			ps2.setString(8, e.getPhn());
			int b = ps2.executeUpdate();
			if (a > 0 && b > 0)
				return "Employee Created";
			else
				return "Employee not Created";

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "error";

	}

	public boolean isPresent(int id) {
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee_Table where EmpNo =" + id);
			rs.next();
			if (rs.getInt(1) == id) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee getDetails(int id) {
		try {
			Employee employee = new Employee();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from Employee_Table where EmpNo =" + id);
			if (rs.next()) {

				employee.setFname(rs.getString(2));
				employee.setLname(rs.getString(3));
				employee.setJoin(rs.getString(4));
				employee.setDesig(rs.getString(5));
				employee.setDept(rs.getString(6));
				employee.setSal(rs.getString(7));

				ResultSet rs2 = st.executeQuery("select * from Employee_Personal_Info where EmpNo =" + id);
				rs2.next();
				employee.setDob(rs2.getString(2));
				employee.setQual(rs2.getString(3));
				employee.setAdd1(rs2.getString(4));
				employee.setAdd2(rs2.getString(5));
				employee.setCity(rs2.getString(6));
				employee.setPin(rs2.getString(7));
				employee.setPhn(rs2.getString(8));
				/*
				 * System.out.println(rs2.getString(2)+" "+rs2.getString(3)
				 * +" "+rs2.getString(4)+" "+rs2.getString(5)
				 * +" "+rs2.getString(6)+" "+rs2.getString(7)
				 * +" "+rs2.getString(8));
				 */
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteEmployee(int id) {
		try {
			Employee employee = new Employee();
			Statement st = connection.createStatement();
			int r1 = st.executeUpdate("DELETE FROM Employee_Table where EmpNo=" + id);
			int r2 = st.executeUpdate("DELETE FROM Employee_Personal_Info where EmpNo=" + id);
			System.out.println(r1 + "  " + r2);
			if (r1 == 1 && r2 == 1) {

				return (true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String updateEmployee(int id, Employee e) {
		try {

			PreparedStatement ps1 = connection.prepareStatement(
					"UPDATE Employee_table SET  Fname=?, Lname=?, JoinDate=?, Designation=?, Dept=?, BasicSal=? WHERE EmpNo="
							+ id);
			ps1.setString(1, e.getFname());
			ps1.setString(2, e.getLname());
			ps1.setString(3, e.getJoin());
			ps1.setString(4, e.getDesig());
			ps1.setString(5, e.getDept());
			ps1.setString(6, e.getSal());
			int a = ps1.executeUpdate();

			PreparedStatement ps2 = connection.prepareStatement(
					"UPDATE Employee_Personal_Info SET DOB=?, EduQal=?, AddLine1=?, AddLine2=?, City=?, Pin=?, Phone=? WHERE EmpNo="
							+ id);

			ps2.setString(1, e.getDob());
			ps2.setString(2, e.getQual());
			ps2.setString(3, e.getAdd1());
			ps2.setString(4, e.getAdd2());
			ps2.setString(5, e.getCity());
			ps2.setString(6, e.getPin());
			ps2.setString(7, e.getPhn());
			int b = ps2.executeUpdate();
			if (a > 0 && b > 0)
				return "Employee Updated";
			else
				return "Employee not Updated";

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "error";

	}

	public ResultSet returnAllEmpDetails() {
		ResultSet rs = null;
		try {
			Statement s = connection.createStatement();
			rs = s.executeQuery("SELECT * FROM Employee_table LIMIT 100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet returnAllPersonalEmpDetails() {
		ResultSet rs = null;
		try {
			Statement s = connection.createStatement();
			rs = s.executeQuery("SELECT * FROM Employee_Personal_Info LIMIT 100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/*
	 * public static void main(String[] as) { EmployeeDao ed1=new EmployeeDao();
	 * //System.out.println(ed1.createEmployee("Rahul", "G", "02/08/2017",
	 * "Clerk", "Stores", "10000", " ", " ", " ", " ", " ", 0," "));
	 * 
	 * }
	 */

}
