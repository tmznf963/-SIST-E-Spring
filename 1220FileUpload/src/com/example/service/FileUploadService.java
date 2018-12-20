package com.example.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("fileuploadService")
public class FileUploadService {
	private final String PATH = "/upload";
	//Windows의 경우에는 JVM이 자동으로 workspace의 drive를 인식한다.
	public String restore(MultipartFile multipartFile) {//uri 넘어오니깐 return String;
		String uri = null;
		try {
			String originalName = multipartFile.getOriginalFilename();
			String extName = originalName.substring(originalName.lastIndexOf("."),  originalName.length());
			long fileSize = multipartFile.getSize();
			String savedFileName = this.generateSavedName(extName);
			
			System.out.println("originalName = " + originalName);
			System.out.println("extName = " + extName);//확장자
			System.out.println("fileSize = " + fileSize);
			System.out.println("저장될 파일 이름 : "+ savedFileName);
			
			saveToFileSystem(multipartFile, savedFileName);
			uri = "upload/" + savedFileName;
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return uri;
	}
	private void saveToFileSystem(MultipartFile mFile, String savedFileName)throws IOException {
		byte[] buffers = mFile.getBytes();
		File file = new File(this.PATH + "/" + savedFileName);// C:/upload/20181220112317266.jpg
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
}
