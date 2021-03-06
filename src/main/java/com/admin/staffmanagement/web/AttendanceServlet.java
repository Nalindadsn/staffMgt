package com.admin.staffmanagement.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.staffmanagement.dao.AttendanceDao;
import com.admin.staffmanagement.user.Attendance;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @note Ramesh Fadatare
 */

@WebServlet("/")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttendanceDao userDAO;
	
	public void init() {
		userDAO = new AttendanceDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/":
				attendace(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/attendance":
				attendace(request, response);
				break;
			case "/user":
				attendaceUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void attendace(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String date =request.getParameter("date");
		
		
		List<Attendance> listUser1 = userDAO.selectAllUsers_date(date);
		request.setAttribute("listUser1", listUser1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendance.jsp");
		dispatcher.forward(request, response);
	}
	private void attendaceUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String uid =request.getParameter("uid");
		
		
		List<Attendance> listUser2 = userDAO.selectAllUsers_user(uid);
		request.setAttribute("listUser2", listUser2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendance-user.jsp");
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Attendance> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendance-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendance-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Attendance existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("attendance-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String staffId = request.getParameter("staffId");
		String note = request.getParameter("note");
		String attendedDate = request.getParameter("attendedDate");
		Attendance newUser = new Attendance(staffId, note, attendedDate);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String staffId = request.getParameter("staffId");
		String note = request.getParameter("note");
		String attendedDate = request.getParameter("attendedDate");

		Attendance book = new Attendance(id, staffId, note, attendedDate);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	}

}