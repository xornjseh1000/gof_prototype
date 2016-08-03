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
				regBean.setGrade(12);
				regBean.setSeason(1);
				regBean.setEpisode(1);
				regBean.setProducer_no(3);
				regBean.setGenre(Genre.INFORM.ordinal());
				regBean.setCategory(Category.DOCUMENTARY.ordinal());
				regBean.setGroupNo(0);
				regBean.setTitle("The Blue Planet");
				regBean.setSubTitle("A Natural History of the Oceans");
				regBean.setCreateYear("2011-03-13");
				regBean.setS​ynopsis("우리에게 익숙한 바다, 비밀에 싸인 심해와 그곳에 사는 생물들까지 심도 있게 파헤치는 다큐멘터리. 데이비드 애튼버러가 해설을 맡았다.");
				regBean.setRunningTime("00:48:00");
				regBean.setFile("https://youtu.be/eH1s9GCqPKo");
				regBean.setLanguage("영어");
				regBean.setPoster("blueplanet.jpg");
				regBean.setActorList("5");
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
				Map<?,?> map = vService.search("sf");
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
				Map<Integer, List<VideoBigBean>> maps = (Map<Integer, List<VideoBigBean>>) vService.getSeries(21);
				System.out.println(maps.size());
				break;
			case "12":
				JOptionPane.showMessageDialog(null, vService.getCategoryList(Category.DRAMA.ordinal()));
				break;
			case "13":
				List<VideoBigBean> list = (List<VideoBigBean>) vService.list();
				JOptionPane.showMessageDialog(null, vService.sort(list,""));
				break;
			default:
				break;
			}
		}
		
	}
}
