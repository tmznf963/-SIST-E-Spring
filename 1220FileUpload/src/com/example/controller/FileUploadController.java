package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadService fileuploadService;
	
	@RequestMapping(value="/upload",method= RequestMethod.POST)
	public String upload(@RequestParam("username") String username,
											@RequestParam("file1") MultipartFile file, Model model) {
		String uri = this.fileuploadService.restore(file);
		model.addAttribute("username",username);
		model.addAttribute("uri",uri);
		return "result.jsp";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		return "form.jsp";
	}
}
