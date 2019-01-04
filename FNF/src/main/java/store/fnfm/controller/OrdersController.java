package store.fnfm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import store.fnfm.service.OrdersService;
import store.fnfm.vo.ProductVO;

//seller전용 Orders

@Controller
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	/** 페이지 이동 **/

	@RequestMapping(value = "/sellerOL", method = RequestMethod.GET)
	public String sellerOL() {
		return "ordersList";//views-->.jsp
	}
	
	//selectAll
		@RequestMapping(value = "/sellerOL/{page}", method = RequestMethod.POST)
		@ResponseBody		//나갈 때 object --> json
		public Map list(@PathVariable int page ,HttpServletRequest request) {
			/**-----------------------------------------------------------------------------**/
			HttpSession Session = request.getSession();
			String sellerid = (String)Session.getAttribute("user_id");
										//sellerid의 세션 값을 String에 저장.
			/**-----------------------------------------------------------------------------**/
			Map<String,Object> countMap = new HashMap<String,Object>();
			countMap.put("sellerid", sellerid); //mapper의 property값에 대입
			this.ordersService.getTotalCount(countMap);
			int totalCount = (Integer)countMap.get("result");
			int pageSize = 10;
			int totalPage = (totalCount%pageSize == 0) ? totalCount/pageSize : totalCount/pageSize +1; //전체페이지
			if(totalPage < page) page = totalPage;
			
			int pageCount = 10; //한 페이지에 뿌릴 수 있는 갯수는 10개씩
			
			int start = (page-1) * pageCount +1;//시작페이지가 1일 때 ex)1
			int end = start + pageCount -1;//끝페이지							ex)10
			
			int startPage = ((page - 1) * pageCount / pageCount) + 1;//2
			int endPage = startPage + pageCount - 1;//11
			if(endPage> totalPage) endPage = totalPage;
			
			Map<String,Object> map = new HashMap<String,Object>();//selectAllSP
			map.put("sellerid", sellerid);
			map.put("start", start);
			map.put("end", end);
			this.ordersService.selectAll(map);
			List<ProductVO> list = (List<ProductVO>)map.get("results");//maaper의 peoperty값
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("code", Boolean.TRUE);
			data.put("startPage", startPage);
			data.put("endPage", endPage);
			data.put("totalPage", totalPage);
			data.put("pageSize", pageSize);
			data.put("page", page);
			data.put("totalCount", totalCount);//상품전체개수
			data.put("data", list);
			return data;
		}
		
		//selectOne-update-page      /fnf/sellerPU/3
		@RequestMapping(value="/sellerOD/{idx}",method=RequestMethod.GET)
		@ResponseBody					//나갈 때 object --> json
		public ModelAndView read_up(@PathVariable String idx) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("idx", idx);// mapper idx에 넣기
			this.ordersService.selectOne(map);
			List<ProductVO> list = (List<ProductVO>)map.get("result");
			ModelAndView mav = new ModelAndView();
			mav.addObject("data",list.get(0));//받는.jsp --> ${data}
			mav.setViewName("ordersDetail");// views --> .jsp
			return mav;
		}
}
