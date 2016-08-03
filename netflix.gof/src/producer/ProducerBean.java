package producer;

public class ProducerBean {
	private int ProducerNo;
	private String korName,engName,profileImg;
	
	public int getProducerNo() {
		return ProducerNo;
	}
	public void setProducerNo(int producerNo) {
		ProducerNo = producerNo;
	}
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	@Override
	public String toString() {
		return "ProducerBean [ProducerNo=" + ProducerNo + ", korName=" + korName + ", engName=" + engName
				+ ", profileImg=" + profileImg + "]\n";
	}
	
}
