package project.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import project.com.contents.ContentService;
import project.com.contents.ContentVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ContentsController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ContentsController.class);
	
	public static Logger getLogger() {
		return logger;
	}
	
	ContentService cs;

	
	public ContentService getCs() {
		return cs;
	}

	@Autowired
	public void setCs(ContentService cs) {
		this.cs = cs;
	}


	@RequestMapping(value = "/c_insert.do", 
			method = RequestMethod.GET)
	public String c_insert() {
				
		return "contents/c_insert";
	}
	
	
	@RequestMapping(value = "/c_insertOK.do", 
			method = RequestMethod.POST)
	public ModelAndView c_insertOk(@ModelAttribute("uploadForm") ContentVO vo
			,HttpServletRequest request)  throws IllegalStateException, IOException {
		logger.info("c_insertOK.do......................");
		MultipartFile multipartFile = vo.getMultipartFile();
	
		String url ="C:\\Streamming";
			
		if(null != multipartFile){
			String con_link =null;
			String originName = multipartFile.getOriginalFilename();
			
			Runtime run = Runtime.getRuntime();
			
			if(vo.getCon_writer()==null||vo.getCon_writer()==" "){
				con_link = "anony_"+originName;	
			}else{				
				con_link = vo.getCon_writer()+"_"+originName;	
			}
			
			File orgin_file = new File(url+"/"+con_link);
			multipartFile.transferTo(orgin_file);
			vo.setCon_link(con_link);
								
			String cmd = "C:\\Streamming"
					 + "\\ffmpeg\\bin\\ffmpeg.exe -i "
					 + url+"/"+con_link+" -ss 00:00:05 -vcodec png -vf scale=196*110 "
					 + url+"/"+con_link+".png";
		
			logger.info(cmd);
			run.exec(cmd);
						
		}
		int flag = cs.c_insert(vo);
		
	String pageName = "";
		if(flag>0){
			pageName = "redirect:c_select.do";
		}else{
			pageName = "redirect:c_insert.do";
		}
		
	return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/c_update.do", 
			method = RequestMethod.POST)
	public ModelAndView c_updateOk(@ModelAttribute("uploadForm") ContentVO vo
			,HttpServletRequest request)  throws IllegalStateException, IOException {
		MultipartFile multipartFile = vo.getMultipartFile();
		String url ="C:\\Streamming";
		
		if(null != multipartFile){
			String con_link =null;
			String originName = multipartFile.getOriginalFilename();
			
			Runtime run = Runtime.getRuntime();
			
			if(vo.getCon_writer()==null||vo.getCon_writer()==" "){
				con_link = "anony_"+originName;	
			}else{				
				con_link = vo.getCon_writer()+"_"+originName;	
			}
			
			File orgin_file = new File(url+"/"+con_link);
			multipartFile.transferTo(orgin_file);
			vo.setCon_link(con_link);
								
			String cmd = "C:\\Streamming"
						 + "\\ffmpeg\\bin\\ffmpeg.exe -i "
						 + url+"/"+con_link+" -ss 00:00:05 -vcodec png -vf scale=196*110 "
						 + url+"/"+con_link+".png";
			logger.info(cmd);
			run.exec(cmd);
						
		}
		
		int flag = cs.c_update(vo);
		
		String pageName = "";
		if(flag>0){
			pageName = "redirect:c_select.do";
		}else{
			pageName = "redirect:c_search.do";
		}
		
		return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/c_delete.do", 
			method = RequestMethod.GET)
	public ModelAndView c_deleteOk(ContentVO vo) {
		logger.info(vo.getReplylevel()+"");
		int flag = cs.c_delete(vo);
		
		String pageName = "";
		if(vo.getReplylevel()>0){
			pageName = "redirect:re_select.do";
		}else{
						
			if(flag>0){
				pageName = "redirect:c_select.do";
			}else{
				pageName = "redirect:c_search.do";
			}
		}
		return new ModelAndView(pageName);
	}
	
	@RequestMapping(value = "/c_search.do", 
			method = RequestMethod.GET)
	public String c_search(ContentVO vo,Model model) {
		
		ContentVO cvo = cs.c_search(vo);
		model.addAttribute("cvo",cvo);
		return "contents/c_search";
	}
	
	@RequestMapping(value = "/c_select.do", 
			method = RequestMethod.GET)
	public String c_select(Model model) {
		
		List<ContentVO> clist = cs.c_select();
		model.addAttribute("clist",clist);
		
		return ".c_select";
	}
	
	@RequestMapping(value = "/re_select.do", 
			method = RequestMethod.GET)
	public String re_select(Model model) {
		
		List<ContentVO> rlist = cs.re_select();
		model.addAttribute("rlist",rlist);
		
		return ".re_select";
	}
	
	
	@RequestMapping(value = "/c_searchList.do", 
			method = RequestMethod.POST)
	public String m_searchList(Model model,String key,String value) {
		List<ContentVO> clist = cs.c_select(key, value);
		model.addAttribute("clist",clist);
		return ".c_select";
	}
	
	
	
	
	
	
}
