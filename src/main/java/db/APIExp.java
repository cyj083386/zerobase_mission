/* Java 1.8 샘플 코드 */
package db;




import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import db.WIFITable;

public class APIExp{
	
	public JSONObject APIreq(int start, int end) {
		
		String result = "";
		JSONObject jsonObject = null;
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formatedNow = now.format(formatter);
		 
		
		try{
  		URL url = new URL("http://openapi.seoul.go.kr:8088/5445657a4763796a39304555425161/json/TbPublicWifiInfo/"+start+"/"+end+"/"+formatedNow);

		BufferedReader bf;

		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

		result = bf.readLine();

    	JSONParser jsonParser = new JSONParser();
    	jsonObject = (JSONObject)jsonParser.parse(result);
    	
		}catch(Exception e) {
    		e.printStackTrace();
    	}
		return jsonObject;
  		
	}
	
	
	public List<WIFITable> APIToDB(){
		List<WIFITable> wifiList = new ArrayList<>();
    	
    	// 파싱한 데이터를 저장할 변수
    	String result = "";
    	
 
    	String Row_size = "";
    	
    	try {
    		
    		JSONObject jsonObjectTemp = APIreq(1,1);
    		JSONObject TbPublicWifiInfoTemp = (JSONObject)jsonObjectTemp.get("TbPublicWifiInfo");
    		long total = (long) TbPublicWifiInfoTemp.get("list_total_count");
    		total = Long.valueOf(total).intValue();
    		
    	 	
        	String x_swifi_mgr_no;
        	String x_swifi_wrdofc;
        	String x_swifi_main_nm;
        	String x_swifi_adres1;
        	String x_swifi_adres2;
        	String x_swifi_instl_floor;
        	String x_swifi_instl_ty;
        	String x_swifi_instl_mby;
        	String x_swifi_svc_se;
        	String x_swifi_cmcwr;
        	String x_swifi_cnstc_year;
        	String x_swifi_inout_door;
        	String x_swifi_remars3;
        	String lat;
        	String lnt;
        	String work_dttm;
        	
    		for(int i = 0; i <= total/1000; i++) {
	    		JSONObject jsonObject = APIreq(i*1000+1, (i+1)*1000);
	        	JSONObject TbPublicWifiInfo = (JSONObject)jsonObject.get("TbPublicWifiInfo");
	    		
	
	        	JSONArray Row = (JSONArray)TbPublicWifiInfo.get("row");
	        
	        	
	        	
	        	for(int j = 0; j < Row.size(); j++) {
	        		
	        		JSONObject Row_num = (JSONObject)Row.get(j);
	        		
	            	x_swifi_mgr_no = (String) Row_num.get("X_SWIFI_MGR_NO");
	            	x_swifi_wrdofc = (String) Row_num.get("X_SWIFI_WRDOFC");
	            	x_swifi_main_nm = (String) Row_num.get("X_SWIFI_MAIN_NM");
	            	x_swifi_adres1 = (String) Row_num.get("X_SWIFI_ADRES1");
	            	x_swifi_adres2 = (String) Row_num.get("X_SWIFI_ADRES2");
	            	x_swifi_instl_floor = (String) Row_num.get("X_SWIFI_INSTL_FLOOR");
	            	x_swifi_instl_ty = (String) Row_num.get("X_SWIFI_INSTL_TY");
	            	x_swifi_instl_mby = (String) Row_num.get("X_SWIFI_INSTL_MBY");
	            	x_swifi_svc_se = (String) Row_num.get("X_SWIFI_SVC_SE");
	            	x_swifi_cmcwr = (String) Row_num.get("X_SWIFI_CMCWR");        
	            	x_swifi_cnstc_year = (String) Row_num.get("X_SWIFI_CNSTC_YEAR");
	            	x_swifi_inout_door =  (String) Row_num.get("X_SWIFI_INOUT_DOOR");
	            	x_swifi_remars3 = (String) Row_num.get("X_SWIFI_REMARS3");
	            	lat =  (String) Row_num.get("LAT");
	            	lnt = (String) Row_num.get("LNT");
	            	work_dttm = (String) Row_num.get("WORK_DTTM");
	            	
	            	
	            	WIFITable wifitable = new WIFITable();
	            	
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
    		}
    	
    		}catch(Exception e) {
        		e.printStackTrace();
        	}
    		

    		
    	return wifiList;
    	}
	


}
