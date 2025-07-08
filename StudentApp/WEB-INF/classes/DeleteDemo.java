import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class DeleteDemo extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
{
try
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String Uname = request.getParameter("T1");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
PreparedStatement st = cn.prepareStatement("delete from loginservlet where uname=?");
st.setString(1, Uname);
st.executeUpdate();
out.println("<h1>Your Data is Successfully Deleted to Datadase</h1>"+"</br>");
out.println("<a href='home.html'>Click Here to Home Page</a>");
}
catch(Exception e)
{
e.printStackTrace();
}
}
}}
