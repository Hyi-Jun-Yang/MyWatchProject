package project.com.entryinfo;

import java.io.Serializable;
import java.sql.Timestamp;

public class EntryInfoVO implements Serializable {
	
	private int e_num;
	private Timestamp e_date;
	private String e_office;
	private int e_id;
	private String c_name;
	private String c_tel;
	private int is_win;
	private int win_rank;
	private Timestamp win_date;
	private int p_num;
	private int take_result;
	private Timestamp take_date;
	private String take_office;

	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	public Timestamp getE_date() {
		return e_date;
	}

	public void setE_date(Timestamp e_date) {
		this.e_date = e_date;
	}

	public String getE_office() {
		return e_office;
	}

	public void setE_office(String e_office) {
		this.e_office = e_office;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_tel() {
		return c_tel;
	}

	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}

	public int getIs_win() {
		return is_win;
	}

	public void setIs_win(int is_win) {
		this.is_win = is_win;
	}

	public int getWin_rank() {
		return win_rank;
	}

	public void setWin_rank(int win_rank) {
		this.win_rank = win_rank;
	}

	public Timestamp getWin_date() {
		return win_date;
	}

	public void setWin_date(Timestamp win_date) {
		this.win_date = win_date;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getTake_result() {
		return take_result;
	}

	public void setTake_result(int take_result) {
		this.take_result = take_result;
	}

	public Timestamp getTake_date() {
		return take_date;
	}

	public void setTake_date(Timestamp take_date) {
		this.take_date = take_date;
	}

	public String getTake_office() {
		return take_office;
	}

	public void setTake_office(String take_office) {
		this.take_office = take_office;
	}

}
