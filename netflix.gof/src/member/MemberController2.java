package member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import global.DispatcherServlet;
import global.ParamMap;
import global.Separator;
import payment.MemberPaymentCard;
import video.VideoBigBean;
import video.VideoService;
import video.VideoServiceImpl;

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
		VideoService vService = VideoServiceImpl.getInstance();
		MemberBean bean = new MemberBean();
		MemberPaymentCard pcmBean = new MemberPaymentCard();
		switch (Separator.command.getAction()) {
		case "move":
			Separator.command.setDirectory("member");	
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "browse_main":
			System.out.println("browse_main");
			bean = (MemberBean) session.getAttribute("user");
			List<VideoBigBean> hotList = (List<VideoBigBean>) vService.hotMovieList();
			request.setAttribute("hotlist", hotList);
			List<VideoBigBean> newList = (List<VideoBigBean>) vService.newMovieList();
			request.setAttribute("newlist", newList);
			List<VideoBigBean> myList = (List<VideoBigBean>) vService.myMovieList(bean.getEmail());
			request.setAttribute("mylist", myList);
			List<VideoBigBean> recommendList = (List<VideoBigBean>) vService.recommendList(bean.getEmail());
			request.setAttribute("recommendlist", recommendList);
			List<VideoBigBean> wishList = (List<VideoBigBean>) vService.wishMovieList(bean.getEmail());
			request.setAttribute("wishlist", wishList);
			Separator.command.setPage("browse_main");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "regist_complete":
			bean = (MemberBean)session.getAttribute("reg");			
			service.addFav(bean.getEmail(), ParamMap.getValues(request, "fav_chk"));
			Separator.command.setPage("login");
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
				session.setAttribute("reg", bean);
			}else{
				Separator.command.setPage("regist");
				request.setAttribute("regist_fail", "회원가입 실패");				
			}
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "payment_reg":
			pcmBean = new MemberPaymentCard();
			String birth = request.getParameter("year")+
						   request.getParameter("month")+
						   request.getParameter("day");
			birth = birth.substring(2,birth.length());
			String grade = request.getParameter("grade");
			System.out.println(grade);
			
			if(grade.equals("Basic")){
				pcmBean.setGrade(1);
			}else{
				pcmBean.setGrade(2);				
			}
			
			pcmBean.setName(request.getParameter("name"));
			pcmBean.setBirth(Integer.parseInt(birth));
			pcmBean.setCardNum(request.getParameter("cardNum"));
			pcmBean.setPhone(request.getParameter("phone"));
			pcmBean.setEmail(request.getParameter("email"));
			int pmResult = service.update(pcmBean);
			if(pmResult == 1){
				Separator.command.setPage("select_filme");
				Separator.command.setView();
			}
			
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
			hotList = (List<VideoBigBean>) vService.hotMovieList();
			request.setAttribute("hotlist", hotList);
			newList = (List<VideoBigBean>) vService.newMovieList();
			request.setAttribute("newlist", newList);
			myList = (List<VideoBigBean>) vService.myMovieList(bean.getEmail());
			request.setAttribute("mylist", myList);
			recommendList = (List<VideoBigBean>) vService.recommendList(bean.getEmail());
			request.setAttribute("recommendlist", recommendList);
			wishList = (List<VideoBigBean>) vService.wishMovieList(bean.getEmail());
			request.setAttribute("wishlist", wishList);
			DispatcherServlet.send(request,response,Separator.command);		
			break;
		default:
			break;
		}
			
	}

}
