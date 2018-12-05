package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.UserVO;

@Repository("userDAO") //자신 ID service에서 부를
public class UserDAOImplJDBC implements UserDAO {
	//private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired //xml에서 dataSource가 바인딩
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void create(UserVO userVO) {//insert
		String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, userVO.getUserid(), userVO.getName(), 
														userVO.getGender(), userVO.getCity());
		System.out.println("등록된 Record UserId = " + userVO.getUserid() + " Name = " +userVO.getName());
	}

	@Override
	public UserVO read(String userid) {
		String sql ="SELECT * FROM users WHERE userid=?";
		//한개의 DB값만 조회할 경우
		UserVO userVO = 
				this.jdbcTemplate.queryForObject(sql, new Object[] {userid} , new MyRowMapper());
		return userVO;

	}
	//innerClass
	private class MyRowMapper implements RowMapper<UserVO>{
		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO userVO = new UserVO();
			userVO.setUserid(rs.getString("userid"));//set == setter || rs.get == dbColumn
			userVO.setName(rs.getString("name"));
			userVO.setGender(rs.getString("gender"));
			userVO.setCity(rs.getString("city"));
			return userVO;
		}
	}

	@Override
	public List<UserVO> readAll() {
		String sql = "SELECT * FROM users ORDER BY userid DESC";
		List<UserVO> list = this.jdbcTemplate.query(sql,	new MyRowMapper());
		return list;
	}

	@Override
	public void update(String userid, String city) {
		String sql = "UPDATE users SET city=? WHERE userid=?";
		this.jdbcTemplate.update(sql,city,userid);
	}

	@Override
	public void delete(String userid) {
		String sql ="DELETE FROM users WHERE userid =?";
		this.jdbcTemplate.update(sql,userid);
	}

}
