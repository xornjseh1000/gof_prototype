package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DBFactory;
import global.Vendor;
import payment.MemberPaymentCard;

/**
 * @author: jchoi
 * @date: Aug 1, 2016
 * @file: MemberDAO.java
 */
public class MemberDAO {
	PreparedStatement pstmt;
	Connection conn;
	Statement stmt;
	ResultSet rs;

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}


	public MemberBean findByPk(String email) {
		MemberBean bean= null;
		String sql = "select * from member where email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new MemberBean();
				bean.setEmail(rs.getString("EMAIL"));
				bean.setName(rs.getString("NAME"));
				bean.setPassword(rs.getString("PASSWORD"));
				bean.setGrade(rs.getInt("GRADE"));
				bean.setPhone(rs.getString("PHONE"));
				bean.setRegDate(rs.getString("REG_DATE"));
				bean.setBirth(rs.getString("BIRTH"));
				bean.setProfImg(rs.getString("PROF_IMG"));
				bean.setCardNum(rs.getString("CARD_NUM"));
				bean.setRcvEmail(rs.getString("EMAIL_SV").equals("Y")?true:false);
				bean.setFav(rs.getString("FAV"));
				System.out.println("Data from DAO: "+bean.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return bean;
		
	}


	public int insert(MemberBean memBean) {
		int result = 0;
		String sql = "insert into member(email, password, email_sv,prof_img,reg_date,name,phone)"+" values (?,?,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memBean.getEmail());
			pstmt.setString(2, memBean.getPassword());
			pstmt.setString(3, memBean.isRcvEmail()==true?"Y":"N");
			pstmt.setString(4, memBean.getProfImg());
			pstmt.setString(5, memBean.getName());
			pstmt.setString(6, memBean.getPhone());
			result = pstmt.executeUpdate();
			System.out.println("DAO Insert Result: (1 if success)"+result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(MemberPaymentCard pcmBean) {
        int result = 0;
        System.out.println("비밀번호 : "+pcmBean.getPassword());
        String sql = "UPDATE MEMBER SET NAME=?,BIRTH=?,CARD_NUM=?,PHONE=?,GRADE=?,PASSWORD=? WHERE EMAIL=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pcmBean.getName());
            pstmt.setString(2, String.valueOf(pcmBean.getBirth()));
            pstmt.setString(3, pcmBean.getCardNum());
            pstmt.setString(4, pcmBean.getPhone());
            pstmt.setInt(5, pcmBean.getGrade());
            pstmt.setString(6, pcmBean.getPassword());
            pstmt.setString(7, pcmBean.getEmail());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


	public int delete(MemberBean memBean) {
		int result = 0;
		String sql = "delete from member where email = ? and pw = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memBean.getEmail());
			pstmt.setString(2, memBean.getPassword());
			result = pstmt.executeUpdate();
			System.out.println("DAO Delete Result: (1 if success)"+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int insertBk(String email, int serialNo) {
		int result = 0;
		String sql = "insert into bookmark(email, serial_no)"+ " values (?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, serialNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public int deleteBk(String email, int serialNo) {
		int result = 0;
		String sql = "delete from bookmark where email=? and serial_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, serialNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public List<MemberBean> findBy(String column, String keyword) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "select * from member " + column+"=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberBean memBean = new MemberBean();
				memBean.setEmail(rs.getString("EMAIL"));
				memBean.setName(rs.getString("NAME"));
				memBean.setPassword(rs.getString("PASSWORD"));
				memBean.setGrade(rs.getInt("GRADE"));
				memBean.setPhone(rs.getString("PHONE"));
				memBean.setRegDate(rs.getString("REG_DATE"));
				memBean.setBirth(rs.getString("BIRTH"));
				memBean.setProfImg(rs.getString("PROF_IMG"));
				memBean.setCardNum(rs.getString("CARD_NUM"));
				memBean.setRcvEmail(rs.getString("EMAIL_SV").equals("Y")?true:false);
				memBean.setFav(rs.getString("FAV"));
				list.add(memBean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public int updateFav(String email, String fav) {
		int result = 0;
		String sql = "update member set fav = ? where email = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fav);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<MemberBean>();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MemberBean memBean = new MemberBean();
				memBean.setEmail(rs.getString("EMAIL"));
				memBean.setName(rs.getString("NAME"));
				memBean.setPassword(rs.getString("PASSWORD"));
				memBean.setGrade(rs.getInt("GRADE"));
				memBean.setPhone(rs.getString("PHONE"));
				memBean.setRegDate(rs.getString("REG_DATE"));
				memBean.setBirth(rs.getString("BIRTH"));
				memBean.setProfImg(rs.getString("PROF_IMG"));
				memBean.setCardNum(rs.getString("CARD_NUM"));
				memBean.setRcvEmail(rs.getString("EMAIL_SV").equals("Y")?true:false);
				memBean.setFav(rs.getString("FAV"));
				list.add(memBean);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int update(String email, String column, String value) {
		int result = 0;
		String sql = "update member set "+column+"=? where email=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, value);
			pstmt.setString(2, email);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String selectFav(String email) { // 사용자가 첨에 3개 선택한거로 추천영상 뽑아내기 위한 놈
		String result = "";
		String sql = "SELECT FAV FROM MEMBER WHERE EMAIL=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString("FAV");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}// end class
