package video;

import java.util.List;
import java.util.Map;

public class VideoServiceImpl implements VideoService{
	VideoDAO vDao = VideoDAO.getInstance();
	private static VideoServiceImpl instance = new VideoServiceImpl();
	
	private VideoServiceImpl() {
		
	}
	public static VideoServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<VideoBean> list() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> findBy(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<Integer, VideoBean> map() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> myMovieList(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> wishMovieList(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> hotMovieList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> newMovieList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<VideoBean> sort(String order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VideoBean detail(int serialNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void playMovie(VideoBean mvBean) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int insert(VideoBean viBean) {
		int result = 0;
		if(vDao.insert(viBean)==1){
			vDao.insertProducing(viBean); // produder dao로 교체 예정
			vDao.insertGenre(viBean);
			vDao.insertCategory(viBean);
			vDao.insertGroupNo(viBean);
			vDao.insertGrade(viBean);
			vDao.insertSeries(viBean);
			//vDao.insertAppear(); // action Dao로 교체 예정 actor+video bean 
		}
		return result;
	}
	@Override
	public int update(VideoBean viBean) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(VideoBean viBean) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
