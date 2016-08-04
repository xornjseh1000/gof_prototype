package customer;

import java.io.Serializable;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :CustomerBean.java
 * @story  :
*/

public class CustomerBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cusSeq;
	private String category,title,content;
	
	public int getCusSeq() {
		return cusSeq;
	}
	public void setCusSeq(int cusSeq) {
		this.cusSeq = cusSeq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CustomerBean [cusSeq=" + cusSeq + ", category=" + category + ", title=" + title + ", content=" + content
				+ "]\n";
	}
	
}
