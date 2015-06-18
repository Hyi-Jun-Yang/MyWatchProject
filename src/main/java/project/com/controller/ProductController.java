package project.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.com.product.ProductService;
import project.com.product.ProductVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	public ProductController() {
		logger.info("ProductController....");
	}
	ProductService ps;
	
	
	public ProductService getPs() {
		return ps;
	}
	
	@Autowired
	public void setPs(ProductService ps) {
		this.ps = ps;
	}

	@RequestMapping(value = "/p_insert.do", method = RequestMethod.GET)
	public String p_insert(Model model) {
		logger.info("p_insert...");
		
		return ".p_insert";
	}
	
	@RequestMapping(value = "/p_insertOK.do", method = RequestMethod.POST)
	public ModelAndView p_insertOK(Model model,ProductVO vo) {
		logger.info("p_insertOK...");
		int in =ps.insert(vo);
		if(in>=1){
			return new ModelAndView("redirect:p_select.do");
		}else{
			return new ModelAndView("redirect:p_insert.do");
		}
		
	}
	
	@RequestMapping(value = "/p_updateOK.do", method = RequestMethod.POST)
	public ModelAndView p_updateOK(Model model,ProductVO vo) {
		logger.info("p_updateOK...");
		int up =ps.update(vo);
		if(up>=1){
			return new ModelAndView("redirect:p_select.do");
		}else{
			return new ModelAndView("redirect:p_search.do");
		}
		
	}
	
	@RequestMapping(value = "/p_deleteOK.do", method = RequestMethod.GET)
	public ModelAndView p_deleteOK(Model model,ProductVO vo) {
		logger.info("p_deleteOK...");
		int up =ps.delete(vo);
		if(up>=1){
			return new ModelAndView("redirect:p_select.do");
		}else{
			return new ModelAndView("redirect:p_select.do");
		}
		
	}
	
	@RequestMapping(value = "/p_search.do", method = RequestMethod.GET)
	public String p_search(Model model,ProductVO vo) {
		logger.info("p_search...");
		ProductVO svo =ps.search(vo);
		model.addAttribute("svo",svo);
		
		return ".p_search";
		
	}
	
	@RequestMapping(value = "/p_select.do", method = RequestMethod.GET)
	public String p_select(Model model) {
		logger.info("p_select...");
		List<ProductVO> list = ps.select();
		model.addAttribute("list",list);
		
		return ".p_select";
		
	}
	
	@RequestMapping(value = "/p_searchList.do", method = RequestMethod.POST)
	public String p_searchList(Model model,String searchKey,String searchWord) {
		logger.info("p_searchList..."+searchWord);
		List<ProductVO> list = ps.select(searchKey,searchWord);
		
		model.addAttribute("list",list);
		
		return ".p_select";
		
	}
	
	
	
	
}
