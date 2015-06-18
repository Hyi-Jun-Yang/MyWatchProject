package project.com.contents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.com.controller.MemberController;

@Repository
public class ContentDAOimpl implements ContentDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ContentDAOimpl.class);
	SqlSession cSql;
	
	
	public SqlSession getcSql() {
		return cSql;
	}

	@Autowired
	public void setcSql(SqlSession cSql) {
		this.cSql = cSql;
	}

	@Override
	public int c_insert(ContentVO vo) {
		int flag = cSql.insert("c_insert", vo);
		return flag;
	}

	@Override
	public int c_update(ContentVO vo) {
		int flag = cSql.update("c_update", vo);
		return flag;
	}

	@Override
	public int c_delete(ContentVO vo) {
		int flag = cSql.delete("c_delete", vo);
		return flag;
	}

	@Override
	public int reply(ContentVO vo) {
		logger.info("reply");
		ContentVO rvo = cSql.selectOne("re_select", vo);
		vo.setReplynum(rvo.getReplynum());
		vo.setReplylevel(rvo.getReplylevel());
		vo.setReplystep(rvo.getReplystep());
		cSql.update("re_update", vo);
		int flag=cSql.insert("re_insert",vo);
	
		return flag;
	}

	@Override
	public ContentVO c_search(ContentVO vo) {
		ContentVO cvo = cSql.selectOne("c_search", vo);
		cSql.update("c_search_countup",vo);
		return cvo;
	}

	@Override
	public List<ContentVO> c_select() {
		List<ContentVO> list = cSql.selectList("c_select");
		return list;
	}

	@Override
	public List<ContentVO> c_select(int page) {
		int countRow=6;
		int startPage=(page-1)*countRow+1;
		int endPage = (startPage+countRow)-1;
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("startPage", startPage);
		map.put("endPage", endPage);
				
		List<ContentVO> clist = cSql.selectList("c_select_block",map);
		return clist;
	}

	@Override
	public List<ContentVO> c_select(int page, String word) {
		int countRow=5;
		int startPage=(page-1)*countRow+1;
		int endPage = (startPage+countRow)-1;
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("startPage", String.valueOf(startPage));
		map.put("endPage", String.valueOf(endPage));
		map.put("word", "%"+word+"%");
		List<ContentVO> clist = cSql.selectList("c_select_block_word",map);
		return clist;
	}

	@Override
	public List<ContentVO> c_select(String Key, String value) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("Key",Key);
		if(Key.compareTo("con_name")==0){
			value="%"+value+"%";
		}
		map.put("value", value);
		List<ContentVO> clist = cSql.selectList("c_searchList",map);
		return clist;
	}

	@Override
	public List<ContentVO> replylist(int con_id) {
		List<ContentVO> rlist = cSql.selectList("replylist",con_id);
		return rlist;
	}

	@Override
	public List<ContentVO> c_topten() {
		List<ContentVO> tlist = cSql.selectList("topten");
		return tlist;
	}

	@Override
	public List<ContentVO> c_mylist(ContentVO vo) {
		List<ContentVO> mylist = cSql.selectList("mylist",vo);
		return mylist;
	}

	@Override
	public List<ContentVO> re_select() {
		List<ContentVO> rlist = cSql.selectList("replyall");

		return rlist;
	}

	@Override
	public List<ContentVO> c_select(String word) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("Key","con_name");
		map.put("value","%"+word+"%");
		List<ContentVO> wlist = cSql.selectList("c_searchList",map);
		return wlist;
	}

}
