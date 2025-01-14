package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.vo.UserVO;

@Repository("userDAO")
public class UserDAOImplJDBC implements UserDAO{
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void create(UserVO userVO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = "INSERT INTO users VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getUserid());
			pstmt.setString(2, userVO.getName());
			pstmt.setString(3, userVO.getGender());
			pstmt.setString(4, userVO.getCity());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException ex) {}
		}
	}

	@Override
	public UserVO read(String userid) {
		UserVO userVO = new UserVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = "SELECT * FROM users WHERE userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) userVO = null;
			else {//찾았다면
				userVO.setUserid(userid);
				userVO.setName(rs.getString("name"));
				userVO.setGender(rs.getString("gender"));
				userVO.setCity(rs.getString("city"));
			}
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException ex) {}
		}
		return userVO;
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> list = new ArrayList<UserVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users ORDER BY userid DESC");
			while(rs.next()) {
				UserVO user = new UserVO(rs.getString("userid"),rs.getString("name"),rs.getString("gender"),rs.getString("city"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(SQLException ex) {}
		}
		return list;
	}

	@Override
	public void update(String userid, String city) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = "UPDATE users SET city = ? WHERE userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			}catch(SQLException e) {}
		}
	}

	@Override
	public void delete(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.dataSource.getConnection();
			String sql = "DELETE FROM users WHERE userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException ex) {}
		}
	}
}

