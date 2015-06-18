package project.com.entryinfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryInfoService {

	private EntryInfoDAO dao;

	public EntryInfoDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(EntryInfoDAO dao) {
		this.dao = dao;
	}

	
	public int insert(EntryInfoVO vo) {
	
		return dao.insert(vo);
	}

	
	public int update(EntryInfoVO vo) {
	
		return dao.update(vo);
	}

	
	public int delete(EntryInfoVO vo) {
	
		return dao.delete(vo);
	}

	
	public EntryInfoVO search(EntryInfoVO vo) {
	
		return dao.search(vo);
	}

	
	public List<EntryInfoVO> select() {
	
		return dao.select();
	}

	
	public List<EntryInfoVO> select(String searchKey, String searchWord) {
	
		return dao.select(searchKey, searchWord);
	}

	
	public void updateCount(int p_num) {
	

	}
}

