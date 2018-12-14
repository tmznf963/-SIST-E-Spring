package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int create(MemberVO memberVo) {
		String sql = "INSERT INTO Member VALUES(?,?,?,?,?)";
		return this.jdbcTemplate.update(sql, memberVo.getUserid(), memberVo.getUsername(), memberVo.getUserage(),
				memberVo.getGender(), memberVo.getCity());
	}

	@Override
	public MemberVO read(String userid) {
		String sql = "SELECT * FROM Member WHERE userid=?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { userid }, new MyRowMapper());
	}

	class MyRowMapper implements RowMapper<MemberVO> {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO memberVO = new MemberVO(rs.getString("userid"), rs.getString("username"), rs.getInt("userage"),
					rs.getString("gender"), rs.getString("city"));
			return memberVO;
		}
	}

	@Override
	public List<MemberVO> readAll() {
		String sql = "SELECT * FROM Member ORDER BY userid DESC";
		return this.jdbcTemplate.query(sql, new MyRowMapper());
	}

	@Override
	public int update(MemberVO memberVO) {
		String sql = "UPDATE Member SET userage = ?, gender = ?, city = ? WHERE userid = ?";
		return this.jdbcTemplate.update(sql, memberVO.getUserage(), memberVO.getGender(), 
																			memberVO.getCity(), memberVO.getUserid());
	}

	@Override
	public int delete(String userid) {
		String sql = "DELETE FROM Member WHERE userid = ?";
		return this.jdbcTemplate.update(sql, userid);
	}

}
