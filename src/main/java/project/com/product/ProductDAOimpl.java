package project.com.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOimpl implements ProductDAO {

	SqlSession pSqlSession;
	
	
	
	public SqlSession getpSqlSession() {
		return pSqlSession;
	}
	
	@Autowired
	public void setpSqlSession(SqlSession pSqlSession) {
		this.pSqlSession = pSqlSession;
	}

	@Override
	public int insert(ProductVO vo) {
		int flag = pSqlSession.insert("p_insert", vo);
		return flag;
	}

	@Override
	public int update(ProductVO vo) {
		int flag = pSqlSession.update("p_update", vo);
		return flag;
	}

	@Override
	public int delete(ProductVO vo) {
		int flag = pSqlSession.delete("p_delete", vo);
		return flag;
	}

	@Override
	public ProductVO search(ProductVO vo) {
		ProductVO svo = pSqlSession.selectOne("p_search", vo);
		return svo;
	}

	@Override
	public List<ProductVO> select() {
		List<ProductVO> list = pSqlSession.selectList("p_select");
		return list;
	}

	@Override
	public List<ProductVO> select(String searchKey, String searchWord) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchKey", searchKey);
		if(searchKey.compareTo("p_name")==0){
			searchWord ="%"+searchWord+"%";
		}
		map.put("searchWord", searchWord);
		
		List<ProductVO> list = pSqlSession.selectList("p_searchList",map);
		return list;
	}

}
