package store.fnfm.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import store.fnfm.vo.ProductVO;


public interface ProductService {
	int pcodeCheck(String pcode);
	int create(ProductVO productVO);//productRegister
	void getTotalCount(Map map);//페이징
	void insertProduct(ProductVO productVO);//productInsert
	void selectProduct(Map map);//productDetail
	void select(Map map);//productList
	int updateProduct(ProductVO	 productVO);//productUpdate
	void deleteProduct(int idx);
	String restore(MultipartFile file);//fileUpload
	List<ProductVO> list(ProductVO productVO);//검색data list 받아오기
	void selectSearch(Map map);//검색된 productList
	void getSearchTotalCount(Map map);//검색결과페이징
}
