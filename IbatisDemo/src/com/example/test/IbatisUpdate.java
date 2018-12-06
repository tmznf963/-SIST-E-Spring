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

public class IbatisUpdate {
	public static void main(String[] args) {
		Reader rd = null;
		SqlMapClient smc =  null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			System.out.println("Going to update record.....");
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter a id to update : ");  int id = scan.nextInt();
			System.out.print("Enter a first name : ");   String firstName = scan.next();
			System.out.print("Enter a last name : ");   String lastName = scan.next();
			System.out.print("Enter a salary : ");   int salary = scan.nextInt();
			Employee emp = new Employee(firstName, lastName, salary);
			emp.setId(id);
			
			smc.update("Employee.update", emp);
			List<Employee> list = (List<Employee>)smc.queryForList("Employee.getAll");
			for(Employee e : list) {
				System.out.println(e);
			}
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
		System.out.println("Records Read Successfully ");
	}
}
