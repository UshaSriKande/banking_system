import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
public class LoginServlet extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String acno = req.getParameter("acno");
String pwd = req.getParameter("pwd");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false&allowPublicKeyRetrieval=true","root","Kande@123");
Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery("select * from cus2 where baccno='"+acno+"'and password='"+pwd+"'");
if(rs.next()){
res.sendRedirect("index.html");
}
else{
out.print("<center><h1>Username or password are wrong...</h1></center>");
}
con.close();
}catch(Exception e){
System.out.println(e.getMessage());
}
}
}