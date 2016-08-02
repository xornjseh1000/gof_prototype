package global;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/account.do")
public class GlobalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		HttpSession session = request.getSession();
		switch (Separator.command.getAction()) {
		case "move":
			
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "browse_main":
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		default:
			break;
		}
		DispatcherServlet.send(request,response,Separator.command);			
	}

}
