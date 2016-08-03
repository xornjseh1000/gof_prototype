package video;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :Video.java
 * @story  :
*/

public class VideoBean {
	private int serialNo;
	private String title,subTitle,createYear,s​ynopsis,runningTime,
			file,language,regDate,poster;
	//grade point average
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getCreateYear() {
		return createYear;
	}
	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}
	public String getS​ynopsis() {
		return s​ynopsis;
	}
	public void setS​ynopsis(String s​ynopsis) {
		this.s​ynopsis = s​ynopsis;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "VideoBean [serialNo=" + serialNo + ", title=" + title + ", subTitle=" + subTitle + ", createYear="
				+ createYear + ", runningTime=" + runningTime + ", file=" + file + ", language=" + language
				+ ", regDate=" + regDate + ", poster=" + poster + "]\n";
	}
	
	
}
