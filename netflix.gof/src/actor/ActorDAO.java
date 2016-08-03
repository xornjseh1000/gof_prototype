package actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import global.Constants;
import global.DBFactory;
import global.Vendor;

public class ActorDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static ActorDAO instance = new ActorDAO();
	
	private ActorDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static ActorDAO getInstance() {
		return instance;
	}
	public int insert(ActorBean acBean) {
		int result = 0;
		String sql = "INSERT INTO ACTOR(ACTOR_NO,KOR_NAME,ENG_NAME,PROFILE_IMG)"
				+ " VALUES(ACTOR_SEQ.NEXTVAL,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acBean.getKorName());
			pstmt.setString(2, acBean.getEngName());
			pstmt.setString(3, acBean.getProfileImg());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int update(ActorBean acBean) {
		int result = 0;
		String sql = "UPDATE ACTOR SET KOR_NAME=?,ENG_NAME=?,PROFILE_IMG=? WHERE ACTOR_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acBean.getKorName());
			pstmt.setString(2, acBean.getEngName());
			pstmt.setString(3, acBean.getProfileImg());
			pstmt.setInt(4, acBean.getActorNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(int actorNo) {
		int result = 0;
		String sql = "DELETE FROM ACTOR WHERE ACTOR_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ActorBean selectByPk(int actorNo) {
		ActorBean actBean = null;
		String sql = "SELECT * FROM ACTOR WHERE ACTOR_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				actBean = new ActorBean();
				actBean.setActorNo(rs.getInt("ACTOR_NO"));
				actBean.setKorName(rs.getString("KOR_NAME"));
				actBean.setEngName(rs.getString("ENG_NAME"));
				actBean.setProfileImg(rs.getString("PROFILE_IMG"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actBean;
	}
	public List<ActorBean> selectAll() {
		List<ActorBean> tempList = new ArrayList<ActorBean>();
		String sql = "SELECT * FROM ACTOR";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ActorBean actBean = new ActorBean();
				actBean.setActorNo(rs.getInt("ACTOR_NO"));
				actBean.setKorName(rs.getString("KOR_NAME"));
				actBean.setEngName(rs.getString("ENG_NAME"));
				actBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempList.add(actBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	public List<ActorBean> selectBy(String column, String value) {
		List<ActorBean> tempList = new ArrayList<ActorBean>();
		String sql = "SELECT * FROM ACTOR WHERE "+column+" LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+value+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				ActorBean actBean = new ActorBean();
				actBean.setActorNo(rs.getInt("ACTOR_NO"));
				actBean.setKorName(rs.getString("KOR_NAME"));
				actBean.setEngName(rs.getString("ENG_NAME"));
				actBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempList.add(actBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	public Map<Integer, ActorBean> selectMap() {
		Map<Integer, ActorBean> tempMap = new HashMap<Integer, ActorBean>();
		String sql = "SELECT * FROM ACTOR";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ActorBean actBean = new ActorBean();
				actBean.setActorNo(rs.getInt("ACTOR_NO"));
				actBean.setKorName(rs.getString("KOR_NAME"));
				actBean.setEngName(rs.getString("ENG_NAME"));
				actBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempMap.put(actBean.getActorNo(), actBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}	
}
