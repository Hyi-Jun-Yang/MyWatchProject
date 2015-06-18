package project.com.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberDAO dao;

	public MemberDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}
	

	public int mjoin(MemberVO vo) {
	
		return dao.mjoin(vo);
	}


	public int mupdate(MemberVO vo) {
	
		return dao.mupdate(vo);
	}


	public int mquit(MemberVO vo) {
	
		return dao.mquit(vo);
	}


	public MemberVO msearch(MemberVO vo) {
	
		return dao.msearch(vo);
	}


	public List<MemberVO> mselect() {
	
		return dao.mselect();
	}


	public List<MemberVO> msearchList(String key, String value) {
	
		return dao.msearchList(key, value);
	}


	public int mcheck(MemberVO vo) {
	
		return dao.mcheck(vo);
	}
}
