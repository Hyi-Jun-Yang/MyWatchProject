package project.com.controller;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.eventlist.EventListService;
import project.com.eventlist.EventListVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EventListController {
	
	private static final Logger logger = LoggerFactory.getLogger(EventListController.class);
	
	public EventListController() {
		logger.info("EventListController....");
	}
	
	EventListService es;

	public EventListService getEs() {
		return es;
	}

	@Autowired
	public void setEs(EventListService es) {
		this.es = es;
	}

	@RequestMapping(value = "/e_insert.do", method = RequestMethod.GET)
	public String e_insert(Model model) {
		logger.info("e_insert...");
		
		return ".e_insert";
	}
	
	@RequestMapping(value = "/e_insertOK.do", method = RequestMethod.POST)
	public ModelAndView e_insertOK(Model model,
			 String e_title,String e_content,int win_count
			 ,String e_end,String e_start) {
		EventListVO vo = new EventListVO();
		
		vo.setE_title(e_title);
		vo.setE_content(e_content);
		vo.setWin_count(win_count);
		
		String temp[] = e_end.split("-");
		int year = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int day = Integer.parseInt(temp[2]);
		long eday = new GregorianCalendar(year, month, day).getTimeInMillis();
		vo.setE_end(new Timestamp(eday));
		
		temp = e_start.split("-");
		year = Integer.parseInt(temp[0]);
		month = Integer.parseInt(temp[1]);
		day = Integer.parseInt(temp[2]);
		long sday = new GregorianCalendar(year, month, day).getTimeInMillis();
		vo.setE_start(new Timestamp(sday));
		
		logger.info("e_insertOK..."+vo.getE_end());
		int in =es.insert(vo);
		if(in>=1){
			return new ModelAndView("redirect:e_select.do");
		}else{
			return new ModelAndView("redirect:e_insert.do");
		}
		
	}
	
	@RequestMapping(value = "/e_updateOK.do", method = RequestMethod.POST)
	public ModelAndView e_updateOK(Model model,EventListVO vo) {
		logger.info("e_updateOK...");
		int up =es.update(vo);
		if(up>=1){
			return new ModelAndView("redirect:e_select.do");
		}else{
			return new ModelAndView("redirect:e_search.do");
		}
		
	}
	
	@RequestMapping(value = "/e_deleteOK.do", method = RequestMethod.GET)
	public ModelAndView e_deleteOK(Model model,EventListVO vo) {
		logger.info("e_deleteOK...");
		int up =es.delete(vo);
		if(up>=1){
			return new ModelAndView("redirect:e_select.do");
		}else{
			return new ModelAndView("redirect:e_select.do");
		}
		
	}
	
	@RequestMapping(value = "/e_search.do", method = RequestMethod.GET)
	public String e_search(Model model,EventListVO vo) {
		logger.info("e_search...");
		EventListVO svo =es.serach(vo);
		model.addAttribute("svo",svo);
		
		return ".e_search";
		
	}
	
	@RequestMapping(value = "/e_select.do", method = RequestMethod.GET)
	public String e_select(Model model) {
		logger.info("e_select...");
		List<EventListVO> list = es.select();
		model.addAttribute("list",list);
		
		return ".e_select";
		
	}
	
	@RequestMapping(value = "/e_searchList.do", method = RequestMethod.POST)
	public String e_searchList(Model model,String searchKey,String searchWord) {
		logger.info("e_searchList..."+searchWord);
		List<EventListVO> list = es.select(searchKey,searchWord);
		
		model.addAttribute("list",list);
		
		return ".e_select";
		
	}
	
	
	
	
}
