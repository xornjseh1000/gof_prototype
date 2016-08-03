package actor;

import java.io.Serializable;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :Actor.java
 * @story  :
*/

public class ActorBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
	@Override
	public String toString() {
		return "ActorBean [actorNo=" + actorNo + ", korName=" + korName + ", engName=" + engName + ", profileImg="
				+ profileImg + "]\n";
	}
	
}
