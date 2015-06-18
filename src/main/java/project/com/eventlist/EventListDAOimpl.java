package project.com.eventlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EventListDAOimpl implements EventListDAO{
	
	SqlSession eSqlseeion;

	public SqlSession geteSqlseeion() {
		return eSqlseeion;
	}

	@Autowired
	public void seteSqlseeion(SqlSession eSqlseeion) {
		this.eSqlseeion = eSqlseeion;
	}

	@Override
	public int insert(EventListVO vo) {
		int flag = eSqlseeion.insert("e_insert",vo);
		return flag;
	}

	@Override
	public int update(EventListVO vo) {
		
		int flag = eSqlseeion.update("e_update",vo);
		return flag;
	}

	@Override
	public int delete(EventListVO vo) {
		
		int flag = eSqlseeion.delete("e_delete",vo);
		return flag;
	}

	@Override
	public EventListVO serach(EventListVO vo) {
		EventListVO svo = eSqlseeion.selectOne("e_search", vo);
		return svo;
	}

	@Override
	public List<EventListVO> select() {
		List<EventListVO> list = eSqlseeion.selectList("e_select");
		return list;
	}

	@Override
	public List<EventListVO> select(String searchKey, String searchWord) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey);
		
		if(searchKey.compareTo("e_title")==0){
			searchWord="%"+searchWord+"%";
		}
		
		map.put("searchWord", searchWord);
		
		List<EventListVO> list = eSqlseeion.selectList("e_searchList",map);
		return list;
	}

}
