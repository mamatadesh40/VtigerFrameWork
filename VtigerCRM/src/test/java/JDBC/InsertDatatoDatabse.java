package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDatatoDatabse {

	public static void main(String[] args) throws Throwable {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Qspiders_info","root","root");
		 
		 Statement stat = connection.createStatement();
		
		String query = " insert into sdet(empName,empId,phoneNumber,emailID,address)values('Khushi',1002,257861675,'abc@gmail.com','Melbourne')";
		
		int result = stat.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("not updated");
		}

	}

}
