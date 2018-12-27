package store.fnfm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import store.fnfm.service.ProductService;
import store.fnfm.vo.ProductVO;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
													
	
	/** 페이지 이동 **/
	//http://localhost:8080/fnf/sellerPL
	@RequestMapping(value = "/sellerPL", method = RequestMethod.GET)
	public String sellerPL() {
		return "productList";//views-->.jsp
	}
	@RequestMapping(value = "/sellerPR", method = RequestMethod.GET)
	public String sellerPR() {
		return "productRegister";//views-->.jsp
	}

	//selectOne-update-page      /fnf/sellerPU/3
	@RequestMapping(value="/sellerPU/{idx}",method=RequestMethod.GET)
	@ResponseBody					//나갈 때 object --> json
	public ModelAndView read_up(@PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);// mapper idx에 넣기
		this.productService.selectProduct(map);
		List<ProductVO> list = (List<ProductVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list.get(0));//받는.jsp --> ${data}
		mav.setViewName("productUpdate");// views --> .jsp
		return mav;
	}
	//productUpdate
	@RequestMapping(value="/sellerPU/{idx}",method=RequestMethod.POST)
	public String update(@PathVariable int idx, 
									ProductVO productVO,
									@RequestParam("file1") MultipartFile file, Model model) {
		productVO.setIdx(idx);
		
		String DBfilename = this.productService.restore(file);//file 없으면 null
		String filename = productVO.getFilename();
		if(DBfilename != null) {//file이 있으면
			productVO.setFilename(DBfilename);
		}else {//file이 없으면
			productVO.setFilename(filename);
		}
		
		String category = productVO.getCategory().split(">")[0];//ex) 농산물>과일
		String category2 = productVO.getCategory().split(">")[1];
		productVO.setCategory(category);
		productVO.setCategory2(category2);
		
		int row = this.productService.updateProduct(productVO);
		
		if(row == -1) model.addAttribute("status", 2);//성공
		else model.addAttribute("status", 3);//실패	 .jsp --> ${status}
		return "productRegister_ok";//veiws --> .jsp
	}
	
	//selectAll
	@RequestMapping(value = "/sellerPL/{page}", method = RequestMethod.POST)
	@ResponseBody		//나갈 때 object --> json
	public Map list(@PathVariable int page ,HttpServletRequest request) {
		/**-----------------------------------------------------------------------------**/
		HttpSession Session = request.getSession();
		String sellerid = (String)Session.getAttribute("sellerid");
									//sellerid의 세션 값을 String에 저장.
		/**-----------------------------------------------------------------------------**/
		Map<String,Object> countMap = new HashMap<String,Object>();
		countMap.put("sellerid", sellerid); //mapper의 property값에 대입
		this.productService.getTotalCount(countMap);
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
		this.productService.select(map);
		List<ProductVO> list = (List<ProductVO>)map.get("results");//maaper의 peoperty값
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", Boolean.TRUE);
		data.put("startPage", startPage);
		data.put("endPage", endPage);
		data.put("totalPage", totalPage);
		data.put("pageSize", pageSize);
		data.put("page", page);
		data.put("data", list);
		return data;
	}
	
	//selectOne-detail 		         /sellerPD/3
	@RequestMapping(value="/sellerPD/{idx}",method=RequestMethod.GET)
	@ResponseBody					//나갈 때 object --> json
	public ModelAndView read(@PathVariable int idx) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idx", idx);// mapper idx에 넣기
		this.productService.selectProduct(map);
		List<ProductVO> list = (List<ProductVO>)map.get("result");
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",list.get(0));//받는.jsp --> ${data}
		mav.setViewName("productDetail");// views --> .jsp
		return mav;
	}
	
	//ProductInsert & fileUpload
	@RequestMapping(value="/sellerPR",method= RequestMethod.POST)
	public String upload(@RequestParam("sellerid") String sellerid,
	         @RequestParam("pcode") String pcode,
	         @RequestParam("pname") String pname,
	         @RequestParam("pcontents") String pcontents,
	         @RequestParam("origin") String origin,
	         @RequestParam("unit") String unit,
	         @RequestParam("category") String category,
	         @RequestParam("category2") String category2,
	         @RequestParam("stock") int stock,
	         @RequestParam("price") int price,
	         @RequestParam("filename") MultipartFile file, Model model){
		String DBfilename = this.productService.restore(file);//img파일 저장시키기
		
		ProductVO productVO = new ProductVO();
		//input type="text" 에 있는것들은 모두 처리 해줘야 함.
	      pname = pname.replaceAll("<","&lt;");
	      pname = pname.replaceAll(">","&gt;");
	      pname = pname.replaceAll("'","''");//db에서 오류남 ' 쓰면
	      
	      pcontents = pcontents.replaceAll("<","&lt;");
	      pcontents = pcontents.replaceAll(">","&gt;");
	      pcontents = pcontents.replaceAll("'","''");
	      pcontents = pcontents.replaceAll("\r\n", "<br/>");//Enter
		
	    productVO.setSellerid(sellerid);
	    productVO.setPcode(pcode);
	    productVO.setPname(pname);
	    productVO.setPcontents(pcontents);
	    productVO.setOrigin(origin);
	    productVO.setUnit(unit);
	    productVO.setCategory(category);
	    productVO.setCategory2(category2);
	    productVO.setStock(stock);
	    productVO.setPrice(price);
	    productVO.setFilename(DBfilename);
	      
		int row = this.productService.create(productVO);
		if(row == 1) model.addAttribute("status", row);
		else model.addAttribute("status", row);//.jsp --> ${status}
		return "productRegister_ok";//veiws --> .jsp
	}
	
	//상품코드 중복확인
 	@RequestMapping(value="/pcodecheck", method=RequestMethod.POST)
    @ResponseBody
    public Map<Object, Object> pcodecheck(@RequestBody String pcode) {
 		Map<Object, Object> map = new HashMap<Object, Object>();
 		if(pcode.replaceAll(" ","").equals("") || pcode == "") {//pcode의 값이 없을 때
        	map.put("cnt", -1);
        	return map;
        }else {
        	pcode = pcode.replaceAll(" ","");//공백제거
	        int count = 0;
	        count = this.productService.pcodeCheck(pcode);
	        map.put("cnt", count);
	 
	        return map;
        }
    }
 	
 	//상품삭제
	@RequestMapping(value="/sellerPL/{idx}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map delete(@PathVariable int idx) {
		this.productService.deleteProduct(idx);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", Boolean.TRUE);
		return map;
	}
	
	//상품검색
	@RequestMapping(value = "/sellerPL/dataSearch", method = RequestMethod.POST)
	@ResponseBody		//나갈 때 object --> json
	public Map SerachProduct(@RequestBody ProductVO productVO,
														HttpServletRequest request) {
		/**-----------------------------------------------------------------------------**/
		HttpSession Session = request.getSession();
		String sellerid = (String)Session.getAttribute("sellerid");
									//sellerid의 세션 값을 String에 저장.
		/**-----------------------------------------------------------------------------**/
		productVO.setSellerid(sellerid);
//		System.out.println(productVO);
//		return null;
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProductVO> list = this.productService.list(productVO);
		map.put("code", Boolean.TRUE);
		map.put("data", list);
		return map;
	}
}
