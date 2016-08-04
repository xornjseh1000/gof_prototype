package payment;

import global.CommonService;

/**
 * @date   :2016. 7. 27.
 * @author :HyunWoo Lee
 * @file   :PaymentService.java
 * @story  :
*/

public interface PaymentService extends CommonService{
	public PaymentBean findByPk(int paySeq);
	public boolean insert(MemberPaymentCard pcBean);
	public int update(PaymentBean payBean);
	public int delete(int paySeq);
	public boolean checkCard(CardBean cardBean);
}
