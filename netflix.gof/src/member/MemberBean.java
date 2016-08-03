package member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name,email,password,phone,regDate,birth,profImg,cardNum, fav;

	private boolean isRcvEmail;
	private int grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int i) {
		this.grade = i;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		this.regDate = regDate;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getProfImg() {
		return profImg;
	}
	public void setProfImg(String profImg) {
		this.profImg = profImg;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public boolean isRcvEmail() {
		//??
		
		return isRcvEmail;
	}
	public void setRcvEmail(boolean isRcvEmail) {
		this.isRcvEmail = isRcvEmail;
	}
	
	public String getFav() {
		return fav;
	}

	public void setFav(String fav) {
		this.fav = fav;
	}

	@Override
	public String toString() {
		return "MemberBean "
				+ "\n Name: " + name + ""
				+ "\n Email: " + email + ""
				+ "\n Password: " + password + ""
				+ "\n Phone: " + phone
				+ "\n RegDate: " + regDate + ""
				+ "\n Date of Birth: " + birth + ""
				+ "\n Profile Image: " + profImg + ""
				+ "\n Card Num: " + cardNum 
				+ "\n Receive Email(Subscription Y/N): " + isRcvEmail + ""
				+ "\n Grade: " + grade;
	}

}
