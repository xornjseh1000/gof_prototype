package actor;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :Actor.java
 * @story  :
*/

public class ActorBean {
	private int actorNo;
	private String korName,engName,profileImg;
	
	public int getActorNo() {
		return actorNo;
	}
	public void setActorNo(int actorNo) {
		this.actorNo = actorNo;
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
}
