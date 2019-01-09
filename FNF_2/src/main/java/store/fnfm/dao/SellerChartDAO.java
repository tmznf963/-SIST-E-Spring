package store.fnfm.dao;

import java.util.Map;

public interface SellerChartDAO {
	void productChart(Map map);//상품별 판매수
	void productPrice(Map map);//상품별 판매액
	void MCount(Map map);//무통장 결제 수
	void KCount(Map map);//카카오페이 결제 수
}
