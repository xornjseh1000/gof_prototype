package video;

import java.util.List;

import global.CommonService;

/**
 * @date   :2016. 7. 27.
 * @author :HyunWoo Lee
 * @file   :VideoService.java
 * @story  :
*/

public interface VideoService extends CommonService {
	
	public int insert(VideoBean viBean);
	public int update(VideoBean viBean);
	public int delete(VideoBean viBean);
	
	// main 
	public List<VideoBean> myMovieList(String email);
	public List<VideoBean> wishMovieList(String email);
	public List<VideoBean> hotMovieList();
	public List<VideoBean> newMovieList();
	public List<VideoBean> sort(String order);
	public VideoBean detail(int serialNo);
	public void playMovie(VideoBean mvBean);
}
