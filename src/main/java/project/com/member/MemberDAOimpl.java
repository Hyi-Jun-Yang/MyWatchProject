package project.com.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.com.controller.HomeController;

@Repository
public class MemberDAOimpl implements MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOimpl.class);
	SqlSession mSql;
	public SqlSession getmSql() {
		return mSql;
	}

	@Autowired
	public void setmSql(SqlSession mSql) {
		this.mSql = mSql;
	}

	@Override
	public int mjoin(MemberVO vo) {
		int flag = mSql.insert("m_insert",vo);
		return flag;
	}

	@Override
	public int mupdate(MemberVO vo) {
		int flag = mSql.update("m_update",vo);
		return flag;
	}

	@Override
	public int mquit(MemberVO vo) {
		int flag = mSql.delete("m_delete",vo);
		return flag;
	}

	@Override
	public MemberVO msearch(MemberVO vo) {
		MemberVO svo = mSql.selectOne("m_search",vo);
		return svo;
	}

	@Override
	public List<MemberVO> mselect() {
		List<MemberVO> list = mSql.selectList("m_select");
		return list;
	}

	@Override
	public List<MemberVO> msearchList(String key, String value) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("key",key);
		map.put("value", value);
		List<MemberVO> list = mSql.selectList("m_searchList", map);
		return list;
	}

	@Override
	public int mcheck(MemberVO vo) {
		int flag=0;
		logger.info("mcheck");
		if(mSql.selectOne("m_search",vo)!=null){
			MemberVO cvo = mSql.selectOne("m_search",vo);
			logger.info("vo.getM_pw() : "+vo.getM_pw());
			logger.info("cvo.getM_pw() : "+cvo.getM_pw());
			
			if(cvo.getM_id()==vo.getM_id()&&cvo.getM_pw()!=vo.getM_pw()){
				flag=-1;
			}else{
				flag=1;
			}
		}else{
			flag=-2;
		}
		return flag;
	}

}
