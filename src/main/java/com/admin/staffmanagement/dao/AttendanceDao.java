package com.admin.staffmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.staffmanagement.user.Attendance;



public class AttendanceDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO attendance" + "  (staffId, note, attendedDate) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,staffId,note,attendedDate from attendance where id =?";
	private static final String SELECT_ALL_USERS = "select * from attendance";
	private static final String DELETE_USERS_SQL = "delete from attendance where id = ?;";
	private static final String UPDATE_USERS_SQL = "update attendance set staffId = ?,note= ?, attendedDate =? where id = ?;";


	public AttendanceDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Attendance user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getStaffId());
			preparedStatement.setString(2, user.getNote());
			preparedStatement.setString(3, user.getAttendedDate());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}


	
	public Attendance selectUser(int id) {
		Attendance user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String staffId = rs.getString("staffId");
				String note = rs.getString("note");
				String attendedDate = rs.getString("attendedDate");
				user = new Attendance(id, staffId, note, attendedDate);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Attendance> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Attendance> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String staffId = rs.getString("staffId");
				String note = rs.getString("note");
				String attendedDate = rs.getString("attendedDate");
				String created_at = rs.getString("created_at");
				users.add(new Attendance(id, staffId, note, attendedDate,created_at));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public List<Attendance> selectAllUsers_date(String date) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Attendance> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from attendance where attendedDate='"+date+"'");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String staffId = rs.getString("staffId");
				String note = rs.getString("note");
				String attendedDate = rs.getString("attendedDate");
				String created_at = rs.getString("created_at");
				users.add(new Attendance(id, staffId, note, attendedDate,created_at));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	public List<Attendance> selectAllUsers_user(String uid) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Attendance> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from attendance where staffId='"+uid+"'");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String staffId = rs.getString("staffId");
				String note = rs.getString("note");
				String attendedDate = rs.getString("attendedDate");
				String created_at = rs.getString("created_at");
				users.add(new Attendance(id, staffId, note, attendedDate,created_at));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Attendance user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getStaffId());
			statement.setString(2, user.getNote());
			statement.setString(3, user.getAttendedDate());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
}
