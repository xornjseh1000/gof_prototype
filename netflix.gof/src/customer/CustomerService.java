package customer;


import global.CommonService;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :CustomerPageService.java
 * @story  :
*/

public interface CustomerService extends CommonService {
	public CustomerBean findByPk(int cusSeq);
	public int write(CustomerBean cusBean);
	public int update(CustomerBean cusBean);
	public int delete(int cusSeq);
}
