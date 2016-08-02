package customer;

import javax.swing.JOptionPane;

public class CustomerController {
	
	public static void main(String[] args) {
		CustomerService cuService = CustomerServiceImpl.getInstance();
		while(true){
			switch (JOptionPane.showInputDialog("1.regist 2.list 3.findby 4.update 5.delete 6.map 7.findbypk")) {
			case "1":
				CustomerBean cusBean = new CustomerBean();
				cusBean.setCategory("멤버쉽");
				cusBean.setTitle("멤버쉽 등급은 어떻게 바꾸나요");
				cusBean.setContent("프로필 계정 관리에서 변경 가능합니다");
				cuService.write(cusBean);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, cuService.list());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, cuService.findBy("어떻게"));
				break;
			case "4":
				CustomerBean uptBean = new CustomerBean();
				uptBean.setCusSeq(4);
				uptBean.setTitle("멤버쉽 등급은 어떻게 바꾸나요");
				uptBean.setContent("계정 관리에서 변경 가능합니다");
				cuService.update(uptBean);
			case "5":
				cuService.delete(4);
				break;
			case "6":
				JOptionPane.showMessageDialog(null, cuService.findByPk(3));
				break;
			default:
				break;
			}
		}
	}
}
