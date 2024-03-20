package Table;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/done")
public class CheackBalance1 extends HttpServlet {
	Connection con;
	@Override
		public void init() throws ServletException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","krishna");
		System.out.println("Done");
		}catch(Exception e) {System.out.println("sorry");}
		}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 PrintWriter pw=resp.getWriter();
	int ano=Integer.parseInt(req.getParameter("ac"));
	 int pin=Integer.parseInt(req.getParameter("ps"));
	try {
		PreparedStatement pt=con.prepareStatement("select * from atm where ACCOUNTNO=? and  PIN=?");
		pt.setLong(1,ano);
		pt.setInt(2, pin);
		ResultSet rs=pt.executeQuery();
		if(rs.next()) {
			if(ano==rs.getInt("ACCOUNTNO") && pin==rs.getLong("PIN")) {
				
				pw.println(rs.getInt("ACCOUNTNO"));
				pw.println(rs.getLong("PIN"));
				pw.println(rs.getString("NAME"));
				pw.println(rs.getString("BALANCE"));
			}
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
}
