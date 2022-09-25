package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Service {
	public void dbTruncate() {
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String dbUserId = "root";
		String dbPassword = "positive1*";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		
		try {
				connection = DriverManager.getConnection(url, dbUserId, dbPassword);
				
				String sql = "TRUNCATE sys.SEOUL_WIFI;";
				
				preparedstatement = connection.prepareStatement(sql);
				
				
				preparedstatement.executeUpdate(); //결과 int로 리턴 
				
			
			
			}catch (SQLException e) {
			e.printStackTrace();
			}finally {

				try {
					if (rs != null && !rs.isClosed()) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if (preparedstatement != null && !preparedstatement.isClosed()) {
						preparedstatement.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if (connection != null && !connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	

		}
		
	
	
	public void dbInsert(APIExp apiexp){
	
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		
		List<WIFITable> wifiList = apiexp.APIToDB();

		
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			for(WIFITable wifitableset : wifiList){
			
			String sql = "insert into sys.SEOUL_WIFI("+
					"X_SWIFI_MGR_NO, "+
					"X_SWIFI_WRDOFC, "+
					"X_SWIFI_MAIN_NM, "+
					"X_SWIFI_ADRES1, "+
					"X_SWIFI_ADRES2, "+
					"X_SWIFI_INSTL_FLOOR, "+
					"X_SWIFI_INSTL_TY, "+
					"X_SWIFI_INSTL_MBY, "+
					"X_SWIFI_SVC_SE, "+
					"X_SWIFI_CMCWR, "+
					"X_SWIFI_CNSTC_YEAR, "+
					"X_SWIFI_INOUT_DOOR, "+
					"X_SWIFI_REMARS3, "+
					" LAT, LNT, WORK_DTTM)" +
					"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			preparedstatement = connection.prepareStatement(sql);
					preparedstatement.setString(1, wifitableset.getX_swifi_mgr_no());
					preparedstatement.setString(2, wifitableset.getX_swifi_wrdofc());
					preparedstatement.setString(3, wifitableset.getX_swifi_main_nm());
					preparedstatement.setString(4, wifitableset.getX_swifi_adres1());
					preparedstatement.setString(5, wifitableset.getX_swifi_adres2());
					preparedstatement.setString(6, wifitableset.getX_swifi_instl_floor());
					preparedstatement.setString(7, wifitableset.getX_swifi_instl_ty());
					preparedstatement.setString(8, wifitableset.getX_swifi_instl_mby());
					preparedstatement.setString(9, wifitableset.getX_swifi_svc_se());
					preparedstatement.setString(10, wifitableset.getX_swifi_cmcwr());
					preparedstatement.setString(11, wifitableset.getX_swifi_cnstc_year());
					preparedstatement.setString(12, wifitableset.getX_swifi_inout_door());
					preparedstatement.setString(13, wifitableset.getX_swifi_remars3());
					preparedstatement.setString(14, wifitableset.getLat());
					preparedstatement.setString(15, wifitableset.getLnt());
					preparedstatement.setString(16, wifitableset.getWork_dttm());
			
	
			preparedstatement.executeUpdate(); // 결과가 컬렉션 형태로 나오므로 result set으로 가져와야함 
		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (preparedstatement != null && !preparedstatement.isClosed()) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	} 

	
	
	
	
	
	

	
	public String dbCount(){
		
	int countResult = 0;
	
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "SELECT COUNT(*) FROM sys.SEOUL_WIFI";
			
			preparedstatement = connection.prepareStatement(sql);
			
			
			rs = preparedstatement.executeQuery(); 
			if(rs.next()){
				countResult = rs.getInt(1);
			}
			
			}
			
			catch (SQLException e) {
			e.printStackTrace();
			}finally {

				try {
					if (rs != null && !rs.isClosed()) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if (preparedstatement != null && !preparedstatement.isClosed()) {
						preparedstatement.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					if (connection != null && !connection.isClosed()) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
		return Integer.toString(countResult);
	

		}



public List<WIFITable> list20(String userLat, String userLnt) {
	
	
	List<WIFITable> wifiList = new ArrayList<>();
		
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;

		
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "SELECT *,"
					+ "       (6371 * acos ( cos ( radians("+userLat+") )"
					+ "          * cos( radians( LAT ) )"
					+ "          * cos( radians( LNT ) - radians("+userLnt+") )"
					+ "          + sin ( radians("+userLat+") ) * sin( radians( LAT ) ))"
					+ "       ) "
					+ "AS distance "
					+ "FROM sys.SEOUL_WIFI "
					+ "ORDER BY distance "
					+ "LIMIT 0 , 20";
			
			preparedstatement = connection.prepareStatement(sql);

			
			rs = preparedstatement.executeQuery(); // 결과가 컬렉션 형태로 나오므로 result set으로 가져와야함 
			
			while(rs.next()) {
				 String distance = rs.getString("distance");
				 String x_swifi_mgr_no = rs.getString("X_SWIFI_MGR_NO");
				 String x_swifi_wrdofc = rs.getString("X_SWIFI_WRDOFC");
				 String x_swifi_main_nm = rs.getString("X_SWIFI_MAIN_NM");
				 String x_swifi_adres1 = rs.getString("X_SWIFI_ADRES1");
				 String x_swifi_adres2 = rs.getString("X_SWIFI_ADRES2");
				 String x_swifi_instl_floor = rs.getString("X_SWIFI_INSTL_FLOOR");
				 String x_swifi_instl_ty = rs.getString("X_SWIFI_INSTL_TY");
				 String x_swifi_instl_mby = rs.getString("X_SWIFI_INSTL_MBY");
				 String x_swifi_svc_se = rs.getString("X_SWIFI_SVC_SE");
				 String x_swifi_cmcwr = rs.getString("X_SWIFI_CMCWR");
				 String x_swifi_cnstc_year = rs.getString("X_SWIFI_CNSTC_YEAR");
				 String x_swifi_inout_door = rs.getString("X_SWIFI_INOUT_DOOR");
				 String x_swifi_remars3 = rs.getString("X_SWIFI_REMARS3");
				 String lat = rs.getString("LAT");
				 String lnt = rs.getString("LNT");
				 String work_dttm = rs.getString("WORK_DTTM");
				 
				 
	
				WIFITable wifitable = new WIFITable();
				wifitable.setDistance(distance);
            	wifitable.setX_swifi_mgr_no(x_swifi_mgr_no);
            	wifitable.setX_swifi_wrdofc(x_swifi_wrdofc);
            	wifitable.setX_swifi_main_nm(x_swifi_main_nm);
            	wifitable.setX_swifi_adres1(x_swifi_adres1);
            	wifitable.setX_swifi_adres2(x_swifi_adres2);
            	wifitable.setX_swifi_instl_floor(x_swifi_instl_floor);
            	wifitable.setX_swifi_instl_ty(x_swifi_instl_ty);
            	wifitable.setX_swifi_instl_mby(x_swifi_instl_mby);
            	wifitable.setX_swifi_svc_se(x_swifi_svc_se);
            	wifitable.setX_swifi_cmcwr(x_swifi_cmcwr);
            	wifitable.setX_swifi_cnstc_year(x_swifi_cnstc_year);
            	wifitable.setX_swifi_inout_door(x_swifi_inout_door);
            	wifitable.setX_swifi_remars3(x_swifi_remars3);
            	wifitable.setLat(lat);
            	wifitable.setLnt(lnt);
        		wifitable.setWork_dttm(work_dttm);
				
				
				wifiList.add(wifitable);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (preparedstatement != null && !preparedstatement.isClosed()) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return wifiList;
	}


public void historyInsert(String userLat, String userLnt) {
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		


		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "insert into sys.HISTORY (LAT_LOG, LNT_LOG, SEARCH_DTTM) " +
					"values(?, ?, now()) ";
			
			preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setString(1, userLat);
			preparedstatement.setString(2, userLnt);
			

			
			preparedstatement.executeUpdate(); // 결과가 컬렉션 형태로 나오므로 result set으로 가져와야함 
			
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (preparedstatement != null && !preparedstatement.isClosed()) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}



public List<WIFIHistory> historyList() {
	
	
	List<WIFIHistory> historyList = new ArrayList<>();
		
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;

		
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "select ID, LAT_LOG, LNT_LOG, SEARCH_DTTM "
					+ "from sys.HISTORY "
					+ " order by SEARCH_DTTM DESC";
			
			preparedstatement = connection.prepareStatement(sql);

			
			rs = preparedstatement.executeQuery(); // 결과가 컬렉션 형태로 나오므로 result set으로 가져와야함 
			
			while(rs.next()) {
				 int id = rs.getInt(1);
				 String lat_log = rs.getString("LAT_LOG");
				 String lnt_log = rs.getString("LNT_LOG");
				 String search_dttm = rs.getString("SEARCH_DTTM");

				 
	
				WIFIHistory wifihistory = new WIFIHistory();
				wifihistory.setId(id);
				wifihistory.setLat_log(lat_log);
				wifihistory.setLnt_log(lnt_log);
				wifihistory.setSearch_dttm(search_dttm);
				
        		historyList.add(wifihistory);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (preparedstatement != null && !preparedstatement.isClosed()) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return historyList;
	}

public void historyDelete(int id) {
	
	String url = "jdbc:mysql://127.0.0.1:3306/";
	String dbUserId = "root";
	String dbPassword = "positive1*";
	
	//1. 드라이버로드
	//2. 커넥션 객체 생성
	//3. 스테이트먼트 객체 생성
	//4. 쿼리 실행
	//5. 결과 수행
	//6. 객체 연결 해제(close)
	

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		


		
		
		try {
			connection = DriverManager.getConnection(url, dbUserId, dbPassword);
			
			String sql = "delete from sys.HISTORY "
					+ "where ID = ?";
			
			preparedstatement = connection.prepareStatement(sql);
			
			preparedstatement.setInt(1, id);


			
			int affected = preparedstatement.executeUpdate(); //결과 int로 리턴 
			
			if(affected > 0) {
				System.out.println(" 삭제 성공 ");
			} else {
				System.out.println(" 삭제 실패 ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {

			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (preparedstatement != null && !preparedstatement.isClosed()) {
					preparedstatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}




}
