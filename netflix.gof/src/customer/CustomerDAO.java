package customer;

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

public class CustomerDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static CustomerDAO instance = new CustomerDAO();
	
	private CustomerDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}

	public static CustomerDAO getInstance() {
		return instance;
	}

	public int insert(CustomerBean cusBean) {
		int result = 0;
		String sql = "INSERT INTO CUSTOMER_CENTER(CUSTOMER_SEQ,CATEGORY,TITLE,CONTENT)"
				+ " VALUES(CUSTOMER_SEQ.NEXTVAL,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusBean.getCategory());
			pstmt.setString(2, cusBean.getTitle());
			pstmt.setString(3, cusBean.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(CustomerBean cusBean) {
		int result = 0;
		String sql = "UPDATE CUSTOMER_CENTER SET TITLE=?,CONTENT=? WHERE CUSTOMER_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusBean.getTitle());
			pstmt.setString(2, cusBean.getContent());
			pstmt.setInt(3, cusBean.getCusSeq());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int delete(int cusSeq) {
		int result = 0;
		String sql = "DELETE CUSTOMER_CENTER WHERE CUSTOMER_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cusSeq);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public CustomerBean selectByPk(int cusSeq) {
		CustomerBean tempBean = null;
		String sql = "SELECT * FROM CUSTOMER_CENTER WHERE CUSTOMER_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cusSeq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				tempBean = new CustomerBean();
				tempBean.setCusSeq(rs.getInt("CUSTOMER_SEQ"));
				tempBean.setCategory(rs.getString("CATEGORY"));
				tempBean.setTitle(rs.getString("TITLE"));
				tempBean.setContent(rs.getString("CONTENT"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempBean;
	}

	public List<CustomerBean> selectAll() {
		List<CustomerBean> tempList = new ArrayList<CustomerBean>();
		String sql = "SELECT * FROM CUSTOMER_CENTER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CustomerBean tempBean = new CustomerBean();
				tempBean.setCusSeq(rs.getInt("CUSTOMER_SEQ"));
				tempBean.setCategory(rs.getString("CATEGORY"));
				tempBean.setTitle(rs.getString("TITLE"));
				tempBean.setContent(rs.getString("CONTENT"));
				tempList.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public List<CustomerBean> selectBy(String keyword) {
		List<CustomerBean> tempList = new ArrayList<CustomerBean>();
		String sql = "SELECT * FROM CUSTOMER_CENTER WHERE TITLE LIKE ? OR CONTENT LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				CustomerBean tempBean = new CustomerBean();
				tempBean.setCusSeq(rs.getInt("CUSTOMER_SEQ"));
				tempBean.setCategory(rs.getString("CATEGORY"));
				tempBean.setTitle(rs.getString("TITLE"));
				tempBean.setContent(rs.getString("CONTENT"));
				tempList.add(tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public Map<Integer, CustomerBean> selectMap() {
		Map<Integer, CustomerBean> tempMap = new HashMap<Integer, CustomerBean>();
		String sql = "SELECT * FROM CUSTOMER_CENTER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				CustomerBean tempBean = new CustomerBean();
				tempBean.setCusSeq(rs.getInt("CUSTOMER_SEQ"));
				tempBean.setCategory(rs.getString("CATEGORY"));
				tempBean.setTitle(rs.getString("TITLE"));
				tempBean.setContent(rs.getString("CONTENT"));
				tempMap.put(tempBean.getCusSeq(), tempBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tempMap;
	}
	
}
