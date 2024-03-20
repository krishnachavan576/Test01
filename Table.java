package Table;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/table1")
public class Table extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		pw.println("<body bgcolor=red><tbody>");
		int no= Integer.parseInt(req.getParameter("num1"));
		for(int i=1;i<=10;i++) {
			pw.println("<th>"+no+"*"+i+"="+no*i+"</th> <br><br>");
			pw.println();
			pw.println("</tbody></body>");
			
		}
		
	}

}
