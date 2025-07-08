import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateJava extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection cn = null;
        PreparedStatement st = null;

        try {
            // Retrieve parameters from the request
            String regno = request.getParameter("T1");
            String name = request.getParameter("T2");
            String age = request.getParameter("T3");
            String address = request.getParameter("T4");
            String mobileno = request.getParameter("T5");
            String emailid = request.getParameter("T6");

            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish a connection to the database
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

            // Prepare the SQL update query
            String sql = "UPDATE loginservletDB SET name = ?, age = ?, address = ?, mobileno = ?, emailid = ? WHERE regno = ?";
            st = cn.prepareStatement(sql);

            // Set parameters for the SQL query
            st.setString(1, name);
            st.setString(2, age);
            st.setString(3, address);
            st.setString(4, mobileno);
            st.setString(5, emailid);
            st.setString(6, regno);

            // Execute the update
            int rowsUpdated = st.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                out.println("<h1>Your Data is Successfully Updated in the Database</h1></br>");
            } else {
                out.println("<h1>Error: Data was not updated. Please check the registration number.</h1>");
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
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                out.println("<h1>Error: Failed to close database resources</h1>");
                e.printStackTrace(out);
            }
        }
    }
}

