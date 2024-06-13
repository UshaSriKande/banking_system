import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;  
public class HistoryServlet extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body>");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","Kande@123");
Statement stm = con.createStatement();
ResultSet rs=stm.executeQuery("select * from history");
out.println("<center><table width=100% height=100% border=1>");
out.println("<thead><th>TRANSACTION FROM</th><th>TRANSACTION TO</th><th>AMOUNT</th><th>TIME</th><th>STATUS</th><thead>");
while(rs.next()){
out.println("<tr><td>" + rs.getString(1) + "</td>");  
out.println("<td>" + rs.getString(2) + "</td>"); 
out.println("<td>" + rs.getInt(3) + "</td>"); 
out.println("<td>" + rs.getString(4) + "</td>"); 
out.println("<td>" + rs.getString(5) + "</td></tr>"); 
}
out.println("</table></center>");  
out.println("</html></body>");  
con.close();
}
catch(Exception e){
System.out.println(e.getMessage());
}
}
}