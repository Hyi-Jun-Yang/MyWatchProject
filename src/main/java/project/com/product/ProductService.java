package project.com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private ProductDAO dao;

	public ProductDAO getDao() {
		return dao;
	}
	
	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	public int insert(ProductVO vo) {
		
		return dao.insert(vo);
	}

	public int update(ProductVO vo) {
		
		return dao.update(vo);
	}

	public int delete(ProductVO vo) {
		
		return dao.delete(vo);
	}

	public ProductVO search(ProductVO vo) {
		
		return dao.search(vo);
	}

	public List<ProductVO> select() {
		
		return dao.select();
	}

	public List<ProductVO> select(String searchKey, String searchWord) {
		
		return dao.select(searchKey, searchWord);
	}
	
}
