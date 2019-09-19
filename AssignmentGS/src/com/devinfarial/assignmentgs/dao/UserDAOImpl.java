package com.devinfarial.assignmentgs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.devinfarial.assignmentgs.model.User;

public class UserDAOImpl implements UserDAO {
	
	private JdbcTemplate jdbcTemp;
	
	public UserDAOImpl(DataSource dataSource) {
		this.jdbcTemp = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(User user) {
		String sql="INSERT INTO user(user_name, user_email, user_password, role, status) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemp.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getStatus());
	}

	@Override
	public int update(User user) {
		String sql="UPDATE user SET user_name=?, user_email=?, user_password=?, role=?, status=? WHERE user_id=?";
		return jdbcTemp.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole(), user.getStatus(), user.getId());
	}

	@Override
	public User get(Integer id) {
		String sql="SELECT * FROM user WHERE user_id=" + id;
		ResultSetExtractor<User> exc = new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("user_name");
					String email = rs.getString("user_email");
					String password = rs.getString("user_password");
					String role = rs.getString("role");
					String status = rs.getString("status");
					
					return new User(id, name, email, password, role, status);
				}
				return null;
			}
			
		};
		return jdbcTemp.query(sql, exc);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM user WHERE user_id="+id;
		return jdbcTemp.update(sql);
	}

	@Override
	public List<User> list() {
		String sql = "SELECT * FROM user";
		
		RowMapper rm = new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("user_id");
				String name = rs.getString("user_name");
				String email = rs.getString("user_email");
				String password = rs.getString("user_password");
				String role = rs.getString("role");
				String status = rs.getString("status");
				
				return new User(id, name, email, password, role, status);
			}
		};
		
		return jdbcTemp.query(sql,rm);
	}
	
	public User validateUser(User user) {
		String sql="SELECT * FROM user WHERE user_email=  '" + user.getEmail() + "' AND user_password = '"  + user.getPassword() + "'";	
		ResultSetExtractor<User> exc = new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {

					Integer id = rs.getInt("user_id");
					String name = rs.getString("user_name");
					String email = rs.getString("user_email");
					String password = rs.getString("user_password");
					String role = rs.getString("role");
					String status = rs.getString("status");
					
					return new User(id, name, email, password, role, status);
				}
				return null;
			}
			
		};
		
		return jdbcTemp.query(sql, exc);
	}

}
