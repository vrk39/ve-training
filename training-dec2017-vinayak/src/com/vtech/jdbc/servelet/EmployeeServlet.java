package com.vtech.jdbc.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vtech.jdbc.dao.EmployeeForDAO;
import com.vtech.jdbc.dao.LoginForDAO;
import com.vtech.jdbc.helper.EmployeeBean;

public class EmployeeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeBean objEmployee = new EmployeeBean();
		EmployeeForDAO objEmpDAO = new EmployeeForDAO();
		String formName = request.getParameter("form-name");
		int empid;
		if (formName.equals("addemployee")) {
			objEmployee.setFirstName(request.getParameter("firstname"));
			objEmployee.setLastName(request.getParameter("lastname"));
			objEmployee.setCompany(request.getParameter("company"));
			objEmployee.setAge(Integer.parseInt(request.getParameter("age")));
			objEmployee.setPhoneNo(request.getParameter("phoneno"));
			objEmployee.setAddress(request.getParameter("address"));
			objEmployee.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
			objEmployee.setSalary(Double.parseDouble(request.getParameter("salary")));
			try {
				objEmpDAO.addEmployeeInformation(objEmployee);
				empid = objEmpDAO.getEmployeeID(request.getParameter("phoneno"));
				PrintWriter printWriter = response.getWriter();
				printWriter.println("new empid:");
				printWriter.println(empid);
			} catch (SQLException sqlException) {
				System.out.println("ERROR in add employee try again.");
			}

		}

		if (formName.equals("login")) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			LoginForDAO objLoginDao = new LoginForDAO();
			try {
				boolean success = objLoginDao.checkLoginCredential(userName, password);
				if (success) {
					HttpSession session = request.getSession();
					session.setAttribute("username", userName);
					
					response.sendRedirect("loginsuccess.jsp");

				} else {
					// objPrintWriter.println("username or password wrong try
					// again");
					RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/loginform.jsp");
					requestDispatcher.include(request, response);
				}
			} catch (SQLException objSqlException) {
				System.out.println("error in check login credential");
			}

		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("loginform.jsp");
	}
}
