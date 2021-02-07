
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			TestService teService = new TestService(request, response);
            teService.judge();
		}catch(Exception e){}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}