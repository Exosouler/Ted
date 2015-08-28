package ted;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Driver db = new Driver();
		PrintWriter out = response.getWriter();
		db.Connect();
		String name = request.getParameter("Name");
		String Email = request.getParameter("Email");
		if (db.Checkuser(name, Email)){
			db.insertUser(name, Email);
			out.println("<h1>Success</h1>");
		}
		else
			out.println("<h1>Fail</h1>");
		db.Close();
	}

}
