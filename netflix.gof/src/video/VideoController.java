package video;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/*
 * public List<?> list();
	public List<?> findBy(String keyword);
	public Map<?,?> map();
 * 
 * public List<VideoBean> myMovieList(String email);
public List<VideoBean> wishMovieList(String email);
public List<VideoBean> hotMovieList();
public List<VideoBean> newMovieList();
public List<VideoBean> sort(String order);
public VideoBean detail(int serialNo);
public void playMovie(VideoBean mvBean);*/

public class VideoController {
	public static void main(String[] args) {
		VideoService vService = VideoServiceImpl.getInstance();
		while(true){
			switch (JOptionPane.showInputDialog("1.")) {
			case "1":
					
				break;
			
			default:
				break;
			}
		}
		
	}
}
