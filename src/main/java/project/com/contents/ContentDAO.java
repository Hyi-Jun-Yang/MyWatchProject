package project.com.contents;

import java.util.List;

public interface ContentDAO {
	public int c_insert(ContentVO vo);
	public int c_update(ContentVO vo);
	public int c_delete(ContentVO vo);
	public int reply(ContentVO vo);
	public ContentVO c_search(ContentVO vo);
	public List<ContentVO>  c_select();
	public List<ContentVO>  c_select(int page);
	public List<ContentVO> c_select(int page, String word);
	public List<ContentVO> c_select(String Key, String value);
	public List<ContentVO> replylist(int con_id);
	public List<ContentVO> c_topten();
	public List<ContentVO> c_mylist(ContentVO vo);
	public List<ContentVO> re_select();
	public List<ContentVO> c_select(String word);

}
