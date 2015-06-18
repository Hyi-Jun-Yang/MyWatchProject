package project.com.product;

import java.util.List;

public interface ProductDAO {
	public int insert(ProductVO vo);
	public int update(ProductVO vo);
	public int delete(ProductVO vo);
	public ProductVO search(ProductVO vo);
	public List<ProductVO> select();
	public List<ProductVO> select(String Skey,String Sword);
}
