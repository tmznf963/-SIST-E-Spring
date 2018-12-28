package store.fnfm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import store.fnfm.vo.ProductVO;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int pcodeCheck(String pcode) {
		return this.sqlSession.selectOne("Product.pcodeCheck",pcode);
	}
	@Override
	public int create(ProductVO productVO) {
		return this.sqlSession.insert("Product.insert",productVO);
	}
	
	@Override
	public void insertProduct(ProductVO productVO) {
		this.sqlSession.insert("Product.insertSP",productVO);//namespace.id
	}

	@Override
	public void selectProduct(Map map) {
		this.sqlSession.selectOne("Product.selectOneSP",map);
	}

	@Override
	public void select(Map map) {
		this.sqlSession.selectList("Product.selectAllSP",map);
	}

	@Override
	public void getTotalCount(Map map) {
		this.sqlSession.selectOne("Product.selectTotalCountSP",map);
	}
	
	@Override
	public int updateProduct(ProductVO productVO) {
		return this.sqlSession.update("Product.updateSP", productVO);
	}
	
	@Override
	public void deleteProduct(int idx) {
		this.sqlSession.delete("Product.deleteSP",idx);
	}
	@Override
	public List<ProductVO> list(ProductVO productVO) {
		return this.sqlSession.selectList("Product.searchSelect",productVO);//판매자상품검색List
	}
	@Override
	public void getSearchTotalCount(Map map) {
		this.sqlSession.selectOne("Product.searchTotalCountSP",map);
	}
	@Override
	public void selectSearch(Map map) {
		this.sqlSession.selectList("Product.searchSelectList",map);//판매자상품검색된 list 받아오기
	}

	


}
