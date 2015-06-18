package project.com.cust;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustService {

	private CustDAO dao;

	public CustDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(CustDAO dao) {
		this.dao = dao;
	}
	
	public int insert(CustVO vo) {
		return dao.insert(vo);
	}


	public int update(CustVO vo) {
		return dao.update(vo);
	}


	public int delete(CustVO vo) {
		return dao.delete(vo);
	}


	public CustVO search(CustVO vo) {
		return dao.search(vo);
	}


	public List<CustVO> select() {
		return dao.select();
	}


	public List<CustVO> select(String searchKey, String searchWord) {
		return dao.select(searchKey, searchWord);
	}

	public int telCheck(String c_tel) {
		
		return dao.telCheck(c_tel);
	}
	

	public List<CustVO> dongList() {
		return dao.dongList();
	}


	
	public List<CustVO> zipcode(CustVO vo) {
		return dao.zipcode(vo);
	}

}
