package producer;

import java.util.List;
import java.util.Map;

public class ProducerServiceImpl implements ProducerService{

	private static ProducerServiceImpl instance = new ProducerServiceImpl();
	private ProducerDAO proDao;
	private Map<Integer, ProducerBean> map;
	
	private ProducerServiceImpl() {
		proDao = ProducerDAO.getInstance();
	}

	public static ProducerServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<?> list() {
		// TODO Auto-generated method stub
		return proDao.selectAll();
	}

	@Override
	public List<?> findBy(String keyword) {
		// TODO Auto-generated method stub
		return proDao.selectBy(keyword);
	}

	@Override
	public Map<?, ?> map() {
		this.map = proDao.selectMap();
		return map;
	}

	@Override
	public ProducerBean findByPk(int prdNo) {
		// TODO Auto-generated method stub
		return proDao.selectByPk(prdNo);
	}

	@Override
	public int regist(ProducerBean prdBean) {
		return proDao.insert(prdBean);
	}

	@Override
	public int update(ProducerBean prdBean) {
		return proDao.update(prdBean);
	}

	@Override
	public int delete(int prdNo) {
		return proDao.delete(prdNo);
	}
	
}
