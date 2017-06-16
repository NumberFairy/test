/**
 * Copyright (c) 2017, www.wisdombud.com
 * All Rights Reserved.
 */
package com.wisdombud.alumni.codegen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 功能: TODO.<br/>
 * date: 2017年2月14日 下午2:19:27 <br/>
 *
 * @author pfhu
 * @version
 * @since JDK 1.7
 */
public class DBConnection {
	private Connection connection = null;

	public Connection sqlConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://192.168.163.50:3306/ERP", "ERP", "ERP");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * 功能: 执行sql语句<br/>
	 * date: 2017年2月14日 下午2:19:27 <br/>
	 *
	 * @author pfhu
	 * @version
	 * @since JDK 1.7
	 */ 
	public boolean executeSqlStatement(String sqlYuJu) {
		boolean ret = false;
		if (connection != null) {
			Statement stmt = null;
			try {
				connection.setAutoCommit(false);
				stmt = connection.createStatement();
				stmt.addBatch(sqlYuJu);
				stmt.executeBatch();
				connection.commit();
				ret = true;
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					connection.setAutoCommit(true);
					if (stmt != null) {
						stmt.close();
						stmt = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

}
