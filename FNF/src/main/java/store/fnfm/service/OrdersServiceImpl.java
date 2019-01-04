package store.fnfm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import store.fnfm.dao.OrdersDAO;
import store.fnfm.vo.OrdersVO;

@Service("ordersSerivce")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDAO ordersDAO;

	@Override
	public void selectAll(Map map) {
		this.ordersDAO.selectAll(map);
	}

	@Override
	public void getTotalCount(Map map) {
		this.ordersDAO.getTotalCount(map);
	}

	@Override
	public void selectOne(Map map) {
		this.ordersDAO.selectOne(map);
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
