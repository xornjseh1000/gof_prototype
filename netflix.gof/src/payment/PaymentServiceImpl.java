package payment;

import java.util.List;
import java.util.Map;



public class PaymentServiceImpl implements PaymentService{
	private PaymentDAO pDao = PaymentDAO.getInstance();
	private static PaymentServiceImpl instance = new PaymentServiceImpl();
	private Map<Integer, PaymentBean> map;
	
	private PaymentServiceImpl() {
		this.map();
	}
	public static PaymentServiceImpl getInstance() {
		return instance;
	}
	@Override
	public List<PaymentBean> list() {
		 return pDao.selectAll();
	}
	@Override
	public List<PaymentBean> findBy(String keyword) {
		String[] format = keyword.split(":");
		return pDao.selectBy(format[0],format[1]);
	}
	@Override
	public Map<Integer, PaymentBean> map() {
		this.map = pDao.selectMap();
		return this.map;
	}
	@Override
	public PaymentBean findByPk(int paySeq) {
		return pDao.selectByPk(paySeq);
	}
	@Override
	public boolean insert(MemberPaymentCard pcmBean) {
		boolean result = false;
		if(pDao.insert(pcmBean)==1){
			result = true;
			this.map();
		}
		return result;
	}
	@Override
	public int update(PaymentBean payBean) {
		this.map();
		return pDao.update(payBean);
	}
	@Override
	public int delete(int paySeq) {
		this.map();
		return pDao.delete(paySeq);
	}
	@Override
	public boolean checkCard(CardBean cardBean) {
		
		// email 보내는 service 만들꺼임!
	
	return true;
	}
}
