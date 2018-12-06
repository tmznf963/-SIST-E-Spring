package com.example.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.example.vo.Employee;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisRead {
	public static void main(String[] args) {
		Reader rd = null;
		SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			/* This would read all records from the Employee table. */
			System.out.println("Going to read records.....");
			List<Employee> ems = (List<Employee>) smc.queryForList("Employee.getAll", null);// namespace , queryForList == selectAll
			for (Employee e : ems) {
				System.out.print(" " + e.getId());
				System.out.print(" " + e.getFirst_name());
				System.out.print(" " + e.getLast_name());
				System.out.print(" " + e.getSalary());
				System.out.println("");
			}
			System.out.println("Records Read Successfully ");
		} catch (IOException | SQLException e) {
			System.out.println(e);
		}
	}
}
