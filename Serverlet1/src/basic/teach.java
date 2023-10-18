package basic;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class teach
 */
@WebServlet("/teach")
public class teach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession s=request.getSession(false);
//		String n=s.getAttribute("uname").toString();
//		System.out.println(n);
		try {
			HttpSession s=request.getSession(false);
			String n=s.getAttribute("uname").toString();
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","root");  
			String sql2="SELECT * FROM staff_account WHERE username='"+n+"'";
//			PreparedStatement stmt=con.prepareStatement(sql2);
			Statement stmt=con.createStatement();
	         ResultSet j=stmt.executeQuery(sql2);
	         
	         while(j.next())
	         {
	        	 
	        	 PrintWriter p=response.getWriter();
	        	 p.print("<!DOCTYPE html>\r\n" + 
	        	 		"<html lang=\"en\">\r\n" + 
	        	 		"<head>\r\n" + 
	        	 		"    <meta charset=\"UTF-8\">\r\n" + 
	        	 		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
	        	 		"    <title>Document</title>\r\n" + 
	        	 		"</head>\r\n" + 
	        	 		"<style>\r\n" + 
	        	 		"    body{\r\n" + 
	        	 		"            background-image: url(zhanhui-li-1iuxWsIZ6ko-unsplash.jpg); \r\n" + 
	        	 		"            background-size: cover;\r\n" + 
	        	 		"    }\r\n" + 
	        	 		"    nav{\r\n" + 
	        	 		"          display: flex;\r\n" + 
	        	 		"          padding: 2% 6%;\r\n" + 
	        	 		"          justify-content: space-between;\r\n" + 
	        	 		"          align-items: center;\r\n" + 
	        	 		"    }\r\n" + 
	        	 		"    .menu\r\n" + 
	        	 		"        {\r\n" + 
	        	 		"            flex: 1;\r\n" + 
	        	 		"            text-align: right;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"        .menu ul li{\r\n" + 
	        	 		"            list-style: none;\r\n" + 
	        	 		"            display: inline-block;\r\n" + 
	        	 		"            padding: 8px 12px;\r\n" + 
	        	 		"            position: relative;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"        .menu ul li a{\r\n" + 
	        	 		"            text-decoration: none;\r\n" + 
	        	 		"            color: blanchedalmond;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"        .menu ul li a:hover{\r\n" + 
	        	 		"            color: red;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"        body {\r\n" + 
	        	 		"            font-family: Arial, sans-serif;\r\n" + 
	        	 		"            margin: 0;\r\n" + 
	        	 		"            padding: 0;\r\n" + 
	        	 		"            justify-content: center;\r\n" + 
	        	 		"            align-items: center;\r\n" + 
	        	 		"            height: 100vh;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"\r\n" + 
	        	 		"        .dashboard {\r\n" + 
	        	 		"            background-color:rgba(0, 0, 0, 0.5);\r\n" + 
	        	 		"            border: 1px solid #ddd;\r\n" + 
	        	 		"            border-radius: 5px;\r\n" + 
	        	 		"            padding: 40px;\r\n" + 
	        	 		"            width: 300px;\r\n" + 
	        	 		"            height: 400px;\r\n" + 
	        	 		"            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);\r\n" + 
	        	 		"            text-align: justify;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"\r\n" + 
	        	 		"        .dashboard h1 {\r\n" + 
	        	 		"            text-align: center;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"\r\n" + 
	        	 		"        .teacher-details {\r\n" + 
	        	 		"            display: flex;\r\n" + 
	        	 		"            flex-direction: column;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"\r\n" + 
	        	 		"        .teacher-details label {\r\n" + 
	        	 		"            font-weight: bold;\r\n" + 
	        	 		"            margin-top: -10px;\r\n" + 
	        	 		"            color: #ddd;\r\n" + 
	        	 		"            margin-left: -30px;\r\n" + 
	        	 		"            padding: 20px;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"\r\n" + 
	        	 		"        .teacher-details p {\r\n" + 
	        	 		"            margin: 0;\r\n" + 
	        	 		"            color: whitesmoke;\r\n" + 
	        	 		"        }\r\n" + 
	        	 		"</style>\r\n" + 
	        	 		"<body>\r\n" + 
	        	 		"    <section class=\"header\">\r\n" + 
	        	 		"        <nav>\r\n" + 
	        	 		"            <div class=\"menu\">\r\n" + 
	        	 		"                <ul>\r\n" + 
	        	 		"                    <li><a href=\"\">HOME</a></li>\r\n" + 
	        	 		"                    <li><a href=\"reg3.html\">STUDENT</a></li>\r\n" + 
	        	 		"                    <li><a href=\"\">LOGIN</a></li>\r\n" + 
	        	 		"                </ul>\r\n" + 
	        	 		"            </div>\r\n" + 
	        	 		"        </nav>\r\n" + 
	        	 		"    </section>\r\n" + 
	        	 		"    <div class=\"dashboard\">\r\n" + 
	        	 		"        <h1>Teacher Dashboard</h1>\r\n" + 
	        	 		"        <div class=\"teacher-details\">\r\n" + 
	        	 		"            <label>Name:</label>\r\n" + 
	        	 		"            <p>"+j.getString("username")+"</p>\r\n" + 
	        	 		"            <label>Department:</label>\r\n" + 
	        	 		"            <p>"+j.getString("department")+"</p>\r\n" + 
	        	 		"            <label>Email</label>\r\n" + 
	        	 		"            <p>"+j.getString("email")+"</p>\r\n" + 
	        	 		"            <label>Contact:</label>\r\n" + 
	        	 		"            <p>"+j.getString("contact")+"</p>\r\n" + 
	        	 		"            <label>Employee ID:</label>\r\n" + 
	        	 		"            <p>"+j.getString("employeeid")+"</p>\r\n" + 
	        	 		"        </div>\r\n" + 
	        	 		"    </div>\r\n" + 
	        	 		"    \r\n" + 
	        	 		"\r\n" + 
	        	 		"</body>\r\n" + 
	        	 		"</html>");
	         }
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
