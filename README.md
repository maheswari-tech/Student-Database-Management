A web-based Java EE application built using JSP and Servlets, this project helps manage student records efficiently. It supports key operations such as insertion, deletion, update, and viewing of student details via a simple and user-friendly interface.

🛠️ Features
🔍 View existing student records

➕ Add new student information

📝 Update student data

❌ Delete student records

📂 JSP pages for clean UI

🧩 Servlet integration for backend logic

🔐 Basic Authentication via web.xml security constraints

📁 Project Structure
bash
Copy
Edit
student-data-management/
├── InsertDetail.jsp      # Form to insert student details
├── UpdateDemo.jsp        # Interface to update student data
├── UpdateDetails.jsp     # Handles updated student data
├── Delete.jsp            # Form to select student record for deletion
├── DeleteDetails.jsp     # Deletes selected student entry
├── home.jsp              # Homepage with navigation options
├── ServletDB.jsp         # Backend logic using Servlet
├── web.xml               # Deployment descriptor with security configs

🚀 Technologies Used
Java EE (JSP & Servlets)
Apache Tomcat (Servlet container)
HTML/CSS (for styling JSP pages)
XML (web.xml for configuration)

Deploy to Apache Tomcat Server.

Access via:

bash
Copy
Edit
http://localhost:8080/student-data-management/home.jsp
🔒 Security
The web.xml file includes basic role-based access for pages under /private/ and /registered/ directories, restricting them to users with the guest role.

