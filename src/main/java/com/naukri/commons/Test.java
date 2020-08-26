package com.naukri.commons;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.naukri.pageobjects.NaukriExpBasicDetailsPage;

public class Test {
String name;
private final static Logger LOGGER = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		 Connection con=MySqlDBConnection.getConnnection();
		System.out.println(con);
		LOGGER.info("connection object----" +con);
		
		
	}

}
