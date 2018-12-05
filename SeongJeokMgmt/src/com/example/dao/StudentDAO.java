package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.vo.Student;

public class StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int create(Student s) {
		String sql = "INSERT INTO Student(hakbun, name, kor, eng, mat, edp, sum, avg, grade) "+
						"VALUES('"+s.getHakbun()+"','"+s.getName()+"','"+s.getKor()+"','"+s.getEng()+"','"+s.getMat()+"','"+s.getEdp()+"','"+s.getSum()+"','"+s.getAvg()+"','"+s.getGrade()+"')";
		//System.out.println(sql);
		return this.jdbcTemplate.update(sql);
	}
	public int update(Student s){String sql = "UPDATE Student SET kor = " + s.getKor() + ", eng = " + s.getEng() +
	          ", mat = " + s.getMat() + ", edp = " + s.getEdp() + ", " +
	          "sum = " + s.getSum() + ", avg = " + s.getAvg() + ", " +
	          "grade = '" + s.getGrade() + "' WHERE hakbun = '" + s.getHakbun() + "' ";
			//System.out.println(sql);
		return this.jdbcTemplate.update(sql);
	}
	public int delete(String hakbun){
		String sql ="DELETE FROM Student WHERE hakbun = '"+hakbun+"'";
		return this.jdbcTemplate.update(sql);
	}
	public List<Student> readAll(){
		String sql = "SELECT * FROM Student ORDER BY sum DESC";
		List<Student> list = this.jdbcTemplate.query(sql, new MyRowMapper());
		return list;
	}
	private class MyRowMapper implements RowMapper<Student>{
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student s = new Student();
			s.setHakbun(rs.getString("hakbun"));
			s.setName(rs.getString("name"));
			s.setKor(rs.getInt("kor"));
			s.setEng(rs.getInt("eng"));
			s.setMat(rs.getInt("mat"));
			s.setEdp(rs.getInt("edp"));
			s.setSum(rs.getInt("sum"));
			s.setAvg(rs.getDouble("avg"));
			s.setGrade(rs.getString("grade").charAt(0)); // String -> char
			return s;
		}
	}
	public Student read(String hakbun){
		String sql = "SELECT * FROM Student WHERE hakbun = '"+hakbun+"'";
		Student student = this.jdbcTemplate.queryForObject(sql, new MyRowMapper());
		return student;
	}
}
