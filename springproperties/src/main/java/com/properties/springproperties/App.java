package com.properties.springproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
    	Properties properties=new Properties();
    
    	properties.load(new FileInputStream("spring.Properties"));
    	
   Class.forName(properties.getProperty("database.Driver_class"));
   
   Connection connection = DriverManager.getConnection(properties.getProperty("database.url"),
		  properties.getProperty("database.username"),
		  properties.getProperty( "database.password"));
   Statement statement = connection.createStatement();
   ResultSet executeQuery = statement.executeQuery(properties.getProperty("query"));
while(executeQuery.next())
{
	System.out.println(executeQuery.getInt(1));
	System.out.println(executeQuery.getString(2));
	System.out.println(executeQuery.getDouble(3));
}
      System.out.println(properties);
    }
}
