package ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;



public class UserService {

	private Connection conn;

	public UserService() {
		conn = ConnectionFactory.getConnection();
	}


	public int registerUser(String username, String password,String email,String name) {

		String sql = "insert into users(username, password,email,name) values(?,?,?,?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3,email );
			stmt.setString(4, name);
			if (stmt.executeUpdate() > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
					return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	
	public int loginUser(String username, String password) {
		String sql = "select * from users where username=? and password=? ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next())
				return rs.getInt("id");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public User getUserDetailsById(int id) {
		User user;
		String sql = "select * from users where id=?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setId(id);
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public int addImage(String fileName, int userId) {

		String sql = "insert into images(file_name, user_id ) values (?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, fileName);
			stmt.setInt(2, userId);

			if (stmt.executeUpdate() > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
					return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public int DeleteImage(String fileName, int userId) {

		String sql = "delete from images where id=? ";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		

			if (stmt.executeUpdate() > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next())
					return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}
	public ArrayList<String> getFileNames(int userId) {
		ArrayList<String> fileNames = new ArrayList<>();
		String sql = "select file_name from images where user_id=?";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				fileNames.add(rs.getString("file_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fileNames;
	}

}
