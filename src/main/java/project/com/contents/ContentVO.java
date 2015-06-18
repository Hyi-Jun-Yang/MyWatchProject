package project.com.contents;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class ContentVO implements Serializable{

	private int con_id;
	private String con_name;
	private String con_writer;
	private String con_link;
	private int con_rank;
	public int getCon_id() {
		return con_id;
	}
	public void setCon_id(int con_id) {
		this.con_id = con_id;
	}
	private int con_limit;
	private Timestamp con_regedate;
	private int scount;
	private int reply;
	private int replynum;
	private int replystep;
	private int replylevel;
	private String replycontext;
	private MultipartFile multipartFile;
	private String replyprofile;
	
	public String getReplyprofile() {
		return replyprofile;
	}
	public void setReplyprofile(String replyprofile) {
		this.replyprofile = replyprofile;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	public String getReplycontext() {
		return replycontext;
	}
	public void setReplycontext(String replycontext) {
		this.replycontext = replycontext;
	}
	public int getScount() {
		return scount;
	}
	public void setScount(int scount) {
		this.scount = scount;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public int getReplystep() {
		return replystep;
	}
	public void setReplystep(int replystep) {
		this.replystep = replystep;
	}
	public int getReplylevel() {
		return replylevel;
	}
	public void setReplylevel(int replylevel) {
		this.replylevel = replylevel;
	}
	public Timestamp getCon_regedate() {
		return con_regedate;
	}
	public void setCon_regedate(Timestamp con_regedate) {
		this.con_regedate = con_regedate;
	}
	public void setCon_limit(int con_limit) {
		this.con_limit = con_limit;
	}
	
	public int getCon_limit() {
		return con_limit;
	}
	public String getCon_name() {
		return con_name;
	}
	public void setCon_name(String con_name) {
		this.con_name = con_name;
	}
	public String getCon_writer() {
		return con_writer;
	}
	public void setCon_writer(String con_writer) {
		this.con_writer = con_writer;
	}
	public String getCon_link() {
		return con_link;
	}
	public void setCon_link(String con_link) {
		this.con_link = con_link;
	}
	public int getCon_rank() {
		return con_rank;
	}
	public void setCon_rank(int con_rank) {
		this.con_rank = con_rank;
	}




}
