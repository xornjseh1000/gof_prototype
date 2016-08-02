package producer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import global.Constants;
import global.DBFactory;
import global.Vendor;

public class ProducerDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static ProducerDAO instance = new ProducerDAO();
	
	private ProducerDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}
	public static ProducerDAO getInstance() {
		return instance;
	}
	public int insert(ProducerBean prdBean) {
		int result=0;
		String sql="INSERT INTO PRODUCER(PRODUCER_NO,KOR_NAME,ENG_NAME,PROFILE_IMG)"
				+ " VALUES(PRODUCER_SEQ.NEXTVAL,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prdBean.getKorName());
			pstmt.setString(2, prdBean.getEngName());
			pstmt.setString(3, prdBean.getProfileImg());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int update(ProducerBean prdBean) {
		int result=0;
		String sql = "UPDATE PRODUCER SET KOR_NAME=?,ENG_NAME=?,PROFILE_IMG=? WHERE PRODUCER_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prdBean.getKorName());
			pstmt.setString(2, prdBean.getEngName());
			pstmt.setString(3, prdBean.getProfileImg());
			pstmt.setInt(4, prdBean.getProducerNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(int prdNo) {
		int result=0;
		String sql = "DELETE FROM PRODUCER WHERE PRODUCER_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prdNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ProducerBean selectByPk(int prdNo) {
		ProducerBean tempBean = null;
		String sql = "SELECT * FROM PRODUCER WHERE PRODUCER_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prdNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				tempBean = new ProducerBean();
				tempBean.setProducerNo(rs.getInt("PRODUCER_NO"));
				tempBean.setKorName(rs.getString("KOR_NAME"));
				tempBean.setEngName(rs.getString("ENG_NAME"));
				tempBean.setProfileImg(rs.getString("PROFILE_IMG"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}
	public List<ProducerBean> selectAll() {
		List<ProducerBean> tempList = new ArrayList<ProducerBean>();
		String sql = "SELECT * FROM PRODUCER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProducerBean tempBean = new ProducerBean();
				tempBean.setProducerNo(rs.getInt("PRODUCER_NO"));
				tempBean.setKorName(rs.getString("KOR_NAME"));
				tempBean.setEngName(rs.getString("ENG_NAME"));
				tempBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempList.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempList;
	}
	public List<ProducerBean> selectBy(String keyword) {
		List<ProducerBean> tempList = new ArrayList<ProducerBean>();
		String sql = "SELECT * FROM PRODUCER WHERE KOR_NAME LIKE ? OR ENG_NAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProducerBean tempBean = new ProducerBean();
				tempBean.setProducerNo(rs.getInt("PRODUCER_NO"));
				tempBean.setKorName(rs.getString("KOR_NAME"));
				tempBean.setEngName(rs.getString("ENG_NAME"));
				tempBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempList.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	public Map<Integer, ProducerBean> selectMap() {
		Map<Integer, ProducerBean> tempMap = new HashMap<Integer, ProducerBean>();
		String sql = "SELECT * FROM PRODUCER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ProducerBean tempBean = new ProducerBean();
				tempBean.setProducerNo(rs.getInt("PRODUCER_NO"));
				tempBean.setKorName(rs.getString("KOR_NAME"));
				tempBean.setEngName(rs.getString("ENG_NAME"));
				tempBean.setProfileImg(rs.getString("PROFILE_IMG"));
				tempMap.put(tempBean.getProducerNo(), tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}
}
