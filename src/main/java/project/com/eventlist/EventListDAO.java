package project.com.eventlist;

import java.util.List;


public interface EventListDAO {
	public int insert(EventListVO vo);
	public int update(EventListVO vo);
	public int delete(EventListVO vo);
	public EventListVO serach(EventListVO vo);
	public List<EventListVO> select();
	public List<EventListVO> select(String searchKey,String searchWord);
	
}
