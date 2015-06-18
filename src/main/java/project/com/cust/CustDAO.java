package project.com.cust;

import java.util.List;

public interface CustDAO {

	public int insert(CustVO vo);
	public int update(CustVO vo);
	public int delete(CustVO vo);
	public CustVO search(CustVO vo);
	public List<CustVO> select();
	public List<CustVO> select(String searchKey,String searchWord);
	public int telCheck(String c_tel);
	public List<CustVO> zipcode(CustVO vo);
	public List<CustVO> dongList();
	
}
