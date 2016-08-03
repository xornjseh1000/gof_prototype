package payment;

import javax.swing.JOptionPane;

public class PaymentController {
	public static void main(String[] args) {
		PaymentService service = PaymentServiceImpl.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1.insert 2.list 3.findpk 4.update 5.delete")) {
			case "1":
				MemberPaymentCard inBean = new MemberPaymentCard();
				inBean.setCardNum("9999-9999-9999-6666");
				inBean.setCompany("삼성카드");
				inBean.setPrice(15900);
				service.insert(inBean);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "3":
				PaymentBean fdBean = service.findByPk(Integer.parseInt(JOptionPane.showInputDialog("Pk?")));
				JOptionPane.showMessageDialog(null, fdBean);
				break;
			case "4":
				PaymentBean upBean = new PaymentBean();
				upBean.setPaySeq(JOptionPane.showInputDialog("Pk?"));
				JOptionPane.showMessageDialog(null, service.update(upBean)==1?"성공":"실패");
				break;
			case "5":
				service.delete(Integer.parseInt(JOptionPane.showInputDialog("Pk?")));
				break;
			case "6":
				JOptionPane.showMessageDialog(null, service.findBy("company:삼성카드"));
				break;
			default:
				break;
			}
		}
	}
}
