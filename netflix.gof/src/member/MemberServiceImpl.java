package member;

import java.util.List;
import java.util.Map;

import payment.MemberPaymentCard;
import payment.PaymentDAO;

/**
 * @author: jchoi
 * @date: Aug 1, 2016
 * @file: MemberServiceImpl.java
 */
public class MemberServiceImpl implements MemberService {

	private static MemberServiceImpl instance = new MemberServiceImpl();
	private MemberDAO dao = MemberDAO.getInstance();
	private PaymentDAO pDao = PaymentDAO.getInstance();
	
	private MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<MemberBean> list() {
		return dao.selectAll();
	}
	
	@Override
	public List<MemberBean> findBy(String keyword) { // keyword=columname:keyword 
		String[] format = keyword.split(":");
		return dao.findBy(format[0],format[1]);
	}
	@Override
	public Map<?, ?> map() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean findByPk(String email) {
		return dao.findByPk(email);
	}

	@Override
	public int regist(MemberBean memBean) {
		int result = 0;
		memBean.setProfImg("default.jpg");
		
		if (dao.insert(memBean)==1) {
			System.out.println("Registration success from DAO");
			result = 1;
		} else{
			System.out.println("Registration failed from DAO");
		}
		return result;
	}
	
	@Override
	public MemberBean login(MemberBean memBean) {
		
		MemberBean loginBean = dao.findByPk(memBean.getEmail());
		if (loginBean!=null && loginBean.getPassword().equals(memBean.getPassword())) {
			System.out.println("Login success from DAO");
		} else {
			loginBean = new MemberBean();
			loginBean.setEmail("fail");
			System.out.println("Login failed from DAO");
		}
		return loginBean;
	}

	@Override
	public int update(MemberPaymentCard pcmBean) {
		int result = 0;
		if (dao.update(pcmBean)==1) {
			System.out.println("dao succ");
			if(pDao.insert(pcmBean)==1){
				System.out.println("Update success from DAO");
				result = 1;
			}
		} else {
			System.out.println("Update failed from DAO");
		}
		return result;
	}
	@Override
	public int accupdate(MemberPaymentCard pcmBean) {
		int result = 0;
		if (dao.update(pcmBean)==1) {
				System.out.println("Update success from DAO");
				result = 1;
		} else {
			System.out.println("Update failed from DAO");
		}
		return result;
	}
	@Override
	public int delete(MemberBean memBean) {
		int result = 0;
		if (dao.delete(memBean)==1) {
			System.out.println("Delete success from DAO");
			result = 1;
		} else {
			System.out.println("Delete failed from DAO");
		}
		return result;
	}

	@Override
	public int addBk(String email, int serialNo) {
		int result = 0;
		if (dao.insertBk(email, serialNo)==1) {
			System.out.println("AddFavorite from DAO");
			result = 1;
		} else {
			System.out.println("AddFavorite from DAO");
		}

		return result;
	}

	@Override
	public int delBk(String email, int serialNo) {
		int result = 0;
		if (dao.deleteBk(email, serialNo)==1) {
			System.out.println("AddFavorite from DAO");
			result = 1;
		} else {
			System.out.println("AddFavorite from DAO");
		}
		return result;
	}


	@Override
	public int addFav(String email, String fav) {
		int result = 0;
		if (dao.updateFav(email, fav)==1) {
			System.out.println("Update fav success");
			result = 1;
		} else {
			System.out.println("Update fav failed");
		}
		return result;
	}

	@Override
	public int update(String updateInfo) {
		String[] arr = updateInfo.split(":");
		int result = 0;
		if (dao.update(arr[0],arr[1],arr[2])==1) {
			System.out.println("Update user info success");
			result = 1;
		} else {
			System.out.println("Update user info failed");
		}
		return result;
	}

}// end class
