package project.com.cust;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustDAOimpl implements CustDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(CustDAOimpl.class);
	
	public CustDAOimpl() {
		logger.info("CustDAOimpl....");
	}
	
	SqlSession cSqlsession;
	public SqlSession getcSqlsession() {
		return cSqlsession;
	}
	
	@Autowired
	public void setcSqlsession(SqlSession cSqlsession) {
		this.cSqlsession = cSqlsession;
	}

	@Override
	public int insert(CustVO vo) {
		int flag = cSqlsession.insert("cu_insert",vo);
		return flag;
	}

	@Override
	public int update(CustVO vo) {
		
		int flag = cSqlsession.update("cu_update",vo);
		return flag;
	}

	@Override
	public int delete(CustVO vo) {
		
		int flag = cSqlsession.delete("cu_delete",vo);
		return flag;
	}

	@Override
	public CustVO search(CustVO vo) {
		CustVO svo= cSqlsession.selectOne("cu_search",vo);
		return svo;
	}

	@Override
	public List<CustVO> select() {
		List<CustVO> list = cSqlsession.selectList("cu_select");
		return list;
	}

	@Override
	public List<CustVO> select(String searchKey, String searchWord) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchKey",searchKey);
		map.put("searchWord", "%"+searchWord+"%");
		List<CustVO> list = cSqlsession.selectList("cu_searchList",map);
		return list;
	}

	@Override
	public int telCheck(String c_tel) {
		int flag=0;
		if( cSqlsession.selectOne("cu_search",c_tel)==null){
			flag=1;
		}else{
			flag=0;
		}
		logger.info("flag"+flag);
			
			
		return flag;
	}


	@Override
	public List<CustVO> dongList() {
		List<CustVO> list = cSqlsession.selectList("dong_list");
		return list;
	}


	@Override
	public List<CustVO> zipcode(CustVO vo) {
		List<CustVO> list = cSqlsession.selectList("zipcode",vo);
		return list;
	}

}
