package com.naukri.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
	public static Connection getConnnection() throws ClassNotFoundException, SQLException {
		Class.forName(NaukriConstants.MYSQL_DRIVER);
		Connection con = DriverManager.getConnection(NaukriConstants.IP_PORT + NaukriConstants.DB_NAME,
				NaukriConstants.USER_NAME, NaukriConstants.PASSWORD);
		return con;

	}

}
