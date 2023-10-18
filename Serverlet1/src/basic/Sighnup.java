package basic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sighnup
 */
@WebServlet("/Sighnup")
public class Sighnup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sighnup() {
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
		String n=request.getParameter("first");
		String d=request.getParameter("dep");
		String m=request.getParameter("emai");
		String c=request.getParameter("cont");
		String u=request.getParameter("user");
		String i=request.getParameter("id");
		String p=request.getParameter("pass");
		try {
			String sql="insert into staff_account(employeeid,name,department,email,contact,username,password)values('"+i+"','"+n+"','"+d+"','"+m+"','"+c+"','"+u+"','"+p+"')";
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","root");  
			PreparedStatement stmt=con.prepareStatement(sql);
	         int i1=stmt.executeUpdate();
	         if(i1==1)
       		{
       			System.out.println("success");
       		}
		} catch (Exception e) {
			System.out.println(e);
			
		}
	}

}
