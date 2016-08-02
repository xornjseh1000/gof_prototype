package video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import global.Constants;
import global.DBFactory;
import global.Vendor;

public class VideoDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private static VideoDAO instance = new VideoDAO();
	
	private VideoDAO() {
		conn = DBFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}

	public static VideoDAO getInstance() {
		return instance;
	}

	public int insert(VideoBean viBean) {
		int result = 0;
		String sql ="INSERT INTO VIDEO(SERIAL_NO,TITLE,SUB_TITLE,CREATE_YEAR,SYNOPS,"
				+ "RUNNING_TIME,FILE_URL,LANGUAGE,REG_DATE,POSTER)"
				+ " VALUES(SERIAL_SEQ.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, viBean.getTitle());
			pstmt.setString(2, viBean.getSubTitle());
			pstmt.setString(3, viBean.getCreateYear());
			pstmt.setString(4, viBean.getS​ynopsis());
			pstmt.setString(5, viBean.getRunningTime());
			pstmt.setString(6, viBean.getFile());
			pstmt.setString(7, viBean.getLanguage());
			pstmt.setString(8, viBean.getPoster());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

	public void insertProducing(VideoBean viBean) {
		String sql = "INSERT INTO PRODUCING VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getProducer_no());
			pstmt.setInt(2, viBean.getSerialNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertGenre(VideoBean viBean) {
		String sql = "INSERT INTO GENRE_VIDEO VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getGenre());
			pstmt.setInt(2, viBean.getSerialNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertCategory(VideoBean viBean) {
		String sql = "INSERT INTO CATEGORY_VIDEO VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getCategory());
			pstmt.setInt(2, viBean.getSerialNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void insertGroupNo(VideoBean viBean) {
		String sql = "INSERT INTO GROUP_NO VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getGroupNo());
			pstmt.setInt(2, viBean.getSerialNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertGrade(VideoBean viBean) {
		String sql = "INSERT INTO GRADE_VIDEO VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getGrade());
			pstmt.setInt(2, viBean.getSerialNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insertSeries(VideoBean viBean) {
		String sql = "INSERT INTO SERIES VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getSerialNo());
			pstmt.setInt(2, viBean.getSeason());
			pstmt.setInt(3, viBean.getEpisode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
