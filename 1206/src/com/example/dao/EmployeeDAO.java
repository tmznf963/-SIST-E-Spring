package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.example.vo.EmployeeVO;

public class EmployeeDAO {
	/*private JdbcTemplate jdbcTemplate;*/
	private NamedParameterJdbcTemplate namedTemplate;

	public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
		this.namedTemplate = namedTemplate;
	}
	
	public Integer update(EmployeeVO employeeVO) {
		String sql = "UPDATE emp SET name = :name , salary = :salary WHERE id = :id";
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", employeeVO.getName());//sql문에 값 넣기
		paramMap.put("salary", employeeVO.getSalary());
		paramMap.put("id", employeeVO.getId());
		return this.namedTemplate.execute(sql, paramMap, 
					new PreparedStatementCallback<Integer>() {
						@Override
						public Integer doInPreparedStatement(PreparedStatement ps)
								throws SQLException, DataAccessException {
							return ps.executeUpdate();
						}
					});
	}

/*	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
/*	public Boolean insert(final EmployeeVO employeeVO) {
		String sql = "INSERT INTO emp VALUES(?,?,?)";
		return this.jdbcTemplate.execute(sql, 
				new PreparedStatementCallback<Boolean>() {
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
							ps.setInt(1, employeeVO.getId());
							ps.setString(2, employeeVO.getName());
							ps.setDouble(3, employeeVO.getSalary());
						return ps.execute();//true & false
					}		
		});
	}*/
	
/*	public List<EmployeeVO> readAll(){
		return this.jdbcTemplate.query("SELECT * FROM emp ORDER BY salary DESC", 
				new ResultSetExtractor<List<EmployeeVO>>(){
					@Override
					public List<EmployeeVO> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<EmployeeVO> list = new ArrayList<EmployeeVO>();
						if(!rs.next()) list = null;
						else {
							do {
								list.add(new EmployeeVO(rs.getInt("id"),rs.getString("name"),rs.getDouble("salary")));
							}while(rs.next());
						}
						return list;
					}
		});
	}*/
	
/*	public EmployeeVO read(int id) {
		String sql = "SELECT * FROM emp WHERE id = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] {id}, 
				new RowMapper<EmployeeVO>() {
					@Override
					public EmployeeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						EmployeeVO employeeVO = new EmployeeVO();
						employeeVO.setId(id);
						employeeVO.setName(rs.getString("name"));
						employeeVO.setSalary(rs.getDouble("salary"));
						return employeeVO;
					}
			
		});
	}*/

}
