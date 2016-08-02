package customer;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
	
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerDAO cusDao = CustomerDAO.getInstance();
	private Map<Integer, CustomerBean> map;
	
	private CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static CustomerServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<?> list() {
		return cusDao.selectAll();
	}

	@Override
	public List<?> findBy(String keyword) {
		return cusDao.selectBy(keyword);
	}

	@Override
	public Map<?, ?> map() {
		this.map = cusDao.selectMap();
		return map;
	}

	@Override
	public CustomerBean findByPk(int cusSeq) {
		// TODO Auto-generated method stub
		return cusDao.selectByPk(cusSeq);
	}

	@Override
	public int write(CustomerBean cusBean) {		
		return cusDao.insert(cusBean);
	}

	@Override
	public int update(CustomerBean cusBean) {
		return cusDao.update(cusBean);
	}

	@Override
	public int delete(int cusSeq) {
		// TODO Auto-generated method stub
		return cusDao.delete(cusSeq);
	}
	
}
