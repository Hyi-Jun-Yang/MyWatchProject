package project.com.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.com.member.MemberService;
import project.com.member.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	public static Logger getLogger() {
		return logger;
	}
	
	private MemberService ms;
	
	

	public MemberService getMs() {
		return ms;
	}

	@Autowired
	public void setMs(MemberService ms) {
		this.ms = ms;
	}

	@RequestMapping(value = "/manager.do", 
			method = RequestMethod.GET)
	public String manager() {
		logger.info("manager!");
		
		return ".manager";
	}
	
	@RequestMapping(value = "/m_insert.do", 
			method = RequestMethod.GET)
	public String m_insert() {
				
		return "member/m_insert";
	}
	
	
	@RequestMapping(value = "/m_insertOK.do", 
			method = RequestMethod.POST)
	public ModelAndView m_insertOk(HttpServletRequest request
			,@ModelAttribute("uploadForm") MemberVO vo) 
			throws IllegalStateException, IOException {

		MultipartFile multipartfile = vo.getMutilpartfile();
		if(null != multipartfile){
			String m_profile = multipartfile.getOriginalFilename();
			vo.setM_profile(m_profile);
			String realPath = request.getRealPath("resources");
			File orgin_img = new File(realPath+"/"+m_profile);
			multipartfile.transferTo(orgin_img);
			BufferedImage original_buffer_img =	ImageIO.read(orgin_img);
			BufferedImage thumb_buffer_img = 
					new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 100,100,null);
			
			File thumb_file = new File(realPath+"/thumb_"+m_profile);
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
			
		}
		
		
		int flag = ms.mjoin(vo);
		
		String pageName = "";
		if(flag>0){
			pageName = "redirect:m_select.do";
		}else{
			pageName = "redirect:m_insert.do";
		}
		
		return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/m_update.do", 
			method = RequestMethod.POST)
	public ModelAndView m_updateOk(@ModelAttribute("uploadForm") MemberVO vo,HttpServletRequest request)
			throws IllegalStateException, IOException {
		MultipartFile multipartfile = vo.getMutilpartfile();
		if(null != multipartfile){
			String m_profile = multipartfile.getOriginalFilename();
			vo.setM_profile(m_profile);
			String realPath = request.getRealPath("resources");
			logger.info(realPath);
			File orgin_img = new File(realPath+"/"+m_profile);
			multipartfile.transferTo(orgin_img);
			BufferedImage original_buffer_img =	ImageIO.read(orgin_img);
			BufferedImage thumb_buffer_img = 
					new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumb_buffer_img.createGraphics();
			graphic.drawImage(original_buffer_img, 0, 0, 100,100,null);
			
			File thumb_file = new File(realPath+"/thumb_"+m_profile);
			ImageIO.write(thumb_buffer_img, "jpg", thumb_file);
			
		}
		int flag = ms.mupdate(vo);
		
		String pageName = "";
		if(flag>0){
			pageName = "redirect:m_select.do";
		}else{
			pageName = "redirect:m_search.do";
		}
		
		return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/m_delete.do", 
			method = RequestMethod.GET)
	public ModelAndView m_deleteOk(MemberVO vo) {
		
		int flag = ms.mquit(vo);
		
		String pageName = "";
		if(flag>0){
			pageName = "redirect:m_select.do";
		}else{
			pageName = "redirect:m_search.do";
		}
		
		return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/m_search.do", 
			method = RequestMethod.GET)
	public String m_search(MemberVO vo,Model model,HttpServletRequest session) {
		session.setAttribute("user_id",vo.getM_id());
		MemberVO mvo = ms.msearch(vo);
		model.addAttribute("mvo",mvo);
		return "member/m_search";
	}
	
	@RequestMapping(value = "/m_select.do", 
			method = RequestMethod.GET)
	public String m_select(Model model) {
		
		List<MemberVO> mlist = ms.mselect();
		model.addAttribute("mlist",mlist);
		return ".m_select";
	}
	
	@RequestMapping(value = "/m_searchList.do", 
			method = RequestMethod.GET)
	public String m_searchList(Model model,String key,String value) {
		List<MemberVO> mlist = ms.msearchList(key, value);
		model.addAttribute("mlist",mlist);
		return ".m_select";
	}
	
	@RequestMapping(value = "/m_check.do", 
			method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> m_check(MemberVO vo) {
		logger.info("m_check.do"+vo.getM_id());
		Map<String, String> map = new HashMap<String, String>();
		int flag=ms.mcheck(vo);
		if(flag==1){
			map.put("result","UnAvailable");
		}else{
			map.put("result","Available");
		}
		
		return map;
	}
	
	
	
	
	
	
}
