package member;

import global.CommonService;
import payment.MemberPaymentCard;

/**
 * @date   :2016. 7. 27.
 * @author :HyunWoo Lee
 * @file   :MemberService.java
 * @story  :
*/

public interface MemberService extends CommonService{
	public MemberBean findByPk(String email);
	public int regist(MemberBean memBean);
	public MemberBean login(MemberBean memBean);
	public int update(MemberPaymentCard pcmBean);
	public int delete(MemberBean memBean);
	public int addBk(String email,int serialNo);
	public int delBk(String email,int serialNo);
	public int addFav (String email, String fav);
	public int update(String updateInfo);
}
