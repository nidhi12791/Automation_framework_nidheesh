package practise_adv_auto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {
public static void main(String[] args) throws SQLException {

Driver driverRef=new Driver();
DriverManager.registerDriver(driverRef);
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/m4db", "mattummal", "mattummal");
Statement state=conn.createStatement();	
ResultSet result=state.executeQuery("select*from customer_info;");
while(result.next()) {
System.out.println(result.getInt(1)+" "+ result.getInt(2)+" "+  result.getInt(3));

}
conn.close();

}
	
}
