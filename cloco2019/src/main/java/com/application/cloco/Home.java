package com.application.cloco;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.convertapi.Config;
import com.convertapi.ConversionResult;
import com.convertapi.ConversionResultFile;
import com.convertapi.ConvertApi;
import com.convertapi.Param;

@RestController
public class Home {
	
	
	@RequestMapping("/")
	ModelAndView User(ModelAndView modelAndView) {
		
		modelAndView.setViewName("User");
		//modelAndView.getModel().put("name", "Mouadh");
 
		return modelAndView;
	}
	@RequestMapping("/save")
	ModelAndView Save(ModelAndView modelAndView) {
		
		modelAndView.setViewName("Home");
		//modelAndView.getModel().put("name", "Mouadh");
 
		return modelAndView;
	}
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	ModelAndView upload(ModelAndView modelAndView,@RequestParam("file1") MultipartFile file,@RequestParam("option") String option,@RequestParam("email") String email) throws Exception {
		Config.setDefaultSecret("H8SY93p8QvYJ9Nhv");
		 CompletableFuture<ConversionResult> result = null;
String filenew = null;
if(!file.isEmpty()) {
		
		   	
			byte[] bytes = file.getBytes();
			String rootPath = System.getProperty("catalina.home");
			
		
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();
		
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator +file.getOriginalFilename());
			
		
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			String path=serverFile.getAbsolutePath();
			String a=dir.getAbsolutePath()
					+ File.separator +file.getOriginalFilename();
		  if(option.equals("wordtopdf")) {
			  // result = ConvertApi.convert("docx", "pdf",new Param("file",a) );
			   //result= ConvertApi.convert(a, "pdf", new Param("file",a));
			  result=ConvertApi.convert("docx", "pdf", new Param("file", Paths.get(a)));
			  
		  }
		  if(option.equals("pdftoword")) {
			  // result = ConvertApi.convert("docx", "pdf",new Param("file",a) );
			   //result= ConvertApi.convert(a, "pdf", new Param("file",a));
			  result=ConvertApi.convert("pdf", "docx", new Param("file", Paths.get(a)));
			  
		  }
		  if(option.equals("pdftopptx")) {
			  // result = ConvertApi.convert("docx", "pdf",new Param("file",a) );
			   //result= ConvertApi.convert(a, "pdf", new Param("file",a));
			  result=ConvertApi.convert("pdf", "pptx", new Param("file", Paths.get(a)));
			  
		  }
		  if(option.equals("pptxtopdf")) {
			  // result = ConvertApi.convert("docx", "pdf",new Param("file",a) );
			   //result= ConvertApi.convert(a, "pdf", new Param("file",a));
			  result=ConvertApi.convert("pptx", "pdf", new Param("file", Paths.get(a)));
			  
		  }
		  if(option.equals("pptxtopdf")) {
			  // result = ConvertApi.convert("docx", "pdf",new Param("file",a) );
			   //result= ConvertApi.convert(a, "pdf", new Param("file",a));
			  result=ConvertApi.convert("pptx", "pdf", new Param("file", Paths.get(a)));
			  
		  }
		 
		 
		  
		  filenew = result.get().getFile(0).getUrl();
		  EnvoyerEmail gmail=new EnvoyerEmail();
		  gmail.mail(email, "votre document is ready :"+filenew);
		 modelAndView.setViewName("Home");
			modelAndView.getModel().put("path", filenew);
			modelAndView.getModel().put("email",email);
		
		
}
return  modelAndView;
	}
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	ModelAndView Login(ModelAndView modelAndView,@RequestParam("email")String email) {
		
		
		
		modelAndView.setViewName("Home");
		modelAndView.getModel().put("email", email);
 
		return modelAndView;
	}
}