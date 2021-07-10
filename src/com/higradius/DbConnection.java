package com.higradius;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static final String URL="jdbc:mysql://localhost/hrc";
	public static final String user_Name="root";
	public static final String pass="Biswa@8534";
	static Connection con;
	
	public static Connection connection() throws ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		try 
		{
			con=DriverManager.getConnection(URL, user_Name, pass);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return con;
}
}
