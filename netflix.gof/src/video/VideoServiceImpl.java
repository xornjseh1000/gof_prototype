package video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actor.ActorBean;
import actor.ActorDAO;
import global.EpisodeAscSort;
import global.GPADescSort;
import global.Genre;
import global.RegDateDescSort;
import global.TitleAscSort;
import member.MemberDAO;
import sun.print.resources.serviceui;

public class VideoServiceImpl implements VideoService{
	private VideoDAO vDao = VideoDAO.getInstance();
	private ActorDAO aDao = ActorDAO.getInstance();
	private MemberDAO mDao = MemberDAO.getInstance();
	private static VideoServiceImpl instance = new VideoServiceImpl();
	private Map<Integer, VideoBigBean> map;
	
	private VideoServiceImpl() {
		this.map();
	}
	public static VideoServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<VideoBigBean> list() {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		Iterator<?> it = this.map.keySet().iterator();
		while(it.hasNext()){
			VideoBigBean bigBean = this.map.get(it.next());
			list.add(bigBean);
		}
		return list;
	}
	@Override
	public List<?> findBy(String keyword) {
		// search로 대체..
		return null;
	}
	@Override
	public Map<String,Map<Integer, List<VideoBigBean>>> search(String keyword) {
		Map<String,Map<Integer, List<VideoBigBean>>> resultMap = new HashMap<String,Map<Integer, List<VideoBigBean>>>();
		Iterator<?> it = this.map.keySet().iterator();
		Map<Integer,List<VideoBigBean>> vMap = new HashMap<Integer,List<VideoBigBean>>();
		List<VideoBigBean> vList = null;
		while(it.hasNext()){
			VideoBigBean bigBean = map.get(it.next());
			if((bigBean.getTitle().contains(keyword) || bigBean.getSubTitle().contains(keyword)) && bigBean.getEpisode()==1){
				vList = new ArrayList<VideoBigBean>();
				vList.add(bigBean);
				vMap.put(bigBean.getSerialNo(), vList);
			}
		}
		if(!vMap.isEmpty()){
			resultMap.put("title", vMap);
			return resultMap;
		}
		Map<Integer,List<VideoBigBean>> actMap = new HashMap<Integer,List<VideoBigBean>>();
 		List<ActorBean> aList = aDao.selectBy("KOR_NAME", keyword);
 		
 		if(aList.isEmpty()){
 			aList = aDao.selectBy("ENG_NAME", keyword);
 		}
 		if(!aList.isEmpty()){
 			for (ActorBean actBean : aList) {
				it = map.keySet().iterator();
				vList = new ArrayList<VideoBigBean>();
				while(it.hasNext()){
					VideoBigBean bigBean = this.map.get(it.next());
					if(this.checkActorList(bigBean.getActorList(), actBean.getActorNo()) && bigBean.getEpisode()==1){
						vList.add(bigBean);
					}
				}
				actMap.put(actBean.getActorNo(), vList);
			}
 		}
 		if(!actMap.isEmpty()){
 			resultMap.put("actor", actMap);
 			return resultMap;
 		}
 		
 		int genre = this.checkGenre(keyword);
 		if(genre!=-1){
 			it = map.keySet().iterator();
 			Map<Integer,List<VideoBigBean>> genreMap = new HashMap<Integer,List<VideoBigBean>>();
 			vList = new ArrayList<VideoBigBean>();
 			while(it.hasNext()){
 				VideoBigBean bigBean = map.get(it.next());
 				if(bigBean.getGenre()==genre && bigBean.getEpisode()==1){	
 					vList.add(bigBean);
 				}
 			}
 			genreMap.put(genre, vList);
 			resultMap.put("genre", genreMap);
 			return resultMap;
 		}
 		return resultMap;
	}
	public boolean checkActorList(String actorList,int actorNo){
		boolean result = false;
		String[] actors = actorList.split(":");
		for (String actorNum : actors) {
			if(Integer.parseInt(actorNum)==actorNo){
				return true;
			}
		}
		return result;
	}
	
	private int checkGenre(String keyword) {
		int result = 0;
		// ACTION,COMEDY,MELO,THRILLER,HORROR,SF;
		switch (keyword.toUpperCase()) {
		case "ACTION": case "액션":
			result = Genre.ACTION.ordinal();
			break;
		case "COMEDY": case "코메디":
			result = Genre.COMEDY.ordinal();
			break;
		case "MELO": case "멜로":
			result = Genre.MELO.ordinal();
			break;
		case "THRILLER": case "스릴러":
			result = Genre.THRILLER.ordinal();
			break;
		case "HORROR": case "호러":
			result = Genre.HORROR.ordinal();
			break;
		case "SF": case "판타지":
			result = Genre.SF.ordinal();
			break;
		case "INFORM": case "정보":
			result = Genre.INFORM.ordinal();
			break;
		default:
			result = -1;
			break;
		}
		return result;
	}
	@Override
	public Map<Integer, VideoBigBean> map() {
		this.map = vDao.selectMap();
		return vDao.selectMap();
	}
	@Override
	public List<VideoBigBean> myMovieList(String email) {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		List<Integer> watchedList = vDao.selectStats(email);
		for (Integer index : watchedList) {
			VideoBigBean bigBean = map.get(index);
			if(bigBean.getEpisode()==1){
				list.add(map.get(index));
			}
		}
		return list;
		
	}
	@Override
	public List<VideoBigBean> wishMovieList(String email) {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		List<Integer> bMarkList = vDao.selectBookmark(email);
		for (Integer index : bMarkList) {
			VideoBigBean bigBean = map.get(index);
			if(bigBean.getEpisode()==1){
				list.add(map.get(index));
			}
		}
		return list;
	}
	@Override
	public List<VideoBigBean> hotMovieList() {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		List<Integer> hotList = vDao.selectHotList();
		for (Integer index : hotList) {
			VideoBigBean bigBean = map.get(index);
			if(bigBean.getEpisode()==1){
				list.add(map.get(index));
			}
		}
		return list;
	}
	@Override
	public List<VideoBigBean> newMovieList() {
		List<VideoBigBean> list = this.list();
		List<VideoBigBean> newList = new ArrayList<VideoBigBean>();
		Collections.sort(list, new RegDateDescSort());
		int i=0;
		for(;i<2;i++){ // 최근 등록한 2개 영상만 보여줌 
			newList.add(list.get(i));
		}
		return newList;
	}

	@Override
	public VideoBigBean detail(int serialNo) {
		return map.get(serialNo);
	}
	@Override
	public void playMovie(String email, int serialNo) {
		if(vDao.checkStat(email,serialNo)==1){
			vDao.insertStat(email,serialNo);
		}
	}
	@Override
	public int insert(VideoBigBean viBean) {
		int result = 0;
		viBean.setSerialNo(vDao.getSeq());
		if(vDao.insert(viBean)==1){
			vDao.insertSeries(viBean);
			vDao.insertGenre(viBean);
			vDao.insertCategory(viBean);
			vDao.insertProducing(viBean); // produder dao로 교체 예정
			vDao.insertGroupNo(viBean);
			vDao.insertGrade(viBean);
			String[] actorList = viBean.getActorList().split(":");
			for (String acotrNo : actorList) {
				vDao.insertAppearance(Integer.parseInt(acotrNo),viBean.getSerialNo());
			}
			result = 1;
			this.map();
		}
	
		return result;
	}
	@Override
	public int update(VideoBean viBean) {		
		int result = vDao.update(viBean);
		this.map();
		return result;
	}
	@Override
	public int delete(VideoBean viBean) {
		int result = vDao.delete(viBean.getSerialNo());
		this.map();
		return result;
	}
	@Override
	public List<VideoBigBean> recommendList(String email) {
		String[] favs = mDao.selectFav(email).split(":");
		int[] genres = new int[favs.length];
		int i=0;
	
		for(i=0 ; i < genres.length ; i++){
			genres[i] = map.get(Integer.parseInt(favs[i])).getGenre();
			
		}
		List<VideoBigBean> vList = new ArrayList<VideoBigBean>();
		Iterator<?> it = this.map.keySet().iterator();
		int genre=0;
		while (it.hasNext()) {
			VideoBigBean bigBean = (VideoBigBean) map.get(it.next());
			genre = bigBean.getGenre();
			if((genre==genres[0]||genre==genres[1]||genre==genres[2])&&bigBean.getEpisode()==1){
				vList.add(bigBean);
			}
		}
		System.out.println(vList.size());
		return vList;
	}
	@Override
	public Map<Integer,List<VideoBigBean>> getSeries(int groupNo) {
		Map<Integer,List<VideoBigBean>> seriesMap = new HashMap<Integer,List<VideoBigBean>>();
		List<VideoBigBean> vList = new ArrayList<VideoBigBean>();
		Iterator<?> it = this.map.keySet().iterator();
		List<Integer> seasonList = new ArrayList<Integer>();
		while (it.hasNext()) {
			VideoBigBean bigBean = (VideoBigBean) map.get(it.next());
			if(bigBean.getGroupNo()==groupNo){
				seasonList.add(bigBean.getSeason());
			}
		}
		seasonList = new ArrayList<Integer>(new HashSet<Integer>(seasonList));
		for (Integer season : seasonList) {
			it = this.map.keySet().iterator();
			while(it.hasNext()){
				VideoBigBean bigBean = map.get(it.next());
				if(bigBean.getSeason() == season && bigBean.getGroupNo()==groupNo){
					vList.add(bigBean);
				}
			}
			Collections.sort(vList, new EpisodeAscSort());
			seriesMap.put(season, vList);
		}		
		return seriesMap;
	}
	@Override
	public List<VideoBigBean> getCategoryList(int category) {
		List<VideoBigBean> vList = new ArrayList<VideoBigBean>();
		Iterator<?> it = this.map.keySet().iterator();
		while (it.hasNext()) {
			VideoBigBean bigBean = (VideoBigBean) map.get(it.next());
			if(bigBean.getCategory() == category && bigBean.getEpisode()==1){
				vList.add(bigBean);
			}
		}
		return vList;
	}
	@Override
	public List<VideoBigBean> sort(List<VideoBigBean> vList, String order) {
		switch (order.toUpperCase()) {
		case "GPA":
			Collections.sort(vList, new GPADescSort());
			break;
		case "REGDATE":
			Collections.sort(vList, new RegDateDescSort());
			break;
		default:
			Collections.sort(vList, new TitleAscSort());
			break;
		}
		return vList;
	}
	@Override
	public int checkBookmark(String email, int serialNo) {
	
		return vDao.selectBookmark(email,serialNo);
	}
}
