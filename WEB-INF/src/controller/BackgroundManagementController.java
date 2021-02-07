
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class BackgroundManagementController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			BackgroundManagementService backgroundManagement = new BackgroundManagementService(request, response);
        backgroundManagement.judge();
		}catch(Exception e){}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}