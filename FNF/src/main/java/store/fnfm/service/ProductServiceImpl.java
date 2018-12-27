package store.fnfm.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import store.fnfm.dao.ProductDAO;
import store.fnfm.vo.ProductVO;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public int pcodeCheck(String pcode) {
		return this.productDAO.pcodeCheck(pcode);
	}
	@Override
	public int create(ProductVO productVO) {
		return this.productDAO.create(productVO);
	}
	@Override
	public void insertProduct(ProductVO productVO) {
		this.productDAO.insertProduct(productVO);
	}

	@Override
	public void selectProduct(Map map) {
		this.productDAO.selectProduct(map);
	}

	@Override
	public void select(Map map) {
		this.productDAO.select(map);
	}

	@Override
	public int updateProduct(ProductVO productVO) {
		return this.productDAO.updateProduct(productVO);
	}
	@Override
	public void deleteProduct(int idx) {
		this.productDAO.deleteProduct(idx);
	}
	
	@Override
	public void getTotalCount(Map map) {
		this.productDAO.getTotalCount(map);
	}
	
	/**####################################################**/
	/**파일업로드**/
	/**####################################################**/
	private final String PATH = "/SpringHome/FNF/src/main/webapp/static/img";	//저장할 폴더
	//Windows의 경우에는 JVM이 자동으로 workspace의 drive를 인식한다.
	public String restore(MultipartFile multipartFile) {//filename에 넣어야하니 return String;
		String savedFileName=null;
		try {
			String originalName = multipartFile.getOriginalFilename();
			String extName = originalName.substring(originalName.lastIndexOf("."),  originalName.length());
			long fileSize = multipartFile.getSize();
			savedFileName = this.generateSavedName(extName);
			/*
			System.out.println("originalName = " + originalName);//originalName = 감자.jpg
			System.out.println("extName = " + extName);//extName = .jpg
			System.out.println("fileSize = " + fileSize);//fileSize = 16670
			System.out.println("저장될 파일 이름 : "+ savedFileName);//2018122523163260.jpg
			 */
			saveToFileSystem(multipartFile, savedFileName);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return savedFileName;
	}
	private void saveToFileSystem(MultipartFile mFile, String savedFileName)throws IOException {
		byte[] buffers = mFile.getBytes();
		File file = new File(this.PATH + "/" + savedFileName);// C:/~/20181220112317266.jpg
		System.out.println(file);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(buffers);
		fos.close();
	}
	private String generateSavedName(String extName) {
		String newName= "";
		Calendar now = Calendar.getInstance();
		newName += now.get(Calendar.YEAR);//yyyy
		newName += now.get(Calendar.MONTH)+1;//mm
		newName += now.get(Calendar.DATE);//dd
		newName += now.get(Calendar.HOUR_OF_DAY);//hh
		newName += now.get(Calendar.MINUTE);//MM
		newName += now.get(Calendar.SECOND);//ss
		newName += now.get(Calendar.MILLISECOND);//ms
		newName += extName;//확장자
		return newName;
	}
	/**####################################################**/
	/**파일업로드**/
	/**####################################################**/
	
	@Override
	public List<ProductVO> list(ProductVO productVO) {
		return this.productDAO.list(productVO);//상품검색된 list 받아오기
	}

	

}//class
