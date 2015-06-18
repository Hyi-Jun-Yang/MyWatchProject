package project.com.member;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberVO implements Serializable {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_birthday;
	private Timestamp m_joindate;
	private MultipartFile mutilpartfile;
	private String m_profile;
	
	public MultipartFile getMutilpartfile() {
		return mutilpartfile;
	}
	public void setMutilpartfile(MultipartFile mutilpartfile) {
		this.mutilpartfile = mutilpartfile;
	}
	public String getM_profile() {
		return m_profile;
	}
	public void setM_profile(String m_profile) {
		this.m_profile = m_profile;
	}
	
	public String getM_id() {
		return m_id;
	}
	public String getM_birthday() {
		return m_birthday;
	}
	public void setM_birthday(String m_birthday) {
		this.m_birthday = m_birthday;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	public Timestamp getM_joindate() {
		return m_joindate;
	}
	public void setM_joindate(Timestamp m_joindate) {
		this.m_joindate = m_joindate;
	}
	

}
