package video;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import global.Category;
import global.Genre;



public class VideoController {
	public static void main(String[] args) {
		VideoService vService = VideoServiceImpl.getInstance();
		VideoDAO dao = VideoDAO.getInstance();
		while(true){
			switch (JOptionPane.showInputDialog("1.")) {
			case "1":
				VideoBigBean regBean = new VideoBigBean();
				regBean.setGrade(19);
				regBean.setSeason(1);
				regBean.setEpisode(1);
				regBean.setProducer_no(2);
				regBean.setGenre(Genre.ACTION.ordinal());
				regBean.setCategory(Category.MOVIE.ordinal());
				regBean.setGroupNo(0);
				regBean.setTitle("제이슨 본");
				regBean.setSubTitle("Jason Bourne");
				regBean.setCreateYear("2016-07-28");
				regBean.setS​ynopsis("모든 자취를 숨기고 사라졌던 제이슨 본, 그는 되찾은 기억 외에 과거를 둘러싼 또 다른 음모가 있다는 것을 알게 되고 마침내 CIA 앞에 자신의 존재를 드러내게 되는데… 가장 완벽하고 가장 치명적인 무기 ‘제이슨 본’ 이제 모든 것이 그에게 달렸다");
				regBean.setRunningTime("02:03:00");
				regBean.setFile("https://youtu.be/gCl9rawhxl8");
				regBean.setLanguage("영어");
				regBean.setPoster("JasonBourne.jpg");
				regBean.setActorList("7:8:9");
				vService.insert(regBean);
				break;
			case "2":
				JOptionPane.showMessageDialog(null,dao.getActorList(1012) );
				break;
			case "3":
				VideoBigBean bean = (VideoBigBean) vService.list().get(1);
				try {
					Date d = new SimpleDateFormat("yyyy/MM/dd").parse(bean.getRegDate());
					Date d2 = new SimpleDateFormat("yyyy/MM/dd").parse("2016/08/03");
					JOptionPane.showMessageDialog(null, d2.compareTo(d));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "4":
				Map<?,?> map = vService.search("THRILLER");
				Iterator<?> it = map.keySet().iterator();
				while(it.hasNext()){
					int key = (int) it.next();
					@SuppressWarnings("unchecked")
					List<VideoBigBean> list = (List<VideoBigBean>) map.get(key);
					if(!list.isEmpty()){
						System.out.println(key + " : "+ list);
					}
				}
				break;
			case "5": //myBOokamrk
				JOptionPane.showMessageDialog(null, vService.wishMovieList("2hwooo@naver.com"));
				break;
			case "6": //watched list(내동영상목록)
				JOptionPane.showMessageDialog(null, vService.myMovieList("2hwooo@naver.com"));
				break;
			case "7": // new mov list(내동영상목록)
				JOptionPane.showMessageDialog(null, vService.newMovieList());
				break;
			case "8": // hot list(내동영상목록)
				JOptionPane.showMessageDialog(null, vService.hotMovieList());
				break;
			case "9":
				JOptionPane.showMessageDialog(null, vService.detail(1010).getS​ynopsis());
				break;
			case "10":
				JOptionPane.showMessageDialog(null, vService.recommendList("2hwooo@naver.com").size());
				break;
			case "11":
				JOptionPane.showMessageDialog(null, vService.getSeries(1, 6));
				break;
			case "12":
				JOptionPane.showMessageDialog(null, vService.getCategoryList(Category.MOVIE.ordinal()));
				break;
			default:
				break;
			}
		}
		
	}
}
