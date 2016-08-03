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
				regBean.setEpisode(2);
				regBean.setProducer_no(3);
				regBean.setGenre(Genre.ACTION.ordinal());
				regBean.setCategory(Category.MOVIE.ordinal());
				regBean.setGroupNo(5);
				regBean.setTitle("다크나이트 라이즈");
				regBean.setSubTitle("THE DARK KNIGHT RISE");
				regBean.setCreateYear("2012-07-20");
				regBean.setS​ynopsis("다크 나이트에서 하비 덴트가 죽고 8년이 지나 하비의 살인자로 낙인찍힌 배트맨은 종적을 감추었고, 범죄집단에 가담한 범죄자들을 블랙 게이트란 수용소에 집어넣고 가석방은 절대 시켜주지 않는 『 하비 덴트 특별법 』에 의해 고담시의 범죄율을 급감해 평화로운 나날이 이어지고 있었다.");
				regBean.setRunningTime("02:44:00");
				regBean.setFile("https://youtu.be/lPSYDCRliFA");
				regBean.setLanguage("영어");
				regBean.setPoster("dardknightrise.jpg");
				regBean.setActorList("1:8:9");
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
				Map<Integer, List<VideoBigBean>> maps = (Map<Integer, List<VideoBigBean>>) vService.getSeries(5);
				System.out.println(maps.size());
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
