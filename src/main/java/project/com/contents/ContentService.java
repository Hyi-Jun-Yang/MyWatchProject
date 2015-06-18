package project.com.contents;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContentService {
	private ContentDAO dao;

	public ContentDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(ContentDAO dao) {
		this.dao = dao;
	}
	

	public int c_insert(ContentVO vo) {
		
		return dao.c_insert(vo);
	}


	public int c_update(ContentVO vo) {
		
		return dao.c_update(vo);
	}


	public int c_delete(ContentVO vo) {
		
		return dao.c_delete(vo);
	}


	public int reply(ContentVO vo) {
		
		return dao.reply(vo);
	}


	public ContentVO c_search(ContentVO vo) {
		
		return dao.c_search(vo);
	}


	public List<ContentVO> c_select() {
		
		return dao.c_select();
	}


	public List<ContentVO> c_select(int page) {
		
		return dao.c_select(page);
	}


	public List<ContentVO> c_select(int page, String word) {
		
		return dao.c_select(page, word);
	}


	public List<ContentVO> c_select(String Key, String value) {
		
		return dao.c_select(Key, value);
	}

	public List<ContentVO> replylist(int con_id) {
		return dao.replylist(con_id);
		
	}

	public List<ContentVO> c_topten() {
		
		return dao.c_topten();
	}

	public List<ContentVO> c_mylist(ContentVO vo) {
		
		return dao.c_mylist(vo);
	}

	public List<ContentVO> re_select() {
		
		return dao.re_select();
	}

	public List<ContentVO> c_select(String word) {
		
		return dao.c_select(word);
	}
	
}
