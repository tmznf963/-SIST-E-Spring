package store.fnfm.service;

import java.util.Map;

import store.fnfm.vo.OrdersVO;

public interface OrdersService {
	void selectAll(Map map);//주문리스트
	void getTotalCount(Map map);//주문리스트페이징
	
	void selectOne(Map map);//주문한개view
	void update(OrdersVO ordersVO);//수정
	
	void SearchAll(Map map);//검색된 주문리스트
	void SearchTotalCount(Map map);//검색결과페이징
	
	void updateStatus(int idx);//주문상태값 변경
}
