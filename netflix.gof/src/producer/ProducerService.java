package producer;

import global.CommonService;

public interface ProducerService extends CommonService{
	public ProducerBean findByPk(int prdNo);
	public int regist(ProducerBean prdBean);
	public int delete(int prdNo);
	public int update(ProducerBean prdBean);
}
