package admin;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :StatsBean.java
 * @story  :
*/

public class StatsBean {
	private int statsSeq,serialNo;
	private String email,viewDate;
	
	public int getStatsSeq() {
		return statsSeq;
	}
	public void setStatsSeq(int statsSeq) {
		this.statsSeq = statsSeq;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getViewDate() {
		return viewDate;
	}
	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}
}
