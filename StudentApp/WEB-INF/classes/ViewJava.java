import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ViewJava extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

            // Prepare the SQL query
            st = cn.prepareStatement("SELECT * FROM loginservletDB");
            rs = st.executeQuery();

            // Print the result set
            while (rs.next()) {
                out.println("**************************************" + "<br>");
                out.println("Register no    :  "  +  rs.getString(1) + "<br>");
                out.println("Name    :  "  +  rs.getString(2) + "<br>");
                out.println("Age    :  "  +  rs.getString(3) + "<br>");
                out.println("Address    :  "  +  rs.getString(4) + "<br>");
                out.println("Phone no.   :  "  +  rs.getString(5) + "<br>");
                out.println("EmailId : " + rs.getString(6) + "<br>");
            }

            // Provide a link to the home page
            out.println("<a href='Homepage.html'>Click Here to Home Page</a>");
        } catch (ClassNotFoundException e) {
            out.println("<h1>Error: JDBC Driver not found</h1>");
            e.printStackTrace(out);
        } catch (SQLException e) {
            out.println("<h1>Error: SQL Exception occurred</h1>");
            e.printStackTrace(out);
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                out.println("<h1>Error: Failed to close database resources</h1>");
                e.printStackTrace(out);
            }
        }
    }
}

