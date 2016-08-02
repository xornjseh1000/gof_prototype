package producer;

import javax.swing.JOptionPane;

public class ProducerController {
	public static void main(String[] args) {
		ProducerService prdService = ProducerServiceImpl.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1.regist 2.list 3.findby 4.update 5.delete 6.map 7.findbypk")) {
			case "1":
				ProducerBean regBean = new ProducerBean();
				regBean.setKorName("크리스토퍼 놀란");
				regBean.setEngName("Christopher Edward Nolan");
				regBean.setProfileImg("default.jpg");
				prdService.regist(regBean);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, prdService.list());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, prdService.findBy("e")); 
				break;
			case "4":
				ProducerBean uptBean = new ProducerBean();
				uptBean.setProducerNo(22);
				uptBean.setKorName("크리스토퍼 놀란");
				uptBean.setEngName("Christopher Nolan");
				uptBean.setProfileImg("default.jpg");
				prdService.update(uptBean);
				break;
			case "5":
				prdService.delete(22);
				break;
			case "7":
				JOptionPane.showMessageDialog(null, prdService.findByPk(21));
				break;
			default:
			
				break;
			}
		}
	}
}
