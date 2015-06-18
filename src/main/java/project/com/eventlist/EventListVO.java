package project.com.eventlist;

import java.io.Serializable;
import java.sql.Timestamp;



public class EventListVO implements Serializable{
	 
	  
	 private int e_id;
	 private String e_title;
	 private Timestamp e_regdate;
	 private int win_count;
	 private String e_content;
	 private Timestamp e_start;
	 private Timestamp e_end;
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	public Timestamp getE_regdate() {
		return e_regdate;
	}
	public void setE_regdate(Timestamp e_regdate) {
		this.e_regdate = e_regdate;
	}
	public int getWin_count() {
		return win_count;
	}
	public void setWin_count(int win_count) {
		this.win_count = win_count;
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
	}
	public Timestamp getE_start() {
		return e_start;
	}
	public void setE_start(Timestamp e_start) {
		this.e_start = e_start;
	}
	public Timestamp getE_end() {
		return e_end;
	}
	public void setE_end(Timestamp e_end) {
		this.e_end = e_end;
	}
	  
	  
	  
}
