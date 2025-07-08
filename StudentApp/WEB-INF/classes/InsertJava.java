import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class InsertJava extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

try
{
String Regno = request.getParameter("T1");
String name = request.getParameter("T2");
String age = request.getParameter("T3");
String address = request.getParameter("T4");
String mobileno = request.getParameter("T5");
String emailid = request.getParameter("T6");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
String query = "insert into loginservletDB values(?,?,?,?,?,?)";
PreparedStatement st = cn.prepareStatement(query);
st.setString(1, Regno);
st.setString(2, name);
st.setString(3, age);
st.setString(4, address);
st.setString(5, mobileno);
st.setString(6, emailid);
st.executeUpdate();
out.println("<h1>Your Data is Successfully Added to Datadase</h1>"+"</br>");
out.println("<a href='Homepage.html'>Click Here to Home Page</a>");

}
catch(Exception e)
{
e.printStackTrace();
}
}
}
