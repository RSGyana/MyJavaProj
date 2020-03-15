package in.nit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import in.nit.model.Document;
import in.nit.service.IDocumentservice;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	@Autowired
	private IDocumentservice service;
	 
	//show document upload page
	@RequestMapping("/show")
	public String ShowUploadPage(Model model) {
		List<Object[]> list=service.getFileIdAndNames();
		model.addAttribute("list",list);
		
		return "Documents";
	}
	//UPLOAD DOC/DATA INTO DATABASE 
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public String UploadDoc(@RequestParam Integer fileId,@RequestParam CommonsMultipartFile fileob,Model model) {
		if(fileob!=null) {
			Document doc=new Document();
			doc.setFileId(fileId);
			doc.setFileName(fileob.getOriginalFilename());
			doc.setFileData(fileob.getBytes());
			service.saveDocument(doc);
			String message=fileId+"is uploaded";
			model.addAttribute("message",message);
		}
		return "redirect:show";
	}
	@RequestMapping("/download")
	public void Download(@RequestParam Integer fid,HttpServletResponse resp) {
		//read one object based on id
		Document doc=service.getOneDocument(fid);
		resp.addHeader("Content-Disposition","attachment;+doc.getfileName()");
		try {
			//copy data to os
			FileCopyUtils.copy(doc.getFileData(), resp.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
