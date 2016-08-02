package payment;

public class CardBean {
	private String cardNum,vYear,vMonth,name,company;
	private int birth;
	
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getvYear() {
		return vYear;
	}
	public void setvYear(String vYear) {
		this.vYear = vYear;
	}
	public String getvMonth() {
		return vMonth;
	}
	public void setvMonth(String vMonth) {
		this.vMonth = vMonth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
