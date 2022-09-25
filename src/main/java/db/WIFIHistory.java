package db;

public class WIFIHistory {
	private int id;
	private String lat_log;
	private String lnt_log;
	private String search_dttm;

	
	
	public String getLat_log() {
		return lat_log;
	}
	public void setLat_log(String lat_log) {
		this.lat_log = lat_log;
	}
	public String getLnt_log() {
		return lnt_log;
	}
	public void setLnt_log(String lnt_log) {
		this.lnt_log = lnt_log;
	}
	public String getSearch_dttm() {
		return search_dttm;
	}
	public void setSearch_dttm(String search_dttm) {
		this.search_dttm = search_dttm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
