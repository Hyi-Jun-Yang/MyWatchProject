package project.com.entryinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryInfoDAOimpl implements EntryInfoDAO {
	
	SqlSession evSqlSession;
	
	public SqlSession getEvSqlSession() {
		return evSqlSession;
	}

	@Autowired
	public void setEvSqlSession(SqlSession evSqlSession) {
		this.evSqlSession = evSqlSession;
	}

	@Override
	public int insert(EntryInfoVO vo) {
		int flag = evSqlSession.insert("en_insert", vo);
		return flag;
	}

	@Override
	public int update(EntryInfoVO vo) {
		int flag = evSqlSession.update("en_update", vo);
		return flag;
	}

	@Override
	public int delete(EntryInfoVO vo) {
		int flag = evSqlSession.delete("en_delete", vo);
		return flag;
	}

	@Override
	public EntryInfoVO search(EntryInfoVO vo) {
		EntryInfoVO svo = evSqlSession.selectOne("en_search",vo);
		return svo;
	}

	@Override
	public List<EntryInfoVO> select() {
		List<EntryInfoVO> list = evSqlSession.selectList("en_select");
		return list;
	}

	@Override
	public List<EntryInfoVO> select(String searchKey, String searchWord) {
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("searchKey", searchKey);
		if(searchKey.compareTo("c_name")==0
				|| searchKey.compareTo("c_tel")==0){
			searchWord="%"+searchWord+"%";
		}		
		
		map.put("searchWord", searchWord);
		List<EntryInfoVO> list = evSqlSession.selectList("en_searchList",map);
		return list;
	}

	@Override
	public void updateCount(int p_num) {
	

	}

}
