package project.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import project.com.entryinfo.EntryInfoService;
import project.com.entryinfo.EntryInfoVO;
import project.com.entryinfo.EventEntry;
import project.com.product.ProductService;
import project.com.product.ProductVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EntryInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(EntryInfoController.class);
	
	public EntryInfoController() {
		logger.info("EntryInfoController....");
	}
	
	EntryInfoService eis;
	ProductService ps;
	

	public ProductService getPs() {
		return ps;
	}
	@Autowired
	public void setPs(ProductService ps) {
		this.ps = ps;
	}

	public EntryInfoService getEis() {
		return eis;
	}

	@Autowired
	public void setEis(EntryInfoService eis) {
		this.eis = eis;
	}

	@RequestMapping(value = "/en_insert.do", method = RequestMethod.GET)
	public String en_insert(Model model) {
		logger.info("en_insert...");
		
		return ".en_insert";
	}
	
	@RequestMapping(value = "/en_insertOK.do", method = RequestMethod.GET)
	public ModelAndView en_insertOK(Model model,
		 String c_name,String c_tel,String e_office) {
		 EventEntry ent = new EventEntry();
		 int[] eResult = ent.getEntryResult();
		 EntryInfoVO vo = new EntryInfoVO();
		 vo.setC_name(c_name);
		 vo.setC_tel(c_tel);
		 vo.setE_id(eResult[0]);
		 vo.setIs_win(eResult[1]);
		 vo.setWin_rank(eResult[2]);
		 vo.setP_num(eResult[3]);
		 vo.setE_office(e_office);
		int in =eis.insert(vo);
		logger.info("en_insertOK..."+in);
		if(in>=1){
			model.addAttribute("c_tel",c_tel);
			return new ModelAndView("redirect:en_result.do");
		}else{
			return new ModelAndView("redirect:cu_insert.do");//cu_insert.do
		}
		
	}
	
	@RequestMapping(value = "/en_result.do", method = RequestMethod.GET)
	public String en_result(Model model,String c_tel) {
		logger.info("en_result..."+c_tel);

		ProductVO pvo = new ProductVO();
		
		List<EntryInfoVO> list =eis.select("c_tel", c_tel);
		logger.info("en_result..."+list.get(0).getP_num());
		pvo.setP_num(list.get(0).getP_num());
		pvo=ps.search(pvo);
		for (EntryInfoVO evo : list) {
			model.addAttribute("evo",evo);
		}
				
		model.addAttribute("pvo",pvo);
		
		return "entryinfo/en_result";
		
	}
	
	
	
	@RequestMapping(value = "/en_updateOK.do", method = RequestMethod.POST)
	public ModelAndView en_updateOK(Model model,String take_result,
			String take_office,int e_num) {
		EntryInfoVO vo = new EntryInfoVO();
		if(take_result.compareTo("on")==0){
			vo.setTake_result(1);
		}else{
			vo.setTake_result(0);
		}
		
		vo.setTake_office(take_office);
		vo.setE_num(e_num);
		
		
		logger.info("en_updateOK...");
		int up =eis.update(vo);
		if(up>=1){
			return new ModelAndView("redirect:en_select.do");
		}else{
			return new ModelAndView("redirect:en_search.do");
		}
		
	}
	
	@RequestMapping(value = "/en_deleteOK.do", method = RequestMethod.GET)
	public ModelAndView en_deleteOK(Model model,EntryInfoVO vo) {
		logger.info("en_deleteOK...");
		int up =eis.delete(vo);
		if(up>=1){
			return new ModelAndView("redirect:en_select.do");
		}else{
			return new ModelAndView("redirect:en_select.do");
		}
		
	}
	
	@RequestMapping(value = "/en_search.do", method = RequestMethod.GET)
	public String en_search(Model model,EntryInfoVO vo) {
		logger.info("en_search...");
		EntryInfoVO svo =eis.search(vo);
		model.addAttribute("svo",svo);
		
		return ".en_search";
		
	}
	
	@RequestMapping(value = "/en_select.do", method = RequestMethod.GET)
	public String en_select(Model model) {
		logger.info("en_select...");
		List<EntryInfoVO> list = eis.select();
		model.addAttribute("list",list);
		
		return ".en_select";
		
	}
	
	@RequestMapping(value = "/en_searchList.do", method = RequestMethod.POST)
	public String en_searchList(Model model,String searchKey,String searchWord) {
		logger.info("en_searchList..."+searchWord);
		List<EntryInfoVO> list = eis.select(searchKey,searchWord);
		
		model.addAttribute("list",list);
		
		return ".en_select";
		
	}
	
	
	
	
}
