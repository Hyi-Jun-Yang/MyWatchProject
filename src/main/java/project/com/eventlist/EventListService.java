package project.com.eventlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventListService {
	
	EventListDAO dao ;

	public EventListDAO getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(EventListDAO dao) {
		this.dao = dao;
	}
	
	public int insert(EventListVO vo) {
		
		return dao.insert(vo);
	}

	public int update(EventListVO vo) {
		
		return dao.update(vo);
	}

	public int delete(EventListVO vo) {
		
		return dao.delete(vo);
	}

	public EventListVO serach(EventListVO vo) {
		
		return dao.serach(vo);
	}

	public List<EventListVO> select() {
		
		return dao.select();
	}

	public List<EventListVO> select(String searchKey, String searchWord) {
		
		return dao.select(searchKey, searchWord);
	}
	

}
