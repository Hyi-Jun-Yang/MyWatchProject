package project.com.member;

import java.util.List;

public interface MemberDAO {
	public int mjoin(MemberVO vo);
	public int mupdate(MemberVO vo);
	public int mquit(MemberVO vo);
	public MemberVO msearch(MemberVO vo);
	public List<MemberVO>  mselect();
	public List<MemberVO>  msearchList(String key,String value);
	public int mcheck(MemberVO vo);

}	