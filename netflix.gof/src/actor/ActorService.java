package actor;

import java.util.List;

import global.CommonService;

/**
 * @date   :2016. 7. 27.
 * @author :HyunWoo Lee
 * @file   :ActorService.java
 * @story  :
*/

public interface ActorService extends CommonService {
	public ActorBean findByPk(int actorNo);
	public int regist(ActorBean acBean);
	public int update(ActorBean acBean);
	public int delete(int actorNo);
	public List<ActorBean> getActorNames(String actorList);
}
