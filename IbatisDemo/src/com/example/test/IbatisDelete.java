package com.example.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.example.vo.Employee;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisDelete {
	public static void main(String[] args) {
		Reader rd = null;
		SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			/* This would delete one record in Employee table. */
			System.out.println("Going to delete record.....");
			Scanner scan = new Scanner(System.in);
			System.out.println("DELETE id : "); 	int id = scan.nextInt();
			
			smc.delete("Employee.delete", id);
			System.out.println("Record deleted Successfully ");
			List<Employee> list = (List<Employee>) smc.queryForList("Employee.getAll", null);
			for (Employee emp : list) {
				System.out.println(emp);
			}
		} catch (IOException | SQLException e) {
			System.out.println(e);
		}
		System.out.println("Records Read Successfully ");
	}
}
