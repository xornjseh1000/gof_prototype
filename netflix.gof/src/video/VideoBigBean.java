package video;

import java.io.Serializable;

/**
 * @date   :2016. 7. 26.
 * @author :HyunWoo Lee
 * @file   :Video.java
 * @story  :
*/

public class VideoBigBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int serialNo,grade,season,episode,groupNo,producer_no,category,genre;
	private String title,subTitle,createYear,s​ynopsis,runningTime,
			file,language,regDate,poster,actorList;
	private double gpa;
	//grade point average
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getEpisode() {
		return episode;
	}
	public void setEpisode(int episode) {
		this.episode = episode;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public int getProducer_no() {
		return producer_no;
	}
	public void setProducer_no(int producer_no) {
		this.producer_no = producer_no;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getActorList() {
		return actorList;
	}
	public void setActorList(String actorList) {
		this.actorList = actorList;
	}
	
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "VideoBigBean [serialNo=" + serialNo + ", grade=" + grade + ", season=" + season + ", episode=" + episode
				+ ", groupNo=" + groupNo + ", producer_no=" + producer_no + ", category=" + category + ", genre="
				+ genre + ", title=" + title + ", subTitle=" + subTitle + ", createYear=" + createYear
				+ ", runningTime=" + runningTime + ", file=" + file + ", language=" + language + ", regDate=" + regDate
				+ ", poster=" + poster + ", actorList=" + actorList + " gpa=" + gpa + " ]\n";
	}
}
