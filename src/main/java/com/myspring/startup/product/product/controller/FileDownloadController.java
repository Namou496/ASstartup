package com.myspring.startup.product.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FileDownloadController {
	private static String CURR_FILE_REPO_PATH = "D:\\작업";
//	private static String CURR_FILE_REPO_PATH = "C:\\Users\\du2sa\\Desktop\\work\\Java\\test\\startUp";
	
	@RequestMapping("/download")
	protected void download(@RequestParam(value="useManual", required = false) String useManual,
							@RequestParam(value="asManual", required = false) String asManual,
							@RequestParam(value="productImage", required = false) String productImage,
							@RequestParam(value="productName", required = false) String productName,
							@RequestParam(value="filePart", required = false) int filePart,
							HttpServletResponse response) throws Exception{
//		int filePart = 1:useManual, 2:asManual, 3:productImage
		String _useManual = CURR_FILE_REPO_PATH + "\\manufacturer\\" + productName + "\\" + "useManual" + "\\" + useManual;
		String _asManual = CURR_FILE_REPO_PATH + "\\manufacturer\\" + productName + "\\" + "asManual" + "\\" + asManual;
		String _productImage = CURR_FILE_REPO_PATH + "\\manufacturer\\" + productName + "\\" + productImage;
		
		File file;
		OutputStream out = response.getOutputStream();
		response.setHeader("Cache-Control", "no-cache");
			if(filePart == 1) {
				file = new File(_useManual);
				response.addHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(useManual, "utf-8") + ";");
			} else if(filePart == 2){
				file = new File(_asManual);
				response.addHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(asManual, "utf-8") + ";");
			} else {
				file = new File(_productImage);
				response.addHeader("Content-disposition", "attachment; fileName=" + URLEncoder.encode(productImage, "utf-8") + ";");
			}
		
		FileInputStream in = new FileInputStream(file);
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count == -1) break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}
}
