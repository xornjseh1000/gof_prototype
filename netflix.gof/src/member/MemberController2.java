package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import global.DispatcherServlet;
import global.Separator;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member.do")
public class MemberController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		HttpSession session = request.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean bean = new MemberBean();
		switch (Separator.command.getAction()) {
		case "move":
			Separator.command.setDirectory("member");	
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "browse_main":
			System.out.println("browse_main");
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "select_filme":
			Separator.command.setPage(Separator.command.getAction());
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);				
			break;
		case "regist":
			bean = new MemberBean();
			bean.setEmail(request.getParameter("userid"));
			bean.setPassword(request.getParameter("userpw"));
			bean.setRcvEmail(true);

			int count = service.regist(bean);
			if(count == 1){
				Separator.command.setPage("payment");	
				request.setAttribute("regist_fail", "");				
			}else{
				Separator.command.setPage("regist");
				request.setAttribute("regist_fail", "회원가입 실패");				
			}
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "payment_reg":
			bean = new MemberBean();
			bean.setName(request.getParameter("name"));
			bean.setPhone(request.getParameter("phone"));
			DispatcherServlet.send(request,response,Separator.command);			
			break;			
		case "regist_complete":
			Separator.command.setPage("main_before");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "login":
			Separator.command.setPage("browse_main");
			Separator.command.setView();
			bean = new MemberBean();
			bean.setEmail(request.getParameter("email"));
			bean.setPassword(request.getParameter("pw"));
			session = request.getSession();
			bean = service.login(bean);
			if(bean.getEmail().equals("fail")){
				System.out.println("fail");
				Separator.command.setPage("login");
			}else{
			session.setAttribute("user", bean);
			Separator.command.setPage("browse_main");
			
			}
			Separator.command.setView();
			request.setAttribute("result", bean.getEmail().equals("fail")?"로그인실패":"");
			DispatcherServlet.send(request,response,Separator.command);		
			break;
		default:
			break;
		}
			
	}

}
