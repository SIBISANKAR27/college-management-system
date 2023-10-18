package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logg
 */
@WebServlet("/logg")
public class logg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("a");
		String pass=request.getParameter("b");
		try {
			String sql="Select * from staff_account where username='"+name+"'and password='"+pass+"'";
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","root");  
			PreparedStatement stmt=con.prepareStatement(sql);
	         ResultSet i=stmt.executeQuery();
	         while(i.next())
	         {
	        	String sname=i.getString("username");
	        	HttpSession s=request.getSession();
	        	s.setAttribute("uname",sname);  	 
	        	response.sendRedirect("teach");
       		}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	}

