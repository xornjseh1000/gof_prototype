package video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import actor.ActorBean;
import actor.ActorService;
import actor.ActorServiceImpl;
import global.DispatcherServlet;
import global.Genre;
import global.Separator;
import member.MemberBean;
import member.MemberService;
import member.MemberServiceImpl;
import producer.ProducerBean;
import producer.ProducerService;
import producer.ProducerServiceImpl;

/**
 * Servlet implementation class VideoController2
 */
@WebServlet("/video.do")
public class VideoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		HttpSession session = request.getSession();
		VideoService vService = VideoServiceImpl.getInstance();
		ActorService actService = ActorServiceImpl.getInstance();
		MemberService mService = MemberServiceImpl.getInstance();
		ProducerService prdService = ProducerServiceImpl.getInstance();
		MemberBean bean = new MemberBean();
		switch (Separator.command.getAction()) {
		case "move":
			Separator.command.setDirectory("member");	
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "category":
			int categoryNum = Integer.parseInt(request.getParameter("category"));
			List<VideoBigBean> categoryList = (List<VideoBigBean>)vService.getCategoryList(categoryNum);
			String order = request.getParameter("order");
			if(order != null){
				categoryList = (List<VideoBigBean>) vService.sort(categoryList, order);
			}
			request.setAttribute("categorylist", categoryList);
			request.setAttribute("categoryNum", categoryNum);
			Separator.command.setPage("category");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "search":
			String keyword = request.getParameter("keyword");
			Map<String,Map<Integer, List<VideoBigBean>>> sMap = (Map<String,Map<Integer, List<VideoBigBean>>>) vService.search(keyword);
			if(sMap.isEmpty()){
				// 검색결과 없다고 알려주는 페이지로 이동시킴
				Separator.command.setPage("not_found");
				Separator.command.setView();
				request.setAttribute("keyword", keyword);
				DispatcherServlet.send(request,response,Separator.command);
			}else{
				System.out.println("????");
				Map<Integer, List<VideoBigBean>> valueMap = null;
				Iterator<?> it = null;
				List<VideoBigBean> vList = null;
				List<ActorBean> actList = null;
				if(sMap.containsKey("title")){
					valueMap = sMap.get("title");
					it = valueMap.keySet().iterator();
					vList = new ArrayList<VideoBigBean>();
					while(it.hasNext()){
						vList.add(valueMap.get(it.next()).get(0));
					}
					System.out.println(vList.size());
				}else if(sMap.containsKey("actor")){
					valueMap = sMap.get("actor");				
					actList = new ArrayList<ActorBean>();
					it = valueMap.keySet().iterator();
					while(it.hasNext()){
						actList.add(actService.findByPk((int) it.next()));
					}
					vList = valueMap.get(actList.get(0).getActorNo());
					request.setAttribute("actorlist", actList);
					
				}else{
					valueMap = sMap.get("genre");
					it = valueMap.keySet().iterator();
					while(it.hasNext()){
						vList = valueMap.get(it.next());
					}
					System.out.println(vList.size());
				}
				request.setAttribute("searchlist", vList);
				request.setAttribute("keyword", keyword);
				Separator.command.setView();
				DispatcherServlet.send(request,response,Separator.command);	
			}
			break;
		case "payment":
			Separator.command.setPage(Separator.command.getAction());
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "detail":
			int serialNo = Integer.parseInt(request.getParameter("serialNo"));
			MemberBean member = (MemberBean) session.getAttribute("user");
			VideoBigBean bigBean = vService.detail(serialNo);
			ProducerBean prdBean = prdService.findByPk(bigBean.getProducer_no());
			request.setAttribute("video", bigBean);
			request.setAttribute("story", bigBean.getS​ynopsis());
			String bookmark = request.getParameter("bm");
			List<ActorBean> actList = actService.getActorNames(bigBean.getActorList());
			if(bookmark!=null){
				if(bookmark.equals("add")){
					mService.addBk(member.getEmail(), serialNo);
				}else{
					mService.delBk(member.getEmail(), serialNo);
				}
			}
			request.setAttribute("flag", vService.checkBookmark(member.getEmail(),serialNo));
			request.setAttribute("genre", this.getGenre(bigBean.getGenre()));
			request.setAttribute("actlist", actList);
			request.setAttribute("directer", prdBean);
			Separator.command.setPage("video_detail");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "play":
			serialNo = Integer.parseInt(request.getParameter("serialNo"));
			bigBean = vService.detail(serialNo);
			member = (MemberBean) session.getAttribute("user");
			vService.playMovie(member.getEmail(), serialNo);
			request.setAttribute("videourl", bigBean.getFile());
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);	
			break;
		case "login":
			Separator.command.setPage("browse_main");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "myList": 
			bean = (MemberBean) session.getAttribute("user");
			List<VideoBigBean> myList = (List<VideoBigBean>) vService.myMovieList(bean.getEmail());
			request.setAttribute("mylist", myList);
			DispatcherServlet.send(request,response,Separator.command);		
		break;	
		case "hotList": 
			bean = (MemberBean) session.getAttribute("user");
			List<VideoBigBean> hotList = (List<VideoBigBean>) vService.hotMovieList();
			request.setAttribute("hotlist", hotList);
			DispatcherServlet.send(request,response,Separator.command);		
		break;	
		case "newList": 
			bean = (MemberBean) session.getAttribute("user");
			List<VideoBigBean> newList = (List<VideoBigBean>) vService.newMovieList();
			request.setAttribute("newlist", newList);
			DispatcherServlet.send(request,response,Separator.command);		
		break;	
		default:
			break;
		}
				
	}

	private String getGenre(int genre) {
		String result = "";
		//ACTION,COMEDY,MELO,THRILLER,HORROR,SF,INFORM;
		switch (genre) {
			case 0:
				result= "액션";	
			break;
			case 1:
				result= "코메디";	
			break;
			case 2:
				result= "멜로";	
			break;
			case 3:
				result= "스릴러";	
			break;
			case 4:
				result= "호러";	
			break;
			case 5:
				result= "SF";	
			break;
			default:
				result = "정보";
			break;
		}
		return result;
	}


}
