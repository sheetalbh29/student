package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DaoClass {

PreparedStatement ps;
ResultSet rs;
public boolean CheckStudent(String name, String pass) throws SQLException {
	System.out.println("after");
	Connection con=ConnectionProvider.getCon();
	System.out.println(con);
	ps=con.prepareStatement("select * from Student where name=? and password=?");
	ps.setString(1, name);
	ps.setString(2, pass);
	rs=ps.executeQuery();
	int i=0;
	while(rs.next()) {
		i++;
	}
	if(i>0) {
		return true;
	}
	else {
	return false;
}
	}
public void registerStudent(int id,String name,int age,String subject) throws SQLException {
	Connection con=ConnectionProvider.getCon();
	ps=con.prepareStatement("insert into StudentData values(?,?,?,?)");
	ps.setInt(1, id);
	ps.setString(2, name);
	ps.setInt(3, age);
	ps.setString(4, subject);
	int i=ps.executeUpdate();
	if(i>0) {
		System.out.println("inserted..");
	}
}
public ResultSet showData(String name) throws SQLException{
	Connection con=ConnectionProvider.getCon();
	ps=con.prepareStatement("select * from StudentData where name=?");
	ps.setString(1, name);
	ResultSet rs=ps.executeQuery();
	return rs;
}
}
