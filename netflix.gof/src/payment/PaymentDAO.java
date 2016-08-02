package payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DBFactory;
import global.Vendor;

public class PaymentDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static PaymentDAO instance = new PaymentDAO();
	
	private PaymentDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}

	public static PaymentDAO getInstance() {
		return instance;
	}

	public int insert(MemberPaymentCard payBean) {
		int result = 0;
		String sql = "INSERT INTO PAYMENT(PAY_SEQ,CARD_NUM,PRICE,COMPANY,PAY_DATE,EXPIRE_DATE)"
				+ " VALUES(PAY_SEQ.NEXTVAL,?,?,?,SYSDATE,ADD_MONTHS(SYSDATE, 1))";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, payBean.getCardNum());
			pstmt.setInt(2, payBean.getPrice());
			pstmt.setString(3, payBean.getCompany());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int delete(int paySeq) {
		int result = 0;
		String sql = "DELETE FROM PAYMENT WHERE PAY_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paySeq);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(PaymentBean payBean) {
		int result = 0;
		String sql = "UPDATE PAYMENT SET EXPIRE_DATE = EXPIRE_DATE+7 WHERE PAY_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, payBean.getPaySeq());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<PaymentBean> selectAll() {
		List<PaymentBean> tempList = new ArrayList<PaymentBean>();
		String sql = "SELECT * FROM PAYMENT";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PaymentBean pBean = new PaymentBean();
				pBean.setPaySeq(rs.getInt("PAY_SEQ"));
				pBean.setCardNum(rs.getString("CARD_NUM"));
				pBean.setCompany(rs.getString("COMPANY"));
				pBean.setPrice(rs.getInt("PRICE"));
				pBean.setPayDate(rs.getString("PAY_DATE"));
				pBean.setExpireDate(rs.getString("EXPIRE_DATE"));
				tempList.add(pBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public PaymentBean selectByPk(int paySeq) {
		PaymentBean pBean = null;
		String sql = "SELECT * FROM PAYMENT WHERE PAY_SEQ=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paySeq);
			rs = pstmt.executeQuery();
			if(rs.next()){
				pBean = new PaymentBean();
				pBean.setPaySeq(rs.getInt("PAY_SEQ"));
				pBean.setCardNum(rs.getString("CARD_NUM"));
				pBean.setCompany(rs.getString("COMPANY"));
				pBean.setPrice(rs.getInt("PRICE"));
				pBean.setPayDate(rs.getString("PAY_DATE"));
				pBean.setExpireDate(rs.getString("EXPIRE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pBean;
	}

	public int update(MemberPaymentCard pcmBean) {
		int result = 0;
		String sql = "UPDATE MEMBER SET NAME=?,BIRTH=?,CARD_NUM=?,PHONE=?,GRADE=? WHERE EMAIL=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pcmBean.getName());
			pstmt.setString(2, String.valueOf(pcmBean.getBirth()));
			pstmt.setString(3, pcmBean.getCardNum());
			pstmt.setString(4, pcmBean.getPhone());
			pstmt.setInt(5, pcmBean.getGrade());
			pstmt.setString(6, pcmBean.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<PaymentBean> selectBy(String column, String word) {
		List<PaymentBean> tempList = new ArrayList<PaymentBean>();
		String sql = "SELECT * FROM PAYMENT WHERE "+column+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PaymentBean pBean = new PaymentBean();
				pBean.setPaySeq(rs.getInt("PAY_SEQ"));
				pBean.setCardNum(rs.getString("CARD_NUM"));
				pBean.setCompany(rs.getString("COMPANY"));
				pBean.setPrice(rs.getInt("PRICE"));
				pBean.setPayDate(rs.getString("PAY_DATE"));
				pBean.setExpireDate(rs.getString("EXPIRE_DATE"));
				tempList.add(pBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}
	
}
