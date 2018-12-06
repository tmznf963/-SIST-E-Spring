package com.example.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.example.vo.Employee;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisInsert {
	public static void main(String[] args) {
		Reader rd = null ; SqlMapClient smc = null;
		try {
			rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			/* This would insert one record in Employee table. */
			System.out.println("Going to insert record.....");
			Employee em = new Employee("미자", "이", 3000);
			smc.insert("Employee.insert", em);
			System.out.println("Record Inserted Successfully ");
		}catch(IOException | SQLException e) {
			System.out.println(e);
		}
	}
}
