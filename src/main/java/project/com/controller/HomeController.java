package project.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.com.contents.ContentService;
import project.com.contents.ContentVO;
import project.com.member.MemberService;
import project.com.member.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private ContentService cs;
	private MemberService ms;
	private int check;
	private String user_id;
	public ContentService getCs() {
		return cs;
	}

	@Autowired
	public void setCs(ContentService cs) {
		this.cs = cs;
	}

	public MemberService getMs() {
		return ms;
	}

	@Autowired
	public void setMs(MemberService ms) {
		this.ms = ms;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/","/index.do"}, method = RequestMethod.GET)
	public String index(Model model,String page) {
		int getPage=1;
		if (page!= null) {
			getPage = Integer.parseInt(page);
		}
		List<ContentVO> clist=cs.c_select(getPage);
		int totalCount = clist.size();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("clist",clist );	
		
		List<ContentVO> tlist = cs.c_topten();
		model.addAttribute("tlist",tlist);
		
		if(user_id!=null){
			ContentVO vo = new ContentVO();
			vo.setCon_writer(user_id);
			List<ContentVO> mylist = cs.c_mylist(vo);
			model.addAttribute("mylist", mylist);
		}
		return "index";
	}
	
	@RequestMapping(value ={"/watchList.do"}, method = RequestMethod.POST)
	public String watchList(Model model,String page,String word,HttpSession session)
	{
		int getPage=1;
		if (page!= null) {
			getPage = Integer.parseInt(page);
		}
		List<ContentVO> clist=cs.c_select(getPage);
		int totalCount = clist.size();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("clist",clist );	
		
		List<ContentVO> tlist = cs.c_topten();
		model.addAttribute("tlist",tlist);
		
		if(user_id!=null){
			ContentVO vo = new ContentVO();
			vo.setCon_writer(user_id);
			List<ContentVO> mylist = cs.c_mylist(vo);
			model.addAttribute("mylist", mylist);
		}
		
		List<ContentVO> wlist = cs.c_select(word);
		model.addAttribute("wlist", wlist);
		
		return "index";
	}
	
	@RequestMapping(value ={"/watch.do"}, method = RequestMethod.GET)
	public String watch(Model model,ContentVO vo,HttpSession session) {
		ContentVO cvo = new ContentVO();
		
		cvo = cs.c_search(vo);
		model.addAttribute("cvo",cvo);
		session.setAttribute("user_id",user_id);
		
		if(user_id==null){
			List<ContentVO> clist=cs.c_select();
			model.addAttribute("clist",clist );
		}else{
			MemberVO mvo = new MemberVO();
			mvo.setM_id(user_id);
			mvo = ms.msearch(mvo);
			model.addAttribute("mvo",mvo);
			vo.setCon_writer(user_id);
			List<ContentVO> mylist = cs.c_mylist(vo);
			model.addAttribute("mylist", mylist);
		}
		
		List<ContentVO> rlist=cs.replylist(vo.getCon_id());
		model.addAttribute("rlist", rlist);
		return "watch/watch";
		
	}
	
	@RequestMapping(value ={"/file_upload.do"}, method = RequestMethod.GET)
	public String upload(HttpSession session) {
		session.setAttribute("user_id",user_id);
		return "contents/c_insert";
	}
	
	@RequestMapping(value ={"/join.do"}, method = RequestMethod.GET)
	public String join(Model model) {
		
		return "member/m_insert";
	}
	
	@RequestMapping(value ={"/login.do"}, method = RequestMethod.GET)
	public String login(Model model) {
		check=0;
		return "watch/login";
	}
	
	
	
	@RequestMapping(value ={"/loginOK.do"}, method = RequestMethod.POST)
	public String loginOK(HttpSession session,String user_id,String user_pw) {
		logger.info("loginOK"+user_id);
		check=0;
		String pageName="";
		MemberVO vo= new MemberVO();
		vo.setM_id(user_id);
		vo.setM_pw(user_pw);
		check = ms.mcheck(vo);
		this.user_id=user_id;
			logger.info("check : "+check);
			if(check==1){
				session.setAttribute("user_id",vo.getM_id());
				pageName="redirect:index.do";
			}else if(check==-1||check==-2){
				session.setAttribute("check",check);
				pageName="redirect:login.do";
			}else{
				pageName="redirect:login.do";
			}
						
		return pageName;
	}
	
	@RequestMapping(value ="/logout.do",
			method = RequestMethod.GET)
	public String logout(HttpSession session) {
		logger.info("logout");
		session.invalidate();
		user_id=null;
		return "redirect:index.do";
	}
	
	@RequestMapping(value = "/replyOK.do", method = RequestMethod.GET)
	public String b_replyOK(@ModelAttribute ContentVO vo,HttpServletRequest request) 
			throws IllegalStateException, IOException {
		logger.info("replyOK!!!"+vo.getCon_id());
		if(user_id!=null){
			MemberVO mvo = new MemberVO();
			mvo.setM_id(user_id);
			mvo = ms.msearch(mvo);
			vo.setReplyprofile(mvo.getM_profile());
		}else{
			vo.setReplyprofile("noimage.png");
		}
		
		int re = cs.reply(vo);
		if(re>=0){
			return "redirect:watch.do?con_id="+vo.getCon_id()+"&user_id="+user_id;
		}else{
			return "redirect:index.do";
		}
	}	
	
	@RequestMapping(value ={"/and_select.do"}, method = RequestMethod.GET)
	@ResponseBody
	public Map<String,List<ContentVO>> and_select(Model model,String page)
	{
		
		List<ContentVO> clist=cs.c_select();
		Map<String,List<ContentVO>> map = new HashMap<String, List<ContentVO>>();	
		
		map.put("clist",clist);
		
		
		
		return map;
	}
	
	@RequestMapping(value ={"/and_watchlist.do"}, method = RequestMethod.POST)
	@ResponseBody
	public Map<String,List<ContentVO>> and_watchList(Model model,String word)
	{	
		Map<String,List<ContentVO>> map = new HashMap<String, List<ContentVO>>();	
		List<ContentVO> wlist = cs.c_select(word);
		map.put("wlist", wlist);
		
		return map;
	}
	
	
	
}
