import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class ViewSpeLoginJava extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
{
try
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String Regno = request.getParameter("T1");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
PreparedStatement st = cn.prepareStatement("select * from loginservletDB where Regno=?");
st.setString(1, Regno);
ResultSet rs = st.executeQuery();
while (rs.next())
{
    out.println("**************************************" + "<br>");
                out.println("Register no    :  "  +  rs.getString(1) + "<br>");
                out.println("Name    :  "  +  rs.getString(2) + "<br>");
                out.println("Age    :  "  +  rs.getString(3) + "<br>");
                out.println("Address    :  "  +  rs.getString(4) + "<br>");
                out.println("Phone no.   :  "  +  rs.getString(5) + "<br>");
                out.println("EmailId : " + rs.getString(6) + "<br>");
}
rs.close();
out.println("<a href='Homepage.html'>Click Here to Home Page</a>");
}
catch(Exception e)
{
e.printStackTrace();
}
}
}}
