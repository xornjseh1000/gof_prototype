package video;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import actor.ActorBean;
import actor.ActorDAO;
import global.Genre;
import global.RegDateSort;
import member.MemberDAO;

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
		
		return null;
	}
	@Override
	public Map<Integer, List<VideoBigBean>> search(String keyword) {
		Iterator<?> it = this.map.keySet().iterator();
		Map<Integer,List<VideoBigBean>> vMap = new HashMap<Integer,List<VideoBigBean>>();
		List<VideoBigBean> vList = null;
		while(it.hasNext()){
			VideoBigBean bigBean = map.get(it.next());
			if(bigBean.getTitle().contains(keyword) || bigBean.getSubTitle().contains(keyword)){
				vList = new ArrayList<VideoBigBean>();
				vList.add(bigBean);
				vMap.put(bigBean.getSerialNo(), vList);
			}
		}
		if(!vMap.isEmpty()){
			return vMap;
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
					if(this.checkActorList(bigBean.getActorList(), actBean.getActorNo())){
						vList.add(bigBean);
					}
				}
				actMap.put(actBean.getActorNo(), vList);
			}
 		}
 		if(!actMap.isEmpty()){
 			return actMap;
 		}
 		int genre = this.checkGenre(keyword);
 		if(genre!=-1){
 			it = map.keySet().iterator();
 			Map<Integer,List<VideoBigBean>> genreMap = new HashMap<Integer,List<VideoBigBean>>();
 			vList = new ArrayList<VideoBigBean>();
 			while(it.hasNext()){
 				VideoBigBean bigBean = map.get(it.next());
 				if(bigBean.getGenre()==genre){
 					vList.add(bigBean);
 				}
 			}
 			genreMap.put(genre, vList);
 			return genreMap;
 		}
 		return null;
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
		if(keyword.equalsIgnoreCase("ACTION")){
			result = Genre.ACTION.ordinal();
		}else if(keyword.equalsIgnoreCase("COMEDY")){
			result = Genre.COMEDY.ordinal();
		}else if(keyword.equalsIgnoreCase("MELO")){
			result = Genre.MELO.ordinal();
		}else if(keyword.equalsIgnoreCase("THRILLER")){
			result = Genre.THRILLER.ordinal();
		}else if(keyword.equalsIgnoreCase("HORROR")){
			result = Genre.HORROR.ordinal();
		}else if(keyword.equalsIgnoreCase("SF")){
			result = Genre.SF.ordinal();
		}else{
			result = -1;
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
			list.add(map.get(index));
		}
		return list;
		
	}
	@Override
	public List<VideoBigBean> wishMovieList(String email) {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		List<Integer> bMarkList = vDao.selectBookmark(email);
		for (Integer index : bMarkList) {
			list.add(map.get(index));
		}
		return list;
	}
	@Override
	public List<VideoBigBean> hotMovieList() {
		List<VideoBigBean> list = new ArrayList<VideoBigBean>();
		List<Integer> hotList = vDao.selectHotList();
		for (Integer index : hotList) {
			list.add(map.get(index));
		}
		return list;
	}
	@Override
	public List<VideoBigBean> newMovieList() {
		List<VideoBigBean> list = this.list();
		List<VideoBigBean> newList = new ArrayList<VideoBigBean>();
		Collections.sort(list, new RegDateSort());
		int i=0;
		for(;i<2;i++){ // 최근 등록한 5개 영상만 보여줌 
			newList.add(list.get(i));
		}
		return newList;
	}
	@Override
	public List<?> sort(String order) {
		
		return null;
	}
	@Override
	public VideoBigBean detail(int serialNo) {
		return map.get(serialNo);
	}
	@Override
	public void playMovie(VideoBean mvBean) {
		// TODO Auto-generated method stub
		
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
	public List<?> recommendList(String email) {
		String[] favs = mDao.selectFav(email).split(":");
		int[] ifavs = new int[favs.length];
		for (int i : ifavs) {
			ifavs[i] = Integer.parseInt(favs[i]);
		}
		List<VideoBigBean> list = vDao.selectRecList(ifavs);
		return null;
	}
	
}
