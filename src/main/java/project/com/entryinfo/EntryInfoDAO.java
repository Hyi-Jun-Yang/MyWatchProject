package project.com.entryinfo;

import java.util.List;

public interface EntryInfoDAO {

	public int insert(EntryInfoVO vo);
	public int update(EntryInfoVO vo);
	public int delete(EntryInfoVO vo);
	public EntryInfoVO search(EntryInfoVO vo);
	public List<EntryInfoVO> select();
	public List<EntryInfoVO> select(String searchKey,String searchWord);
	public void updateCount(int p_num);
}
