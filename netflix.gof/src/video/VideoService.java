package video;

import java.util.List;
import java.util.Map;

import global.CommonService;

/**
 * @date   :2016. 7. 27.
 * @author :HyunWoo Lee
 * @file   :VideoService.java
 * @story  :
*/

public interface VideoService extends CommonService {
	
	public int insert(VideoBigBean viBean);
	public int update(VideoBean viBean);
	public int delete(VideoBean viBean);
	
	// main 
	public Map<String,Map<Integer, List<VideoBigBean>>> search(String keyword);
	public List<VideoBigBean> myMovieList(String email);
	public List<VideoBigBean> wishMovieList(String email);
	public List<VideoBigBean> hotMovieList();
	public List<VideoBigBean> newMovieList();
	public List<VideoBigBean> recommendList(String email);
	public List<?> sort(List<VideoBigBean> vList,String order);
	public Map<Integer,List<VideoBigBean>> getSeries(int groupNo);
	public List<?> getCategoryList(int category);
	public VideoBigBean detail(int serialNo);
	public void playMovie(String email, int serialNo);
	public int checkBookmark(String email, int serialNo);
	
}
