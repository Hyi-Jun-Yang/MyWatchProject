package project.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.com.cust.CustService;
import project.com.cust.CustVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustController.class);
	
	public CustController() {
		logger.info("CustController....");
	}
	CustService cs;
	
	
	public CustService getCs() {
		return cs;
	}

	@Autowired
	public void setCs(CustService cs) {
		this.cs = cs;
	}

	@RequestMapping(value = "/cu_insert.do", method = RequestMethod.GET)
	public String cu_insert(Model model) {
		logger.info("cu_insert...");
		
		return "cust/cu_insert";
	}
	
	
	@RequestMapping(value = "/cu_insertOK.do", method = RequestMethod.POST)
	public String cu_insertOK(Model model,CustVO vo,String e_office){
				
		int in =cs.insert(vo);
		if(in>=1){
			model.addAttribute("c_name", vo.getC_name());
			model.addAttribute("c_tel", vo.getC_tel());
			model.addAttribute("e_office", e_office);
			return "redirect:en_insertOK.do";
		}else{
			return "redirect:cu_insertOK.do";	
		}
			
	}
	
	@RequestMapping(value = "/telCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> telCheck(Model model,CustVO vo,String e_office){
		logger.info("telCheck...");
		Map<String,String> map = new HashMap<String, String>();
		
		if(cs.search(vo)==null){
			map.put("result","success");
			
		}else{
			map.put("result","fail");
		}
		
		return map;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/cu_updateOK.do", method = RequestMethod.POST)
	public ModelAndView cu_updateOK(Model model,CustVO vo) {
		logger.info("cu_updateOK...");
		int up =cs.update(vo);
		if(up>=1){
			return new ModelAndView("redirect:cu_select.do");
		}else{
			return new ModelAndView("redirect:cu_search.do");
		}
		
	}
	
	@RequestMapping(value = "/cu_deleteOK.do", method = RequestMethod.GET)
	public ModelAndView cu_deleteOK(Model model,CustVO vo) {
		logger.info("cu_deleteOK...");
		int up =cs.delete(vo);
		if(up>=1){
			return new ModelAndView("redirect:cu_select.do");
		}else{
			return new ModelAndView("redirect:cu_select.do");
		}
		
	}
	
	@RequestMapping(value = "/cu_search.do", method = RequestMethod.GET)
	public String cu_search(Model model,CustVO vo) {
		logger.info("cu_search...");
		CustVO svo =cs.search(vo);
		model.addAttribute("svo",svo);
		
		return ".cu_search";
		
	}
	
	@RequestMapping(value = "/cu_select.do", method = RequestMethod.GET)
	public String cu_select(Model model) {
		logger.info("cu_select...");
		List<CustVO> list = cs.select();
		model.addAttribute("list",list);
		
		return ".cu_select";
		
	}
	
	@RequestMapping(value = "/cu_searchList.do", method = RequestMethod.POST)
	public String cu_searchList(Model model,String searchKey,String searchWord) {
		logger.info("cu_searchList..."+searchWord);
		List<CustVO> list = cs.select(searchKey,searchWord);
		for (int i = 0; i < list.size(); i++) {
			
			logger.info(list.get(i).getC_name());
		}
		
		model.addAttribute("list",list);
		
		return ".cu_select";
		
	}
	
	@RequestMapping(value = "/popup.do", method = RequestMethod.GET)
	public String popup(Model model,CustVO vo){
		List<CustVO> dongList=cs.dongList();
		model.addAttribute("dongList",dongList);
		logger.info(vo.getDong());
		return "cust/popup";
	}
	

	
	
	
	@RequestMapping(value = "/zipcodeSearch.do", method = RequestMethod.POST)
	public String zipcodeSearch(Model model,CustVO vo) {
		logger.info("/zipcodeSearch"+vo.getDong());
		List<CustVO> zipcode = cs.zipcode(vo);
		model.addAttribute("zipcode",zipcode );
		return "cust/popup";
	}
	
	
}
