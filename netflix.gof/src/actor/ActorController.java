package actor;

import javax.swing.JOptionPane;

public class ActorController {
	public static void main(String[] args) {
		ActorService actService = ActorServiceImpl.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1.regist 2.list 3.findby 4.update 5.delete 6.map 7.findbypk")) {
			case "1":
				ActorBean regBean = new ActorBean();
				regBean.setKorName("안젤리나 졸리");
				regBean.setEngName("Angelina Jolie");
				regBean.setProfileImg("default.jpg");
				actService.regist(regBean);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, actService.list());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, actService.findBy("KOR_NAME:안젤리나 졸리"));
				break;
			case "4":
				ActorBean uptBean = new ActorBean();
				uptBean.setKorName("강호동");
				uptBean.setEngName("Ho-dong Kang");
				uptBean.setProfileImg("default.jpg");
				actService.update(uptBean);
				break;
			case "5":
				actService.delete(21);
				break;
			case "7":
				JOptionPane.showMessageDialog(null, actService.findByPk(1));
				break;
			default:
				break;
			}
		}
	}
}
