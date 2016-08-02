package member;

import javax.swing.JOptionPane;

import payment.MemberPaymentCard;

/**
 * @author: jchoi
 * @date: Aug 1, 2016
 * @file: MemberController.java
 */
public class MemberController2 {
	public static void main(String[] args) {
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean memBean;
		MemberPaymentCard pcmBean;
		while (true) {
			switch (JOptionPane.showInputDialog(""
					+ "1. Register with Email \n"
					+ "2. Register with additional info \n" //not yet
					+ "3. Add Favorite (One time only) \n"
					+ "4. Log In \n"
					+ "5. Add Bookmark \n"
					+ "6. Delete Bookmark \n"
					+ "7. User Info Update \n"
					+ "8. Delete Account \n"
				    + "=======Admin======= \n"
					+ "9. Find By Email \n"
					+ "10. Find By Keyword \n"
					+ "11. List All \n"
					+ "0. Exit")) {

			case "1":
				//Register with email
				memBean = new MemberBean();
				String temp1 = JOptionPane.showInputDialog("Email, Password, isRcvEmail(Y/N)");
				String[] arrTemp1 = temp1.split(",");
				memBean.setEmail(arrTemp1[0]);
				memBean.setPassword(arrTemp1[1]);
				memBean.setRcvEmail(arrTemp1[2].equals("Y")?true:false);
				service.regist(memBean);
				break;
			case "2":
				//Register with additional info
				pcmBean = new MemberPaymentCard();
				String temp2 = JOptionPane.showInputDialog("Name,Birth,Card_Num,Phone,Grade,Email");
				String[] arrTemp2 = temp2.split(",");
				pcmBean.setName(arrTemp2[0]);
				pcmBean.setBirth(Integer.parseInt(arrTemp2[1]));
				pcmBean.setCardNum(arrTemp2[2]);
				pcmBean.setPhone(arrTemp2[3]);
				pcmBean.setGrade(Integer.parseInt(arrTemp2[4]));
				pcmBean.setEmail(arrTemp2[5]);
				service.update(pcmBean);
				break;
			case "3":
				//Add fav
				service.addFav(JOptionPane.showInputDialog("Email: "), JOptionPane.showInputDialog("Fav: "));
				break;
			case "4":
				//Log In
				service.login(JOptionPane.showInputDialog("Email: "), JOptionPane.showInputDialog("PW: "));
				break;
			case "5":
				service.addBk(JOptionPane.showInputDialog("Email: "), Integer.parseInt(JOptionPane.showInputDialog("Serial No.: ")));
				break;
			case "6":
				service.delBk(JOptionPane.showInputDialog("Email: "), Integer.parseInt(JOptionPane.showInputDialog("Serial No.: ")));
				break;
			case "7":
				//user info update
				service.update(JOptionPane.showInputDialog("Email:Column:Value"));
				break;
			case "8":
				//delete account
				memBean = new MemberBean();
				String temp3 = JOptionPane.showInputDialog("Account Email, Password to be deleted: ");
				String[] arrTemp3 = temp3.split(",");
				memBean.setEmail(arrTemp3[0]);
				memBean.setPassword(arrTemp3[1]);
				service.delete(memBean);
				break;
			case "9":
				//Find By Email
				String email = JOptionPane.showInputDialog("Email: ");
				service.findByPk(email);
				break;
			case "10":
				//Find By Keyword
				service.findBy(JOptionPane.showInputDialog("Column:Keyword"));
				break;
			case "11":
				//List All
				service.list();
				break;
			case "0":return;
			default:
				break;
			}
		}
	}
	
}
