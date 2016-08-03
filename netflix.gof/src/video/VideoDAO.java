package video;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import global.Category;
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

	public int insert(VideoBigBean viBean) {
		int result = 0;
		String sql ="INSERT INTO VIDEO(SERIAL_NO,TITLE,SUB_TITLE,CREATE_YEAR,SYNOPS,"
				+ "RUNNING_TIME,FILE_URL,LANGUAGE,REG_DATE,POSTER)"
				+ " VALUES(?,?,?,?,?,?,?,?,SYSDATE,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getSerialNo());
			pstmt.setString(2, viBean.getTitle());
			pstmt.setString(3, viBean.getSubTitle());
			pstmt.setString(4, viBean.getCreateYear());
			pstmt.setString(5, viBean.getS​ynopsis());
			pstmt.setString(6, viBean.getRunningTime());
			pstmt.setString(7, viBean.getFile());
			pstmt.setString(8, viBean.getLanguage());
			pstmt.setString(9, viBean.getPoster());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}

	public void insertProducing(VideoBigBean viBean) {
		String sql = "INSERT INTO PRODUCING(PRODUCER_NO,SERIAL_NO) VALUES(?,?)";
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

	public void insertGenre(VideoBigBean viBean) {
		String sql = "INSERT INTO GENRE_VIDEO(GENRE,SERIAL_NO) VALUES(?,?)";
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

	public void insertCategory(VideoBigBean viBean) {
		String sql = "INSERT INTO CATEGORY_VIDEO(CATEGORY,SERIAL_NO) VALUES(?,?)";
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

	public void insertGroupNo(VideoBigBean viBean) {
		String sql = viBean.getGroupNo()==0? "INSERT INTO GROUP_NO(SERIAL_NO,GROUP_NO) VALUES(?,GROUP_SEQ.NEXTVAL)":
			"INSERT INTO GROUP_NO(SERIAL_NO,GROUP_NO) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, viBean.getSerialNo());
			if(viBean.getGroupNo()!=0){
				pstmt.setInt(2, viBean.getGroupNo());
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insertGrade(VideoBigBean viBean) {
		String sql = "INSERT INTO GRADE_VIDEO(GRADE,SERIAL_NO) VALUES(?,?)";
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

	public void insertSeries(VideoBigBean viBean) {
		String sql = "INSERT INTO SERIES(SERIAL_NO,SEASON,EPISODE) VALUES(?,?,?)";
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

	public void insertAppearance(int actorNo, int serialNo) {
		String sql = "INSERT INTO APPEARANCE(ACTOR_NO,SERIAL_NO) VALUES(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorNo);
			pstmt.setInt(2, serialNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getSeq() {
		int result = 0;
		String sql = "SELECT SERIAL_SEQ.NEXTVAL AS SEQ FROM DUAL";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt("SEQ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(VideoBean viBean) {
		int result = 0;
		String sql = "UPDATE VIDEO SET TITLE=?,SUB_TITLE=?,POSTER=? WHERE SERIAL_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, viBean.getTitle());
			pstmt.setString(2, viBean.getSubTitle());
			pstmt.setString(2, viBean.getPoster());
			pstmt.setInt(4, viBean.getSerialNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Map<Integer, VideoBigBean> selectMap() {
		Map<Integer, VideoBigBean> tempMap = new HashMap<Integer, VideoBigBean>();
		String sql = "SELECT * FROM VIDEO_DETAIL";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet lrs = pstmt.executeQuery();
			while(lrs.next()){
				VideoBigBean bigBean = new VideoBigBean();
				bigBean.setSerialNo(lrs.getInt("SERIAL_NO"));
				bigBean.setTitle(lrs.getString("TITLE"));
				bigBean.setSubTitle(lrs.getString("SUB_TITLE"));
				bigBean.setCreateYear(lrs.getString("CREATE_YEAR"));
				bigBean.setRunningTime(lrs.getString("RUNNING_TIME"));
				bigBean.setFile(lrs.getString("FILE_URL"));
				bigBean.setLanguage(lrs.getString("LANGUAGE"));
				bigBean.setRegDate(lrs.getString("REG_DATE"));
				bigBean.setPoster(lrs.getString("POSTER"));
				bigBean.setS​ynopsis(lrs.getString("SYNOPS"));
				bigBean.setProducer_no(lrs.getInt("PRODUCER_NO"));
				bigBean.setCategory(lrs.getInt("CATEGORY"));
				bigBean.setGenre(lrs.getInt("GENRE"));
				bigBean.setGroupNo(lrs.getInt("GROUP_NO"));
				bigBean.setGrade(lrs.getInt("GRADE"));
				bigBean.setSeason(lrs.getInt("SEASON"));
				bigBean.setEpisode(lrs.getInt("EPISODE"));
				bigBean.setGpa(this.getGpa(bigBean.getSerialNo()));
				bigBean.setActorList(this.getActorList(bigBean.getSerialNo()));
				tempMap.put(bigBean.getSerialNo(), bigBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempMap;
	}	
	private int getGpa(int serialNo) {
		int result = 0;
		String sql = "SELECT NVL(ROUND(AVG(POINT),1),0) GPA FROM GPA WHERE SERIAL_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt("GPA");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getActorList(int serialNo){
		StringBuffer result = new StringBuffer();
		String sql="SELECT ACTOR_NO FROM APPEARANCE WHERE SERIAL_NO=? ORDER BY ACTOR_NO";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialNo);
			rs = pstmt.executeQuery();
			while(rs.next()){
				result.append(rs.getInt("ACTOR_NO")+":");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.substring(0, result.length()-1).toString();
	}

	public List<VideoBigBean> selectAll() {
		List<VideoBigBean> tempList = new ArrayList<VideoBigBean>();
		String sql = "SELECT * FROM VIDEO_DETAIL";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet lrs = pstmt.executeQuery();
			while(lrs.next()){
					VideoBigBean bigBean = new VideoBigBean();
					bigBean.setSerialNo(lrs.getInt("SERIAL_NO"));
					bigBean.setTitle(lrs.getString("TITLE"));
					bigBean.setSubTitle(lrs.getString("SUB_TITLE"));
					bigBean.setCreateYear(lrs.getString("CREATE_YEAR"));
					bigBean.setRunningTime(lrs.getString("RUNNING_TIME"));
					bigBean.setFile(lrs.getString("FILE_URL"));
					bigBean.setLanguage(lrs.getString("LANGUAGE"));
					bigBean.setRegDate(lrs.getString("REG_DATE"));
					bigBean.setPoster(lrs.getString("POSTER"));
					bigBean.setS​ynopsis(lrs.getString("SYNOPS"));
					bigBean.setProducer_no(lrs.getInt("PRODUCER_NO"));
					bigBean.setCategory(lrs.getInt("CATEGORY"));
					bigBean.setGenre(lrs.getInt("GENRE"));
					bigBean.setGroupNo(lrs.getInt("GROUP_NO"));
					bigBean.setGrade(lrs.getInt("GRADE"));
					bigBean.setSeason(lrs.getInt("SEASON"));
					bigBean.setEpisode(lrs.getInt("EPISODE"));
					bigBean.setGpa(this.getGpa(bigBean.getSerialNo()));
					bigBean.setActorList(this.getActorList(bigBean.getSerialNo()));
					tempList.add(bigBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempList;
	}

	public int delete(int serialNo) {
		int result =0;
		String sql = "DELETE FROM VIDEO WHERE SERIAL_NO=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, serialNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public List<Integer> selectBookmark(String email) {
		List<Integer> tempList = new ArrayList<Integer>();
		String sql = "SELECT SERIAL_NO FROM BOOKMARK WHERE EMAIL=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()){
				tempList.add(rs.getInt("SERIAL_NO"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public List<Integer> selectStats(String email) {
		List<Integer> tempList = new ArrayList<Integer>();
		String sql = "SELECT SERIAL_NO FROM STATS WHERE SYSDATE-VIEW_DATE > 0 AND EMAIL=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			while(rs.next()){
				tempList.add(rs.getInt("SERIAL_NO"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

	public List<Integer> selectHotList() {
		List<Integer> tempList = new ArrayList<Integer>();
		String sql = "SELECT SERIAL_NO FROM "
				+ "(SELECT SERIAL_NO, CNT, RANK() OVER(ORDER BY CNT DESC) AS RK FROM "
				+ "(SELECT SERIAL_NO,COUNT(*) CNT FROM STATS GROUP BY SERIAL_NO)) WHERE RK < 10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				tempList.add(rs.getInt("SERIAL_NO"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempList;
	}

}
