package project.com.product;

import java.io.Serializable;

public class ProductVO implements Serializable{
	private int p_num;
	private String p_name;
	private int p_count;
	private int p_level;
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_count() {
		return p_count;
	}
	public void setP_count(int p_count) {
		this.p_count = p_count;
	}
	public int getP_level() {
		return p_level;
	}
	public void setP_level(int p_level) {
		this.p_level = p_level;
	}

}
