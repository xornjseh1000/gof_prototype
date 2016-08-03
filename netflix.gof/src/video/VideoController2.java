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
import global.Separator;

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
			Map<String,Map<Integer, List<VideoBigBean>>> sMap = (Map<String,Map<Integer, List<VideoBigBean>>>) vService.search(request.getParameter("keyword"));
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
			}else if(sMap.containsKey("actor")){
				valueMap = sMap.get("actor");
				actList = new ArrayList<ActorBean>();
				it = valueMap.keySet().iterator();
				while(it.hasNext()){
					actList.add(actService.findByPk((int) it.next()));
				}
				vList = valueMap.get(actList.get(0));
				request.setAttribute("actorlist", actList);
			}else{
				valueMap = sMap.get("genre");
				it = valueMap.keySet().iterator();
				while(it.hasNext()){
					vList = valueMap.get(it.next());
				}
			}
			request.setAttribute("searchlist", vList);
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);				
			break;
		case "payment":
			Separator.command.setPage(Separator.command.getAction());
			Separator.command.setView();
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
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		default:
			break;
		}
				
	}


}
