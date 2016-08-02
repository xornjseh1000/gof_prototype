package global;

/**
 * @date   :2016. 7. 7.
 * @author :HyunWoo Lee
 * @file   :DBFactory.java
 * @story  :
*/

public class DBFactory {
	public static Database createDatabase(Vendor vendor,String id,String pw){
		String driver = "",url="";
		switch (vendor) {
		case ORACLE:
			driver = Constants.ORACLE_DRIVER;
			url = Constants.ORACLE_URL;
			break;
		case MYSQL:
			driver = Constants.MYSQL_DRIVER;
			url = Constants.MYSQL_URL;
			break;
		case MSSQL:
			break;
		case MARIADB:
			break;
		default:
			break;
		}
		return new Database(driver,url,id,pw);
	}
}
