package payment;

public class PaymentBean {
	private int paySeq,price;
	private String cardNum,company,payDate,expireDate;
	
	public int getPaySeq() {
		return paySeq;
	}
	public void setPaySeq(int paySeq) {
		this.paySeq = paySeq;
	}
	public void setPaySeq(String paySeq) {
		this.paySeq = Integer.parseInt(paySeq);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	@Override
	public String toString() {
		return "PaymentBean [paySeq=" + paySeq + ", price=" + price + ", cardNum=" + cardNum + ", company=" + company
				+ ", payDate=" + payDate + ", expireDate=" + expireDate + "]\n";
	}
}
