package store.fnfm.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import store.fnfm.vo.OrdersVO;

@Repository("ordersDAO")
public class OrdersDAOImpl implements OrdersDAO {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void selectAll(Map map) {
		this.sqlSession.selectList("Orders.ordersSelectAll",map);
	}

	@Override
	public void getTotalCount(Map map) {
		this.sqlSession.selectOne("Orders.ordersTotalCount",map);
	}

	@Override
	public void selectOne(Map map) {
		this.sqlSession.selectOne("Orders.ordersSelectOne",map);
	}

	@Override
	public void update(OrdersVO ordersVO) {

	}

	@Override
	public void SearchAll(Map map) {

	}

	@Override
	public void SearchTotalCount(Map map) {

	}

	@Override
	public void updateStatus(int idx) {

	}

}
